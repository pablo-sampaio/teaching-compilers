package microc.ast.expression;

import java.io.PrintStream;

import microc.ast.SemanticException;
import microc.ast.Type;


public interface Expression {
	public void verifySemantic() throws SemanticException;
	public String generateCode(PrintStream out);

	public Type getType();
}
