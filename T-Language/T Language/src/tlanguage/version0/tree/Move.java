package tlanguage.version0.tree;

import java.util.HashMap;

import tmachine.Direction;
import tmachine.Tape;

public class Move extends Command {
	private Direction direction;
	
	public Move(Direction d) {
		direction = d;
	}

	@Override
	public boolean verify(HashMap<String, Label> labels) {
		return true;
	}

	@Override
	public Command run(Tape tape) {
		tape.move(direction);
		return following;
	}
	
	@Override
	public String toString() {
		return "move " + direction.toString().toLowerCase();
	}
	
}
