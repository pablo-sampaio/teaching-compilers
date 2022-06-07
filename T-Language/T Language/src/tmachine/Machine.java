package tmachine;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Machine {
	private List<State> states;
	private List<Transitions> transitions;

	Machine() {
		states = new LinkedList<State>();
		// creates the initial state
		createState();
	}
	
	public State createState() {
		return createState(false);
	}

	public State createState(boolean isAccepting) {
		State state = new State(states.size(), isAccepting);
		states.add(state);
		transitions.add(new Transitions());
		return state;
	}

	public State getStartState() {
		return states.get(0);
	}
	
	public List<State> getAcceptingStates() {
		List<State> accStates = new LinkedList<State>();
		
		for (State state : this.states) {
			if (state.isAccepting()) {
				accStates.add(state);
			}
		}
		
		return states;
	}

	public Action getTransition(State s, char symbol) {
		return null;
	}

	public boolean simulate(Tape input) {
		//TODO
		return false;
	}
	
}
