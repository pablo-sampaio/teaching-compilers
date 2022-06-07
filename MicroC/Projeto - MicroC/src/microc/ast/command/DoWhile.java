package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.ast.expression.Expression;
import microc.symbol_table.SymbolTable;

public class DoWhile extends BranchCommand {
	private Expression testExpression;
	private Command command;
	
	public DoWhile(Command c, Expression e) {
		command = c;
		testExpression = e;
	}


	@Override
	public void verifySemantic() throws SemanticException {
		command.verifySemantic();
		testExpression.verifySemantic();
		
		if (testExpression.getType() != Type.INT) {
			throw new SemanticException("A expressao de teste do \"do-while\" tem tipo invalido: \"" 
					                    + testExpression.getType() + "\".");
		}

	}

	@Override
	public void generateCode(PrintStream out) {
		String labelStart = SymbolTable.instance.getNewLabel();
		String varExp;
		
		out.println(labelStart + ":");
		command.generateCode(out);

		varExp = testExpression.generateCode(out);
		out.println("if " + varExp + " goto " + labelStart);

	}

}
