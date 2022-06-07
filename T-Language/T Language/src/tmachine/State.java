package tmachine;

class State {
	private final int id;
	private boolean accepting;
	private String name;
	
	State(int stateId) {
		id = stateId;
		accepting = false;
	}

	State(int stateId, boolean isAccepting) {
		id = stateId;
		accepting = isAccepting;
	}
	
	State(String stateName, int stateId, boolean isAccepting) {
		name = stateName;
		id = stateId;
		accepting = isAccepting;
	}
	
	public boolean isAccepting() {
		return accepting;
	}
	
	public void setIsAcceptin(boolean isAccepting) {
		this.accepting = isAccepting;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public boolean equals(Object o) {
		if (o instanceof State) {
			return this.id == ((State)o).id;
		} else {
			return false;
		}
	}

}
