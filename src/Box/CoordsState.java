package Box;


public class CoordsState {
	private final Coords coords;
	private final State state;

	public CoordsState(Coords coords, State state) {
		this.coords = coords;
		this.state = state;
	}

	public Coords getCoords() {
		return this.coords;
	}

	public State getState() {
		return this.state;
	}
}
