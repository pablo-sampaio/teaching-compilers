package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.ast.expression.Expression;
import microc.symbol_table.SymbolTable;


public class While extends BranchCommand {
	private Expression testExpression;
	private Command command;
	
	public While(Expression e, Command c) {
		testExpression = e;
		command = c;
	}


	@Override
	public void verifySemantic() throws SemanticException {
		testExpression.verifySemantic();
		
		if (testExpression.getType() != Type.INT) {
			throw new SemanticException("A expressao de teste do \"while\" tem tipo invalido: \"" 
					                    + testExpression.getType() + "\".");
		}

		command.verifySemantic();
	}

	@Override
	public void generateCode(PrintStream out) {
		String labelCondition = SymbolTable.instance.getNewLabel();
		String labelNext = SymbolTable.instance.getNewLabel();
		
		String varExp;
		
		out.println(labelCondition + ":");
		varExp = testExpression.generateCode(out);
		
		out.println("ifFalse " + varExp + " goto " + labelNext);
		
		command.generateCode(out);
		out.println("goto " + labelCondition);
		
		out.println(labelNext + ":");		
	}

}
