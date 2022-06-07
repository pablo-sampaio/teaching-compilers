package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;

public class Write extends Command {
	private char symbol;
	
	public Write(Character c) {
		symbol = c.charValue();
	}

	@Override
	public boolean verify(HashMap<String, Label> labels) {
		return true;
	}

	@Override
	public Command run(Tape tape) {
		tape.writeSymbol(symbol);
		return following;
	}
	
	@Override
	public String toString() {
		return "write [" + symbolString(symbol) + "]";
	}
	
}
