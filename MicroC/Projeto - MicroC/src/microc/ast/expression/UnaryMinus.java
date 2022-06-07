package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.symbol_table.SymbolTable;

public class UnaryMinus implements Expression {
	private Expression operand;
	private Type type;

	public UnaryMinus(Expression e) {
		operand = e;
	}

	@Override
	public Type getType() {
		return type;
	}	

	@Override
	public void verifySemantic() throws SemanticException {
		Type operandType;
		
		operand.verifySemantic();
		operandType = operand.getType();
		
		if (operandType == Type.INT) {
			type = Type.INT;
		} else if (operandType == Type.FLOAT) {
			type = Type.FLOAT;
		} else {
			throw new SemanticException("O operador - (unário) não aceita operando do tipo: \""
					                    + operandType + "\".");
		}
		
	}

	@Override
	public String generateCode(PrintStream out) {
		String varResult = SymbolTable.instance.getNewTemporary();
		String varExp = operand.generateCode(out);
		
		out.println(varResult + " = - " + varExp);
		
		return varResult;
	}

}
