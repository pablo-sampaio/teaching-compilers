package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;

public class IfGoto extends Command {
	private boolean equalityExpected;
	private char symbol;
	private String labelName;
	private Label label;
	
	public IfGoto(boolean branchIfEquals, Character c, String name) {
		equalityExpected = branchIfEquals;
		symbol = c.charValue();
		labelName = name;
	}

	@Override
	public boolean verify(HashMap<String,Label> labels) {
		label = labels.get(labelName);
		
		if (label == null) {
			System.out.println("Erro: Label não encontrado - \"" + labelName + "\"");
			return false;
		}
		
		return true;
	}

	@Override
	public Command run(Tape tape) {
		char currentSymbol = tape.readSymbol();
		boolean equals = (currentSymbol == symbol); 

		if (equals == equalityExpected) {
			return label;
		}

		return following;
	}
	
	@Override
	public String toString() {
		String result = (equalityExpected)? "if " : "if-not ";
		
		result += "[" + symbolString(symbol) + "] goto ";
		result += labelName;
		
		return result;
	}

}
