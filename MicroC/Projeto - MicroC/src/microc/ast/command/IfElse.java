package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.ast.expression.Expression;
import microc.symbol_table.SymbolTable;


public class IfElse extends BranchCommand {
	private Expression testExpression;
	private Command ifCommand;
	private Command elseCommand;

	public IfElse(Expression e, Command c1, Command c2) {
		testExpression = e;
		ifCommand = c1;
		elseCommand = c2;
	}
	
	public IfElse(Expression e, Command c1) {
		this(e, c1, new Nop());
	}


	@Override
	public void verifySemantic() throws SemanticException {
		testExpression.verifySemantic();
		
		if (testExpression.getType() != Type.INT) {
			throw new SemanticException("A expressao de teste do \"if-else\" tem tipo invalido: \"" 
					                    + testExpression.getType() + "\".");
		}

		ifCommand.verifySemantic();
		elseCommand.verifySemantic();
	}

	@Override
	public void generateCode(PrintStream out) {
		String labelElse = SymbolTable.instance.getNewLabel();
		String labelNext = SymbolTable.instance.getNewLabel();
		
		String varExp = testExpression.generateCode(out);
		out.println("ifFalse " + varExp + " goto " + labelElse);
		
		ifCommand.generateCode(out);
		out.println("goto " + labelNext);
		
		out.println(labelElse + ":");
		elseCommand.generateCode(out);
		
		out.println(labelNext + ":");
	}

}

class Nop implements Command {
	@Override
	public void verifySemantic() { /* faz nada */ }
	@Override
	public void generateCode(PrintStream out)  { /* faz nada */ }
}
