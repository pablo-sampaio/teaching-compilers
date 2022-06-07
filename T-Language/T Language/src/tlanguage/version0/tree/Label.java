package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;


public class Label extends Command {
	private String name;

	public Label(String labelName) {
		name = labelName;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean nameEquals(String labelName) {
		return name.equals(labelName);
	}
	
	@Override
	public boolean verify(HashMap<String,Label> labels) {
		return true;
	}

	@Override
	public Command run(Tape tape) {
		return following;
	}
	
	@Override
	public String toString() {
		return name + ":";
	}
	
}
