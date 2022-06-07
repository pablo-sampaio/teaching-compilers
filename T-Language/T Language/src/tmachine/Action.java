package tmachine;

public class Action {
	public State origin;
	public int symbolToRead;
	public int symbolToWrite;
	public Direction direction;
	public State destiny;

	public Action(State destiny, Direction direction, State origin,
			int symbolToRead, int symbolToWrite) {
		this.destiny = destiny;
		this.direction = direction;
		this.origin = origin;
		this.symbolToRead = symbolToRead;
		this.symbolToWrite = symbolToWrite;
	}

	public State getOrigin() {
		return origin;
	}

	public int getSymbolToRead() {
		return symbolToRead;
	}

	public int getSymbolToWrite() {
		return symbolToWrite;
	}

	public Direction getDirection() {
		return direction;
	}

	public State getDestiny() {
		return destiny;
	}

}
