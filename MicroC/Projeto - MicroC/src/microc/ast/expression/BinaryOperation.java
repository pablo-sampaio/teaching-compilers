package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class BinaryOperation implements Expression {
	private Expression operand1;
	private Expression operand2;
	private String operator;
	private Type type;

	public BinaryOperation(String op, Expression e1, Expression e2) {
		operator = op;
		operand1 = e1;
		operand2 = e2;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void verifySemantic() throws SemanticException {
		
		operand1.verifySemantic();
		operand2.verifySemantic();

		if (operator.equals("+") || operator.equals("-")) {
			verifyRule2andRule1();
		
		} else if (operator.equals("*") || operator.equals("/")) {
			verifyRule1();
		
		} else if (operator.equals("<") || operator.equals("<=") 
				    || operator.equals(">") || operator.equals(">=")) {
			verifyRule3();
		
		} else if (operator.equals("==") || operator.equals("!=")) {
			verifyRule4();
		
		} else if (operator.equals("&&") || operator.equals("||")) {
			verifyRule5();
		
		} else {
			throw new RuntimeException("Internal error - unknown operator.");
		
		}
		
	}
	
	private SemanticException createExcetion(Type tp1, Type tp2) {
		return new SemanticException("A operacao \"" + operator + "\" não suporta operandos "
                                     + "de tipos \"" + tp1 + "\" e \"" + tp2 + "\".");
	}

	// para "+", "-", "*" e "/"
	private void verifyRule1() throws SemanticException {
		Type operandType1 = operand1.getType();
		Type operandType2 = operand2.getType();
		
		if ( (operandType1 == Type.INT || operandType1 == Type.FLOAT)
				&& (operandType2 == operandType1) ) {
			type = operandType1;
			
		} else {
			throw createExcetion(operandType1, operandType2);
			
		}
		
	}

	// para "+" e "-"
	private void verifyRule2andRule1() throws SemanticException {
		Type operandType1 = operand1.getType();
		Type operandType2 = operand2.getType();
		
		if (operandType1 == Type.CHAR) {
			if (operandType2 == Type.INT) {
				type = Type.CHAR;
			} else {
				throw createExcetion(operandType1, operandType2);
			}
		
		} else {
			verifyRule1();
			
		}
		
	}
	
	// para "<", "<=", ">" e ">=" 
	private void verifyRule3() throws SemanticException {
		Type operandType1 = operand1.getType();
		Type operandType2 = operand2.getType();
		
		if ( (operandType1 == Type.INT || operandType1 == Type.FLOAT)
				&& (operandType2 == operandType1) ) {
			type = Type.INT;
			
		} else {
			throw createExcetion(operandType1, operandType2);
		}

	}

	// para "==" e "!="
	private void verifyRule4() throws SemanticException {
		Type operandType1 = operand1.getType();
		Type operandType2 = operand2.getType();
		
		if ( (operandType1 == Type.INT || operandType1 == Type.FLOAT || operandType1 == Type.CHAR)
				&& (operandType2 == operandType1) ) {
			type = Type.INT;
			
		} else {
			throw createExcetion(operandType1, operandType2);
		}

	}

	// para "&&" e "||"
	private void verifyRule5() throws SemanticException {
		Type operandType1 = operand1.getType();
		Type operandType2 = operand2.getType();
		
		if (operandType1 == Type.INT  && operandType2 == Type.INT) {
			type = Type.INT;
		
		} else {
			throw createExcetion(operandType1, operandType2);
		
		}

	}

	@Override
	public String generateCode(PrintStream out) {
		String varResult = SymbolTable.instance.getNewTemporary();
		
		String varExp1 = operand1.generateCode(out);
		String varExp2 = operand2.generateCode(out);
		
		out.println(varResult + " = " + varExp1 + " " + operator + " " + varExp2);
		
		return varResult;
	}	

}
