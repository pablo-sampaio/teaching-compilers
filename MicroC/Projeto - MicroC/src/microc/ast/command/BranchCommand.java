package microc.ast.command;

import java.io.PrintStream;

import microc.ast.expression.Expression;


public abstract class BranchCommand implements Command {

	protected void generateCodeForBranchExpression(Expression expression, String label,
			boolean branchIfPositive, PrintStream out) {
		String varExp = expression.generateCode(out);
		
		out.println("if " + varExp + " goto " + label);
	}
	
}
