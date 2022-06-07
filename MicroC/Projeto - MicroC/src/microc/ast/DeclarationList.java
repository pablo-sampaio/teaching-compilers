package microc.ast;

import java.io.PrintStream;
import java.util.Vector;



@SuppressWarnings("serial")
public class DeclarationList extends Vector<Declaration> {

	public void verifySemantic() throws SemanticException {
		for (Declaration declaration : this) {
			declaration.verifySemantic();
		}
	}

	public void generateCode(PrintStream out) {
		for (Declaration declaration : this) {
			declaration.generateCode(out);
		}
	}

}
