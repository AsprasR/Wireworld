package Box;

import java.io.Serializable;

public class State implements Serializable {

    public static enum States {
        EMPTY,
        CONDUCTOR,
        ELECTRON_HEAD,
        ELECTRON_TAIL,
        TEMPORARY
    }

    private States state;
    private int seatmates;

    public State() {
        this.state = States.EMPTY;
    }

    public State(States state) {
        this.state = state;
    }

    public States getState() {
        return state;
    }
    
    public void setState(States state) {
        this.state = state;
    }

    public int getSeatmates() {
        return seatmates;
    }

    public void setSeatmates(int seatmates) {
        this.seatmates = seatmates;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State status = (State) obj;
        return this.state.equals(status.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}
