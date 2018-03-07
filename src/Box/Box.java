package Box;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Box implements Serializable {

    private final HashMap<Coords, State> point;

    public Box() {
        point = new HashMap<>();
    }

    public Box(Box point) {
        this.point = point.point;
    }

    public HashMap<Coords, State> getPoint() {
        return point;
    }

    public void setState(int x, int y, State.States state) {
        point.put(new Coords(x, y), new State(state));
    }

    public State.States getState(int x, int y) {
        State state = point.get(new Coords(x, y));
        return state == null ? State.States.EMPTY : state.getState();
    }

    public void CountSeatmates() {
        Collection<Coords> coords = point.keySet();
        coords.forEach((Coords c) -> {
            State state = point.get(c);
            state.setSeatmates(0);
            if (state.getState() == State.States.CONDUCTOR) {
                int n = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0); 
                        else if (getState(c.getX() + i, c.getY() + j) == State.States.ELECTRON_HEAD) {
                            n++;
                        }
                    }
                }
                state.setSeatmates(n);
                point.put(c, state);
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Box)) {
            return false;
        }
        Box box = (Box) o;
        return point.equals(box.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }
}
