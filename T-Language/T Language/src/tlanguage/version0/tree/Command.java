package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Tape;

public abstract class Command {
	protected Command following;
	
	/**
	 * Gets/Sets the command placed immediately after this command. 
	 */
	Command getFollowing() {
		return following;
	}
	void setFollowing(Command nextC) {
		following = nextC;
	}
	
	/**
	 * Verifies if the labels used are declared. 
	 */
	public abstract boolean verify(HashMap<String,Label> labels);
	
	/**
	 * Executes the command on the given tape configuration and
	 * returns the next command to be executed (or null if execution
	 * is finished). 
	 */
	public abstract Command run(Tape tape);

	/**
	 * Converts the comand to string.
	 */
	public abstract String toString();

	/**
	 * Returns the character itselft or "blank", if its value is 0.
	 */
	protected static String symbolString(char c) {
		if (c == 0) {
			return "blank";
		} else {
			return "" + c;
		}
	}

}
