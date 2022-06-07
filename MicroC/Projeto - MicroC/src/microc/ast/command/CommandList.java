package microc.ast.command;

import java.io.PrintStream;
import java.util.*;

import microc.ast.SemanticException;


@SuppressWarnings("serial")
public class CommandList extends Vector<Command> {

	public void verifySemantic() throws SemanticException {
		for (Command command : this) {
			command.verifySemantic();
		}
	}
	
	public void generateCode(PrintStream out) {
		for (Command command : this) {
			command.generateCode(out);
		}
	}
	
}
