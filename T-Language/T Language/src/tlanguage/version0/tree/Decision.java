package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;


public class Decision extends Command {
	private boolean isAccept;

	public Decision(boolean accept) {
		isAccept = accept;
	}
	
	public boolean isAccept() {
		return isAccept;
	}
	
	public boolean isReject() {
		return !isAccept;
	}

	@Override
	public boolean verify(HashMap<String,Label> labels) {
		return true;
	}

	@Override
	public Command run(Tape tape) {
		return null;
	}
	
	@Override
	public String toString() {
		if (isAccept) {
			return "ACCEPT";
		} else { 
			return "REJECT";
		}
	}
	
}
