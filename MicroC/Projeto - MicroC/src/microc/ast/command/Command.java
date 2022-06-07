package microc.ast.command;

import java.io.PrintStream;

import microc.ast.SemanticException;


public interface Command {
	public void verifySemantic() throws SemanticException;
	public void generateCode(PrintStream out);
}
