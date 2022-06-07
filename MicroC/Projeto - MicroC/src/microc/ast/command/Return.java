package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;
import microc.ast.expression.Expression;


public class Return implements Command {
	private Expression expression;
	
	public Return(Expression e) {
		expression = e;
	}
	

	@Override
	public void verifySemantic() throws SemanticException {
		expression.verifySemantic();
		
		if (expression.getType() != Type.INT) {
			throw new SemanticException("Expressão de retorno tem tipo invalido: \"" 
					                    + expression.getType() + "\".");
		}
	}

	@Override
	public void generateCode(PrintStream out) {
		String varExp = expression.generateCode(out);
		
		out.println("return " + varExp);		
	}

}
