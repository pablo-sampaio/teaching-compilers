package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;

public class Goto extends Command {
	private String labelName;
	private Label label;
	
	public Goto(String name) {
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
		return label;
	}
	
	@Override
	public String toString() {
		return "goto " + labelName;
	}

}
