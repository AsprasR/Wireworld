package Simulation;

import Box.Coords;
import Box.State;
import Box.Box;
import Box.CoordsState;
import GUI.Map;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class NextGeneration extends Observable implements Observer {

    private Box box;
    private final Map map;
    private boolean stop = false;
    private boolean check = false;

    public NextGeneration(Map map) {
        this.box = new Box();
        this.map = map;
    }
    
    public NextGeneration(Box box, Map map) {
        this.box = box;
        this.map = map;
    }

    public Box getBox() {
        return this.box;
    }

    public boolean getStop() {
        return stop;
    }

    public void setBox(Box box) {
        this.box = box;
        setChanged();
        notifyObservers(box);
    }

    private void tick() {
        box.CountSeatmates();
        Collection<State> states = box.getPoint().values();
        for (State state : states) {
            switch (state.getState()) {
                case ELECTRON_HEAD:
                    state.setState(State.States.ELECTRON_TAIL);
                    break;
                case ELECTRON_TAIL:
                    state.setState(State.States.CONDUCTOR);
                    break;
                case CONDUCTOR:
                    if (state.getSeatmates() == 1 || state.getSeatmates() == 2) {
                        state.setState(State.States.ELECTRON_HEAD);
                    }
                    break;
            }
        }
        setChanged();
        notifyObservers(box);
    }

    @Override
    public void update(Observable observable, Object o) {
        stop = false;
        if (observable instanceof NextTick) {
            if (o instanceof CoordsState) {
                CoordsState coordsState = (CoordsState) o;
                Coords coords = coordsState.getCoords();
                State state = coordsState.getState();
                box.setState(coords.getX(), coords.getY(), state.getState());
                if (state.getState() == State.States.ELECTRON_HEAD || state.getState() == State.States.ELECTRON_TAIL) {
                    check = true;
                }
                if (coords.getX() == map.getSizeMap().getColumns() - 1 && coords.getY() == map.getSizeMap().getRows() - 1) {
                    if (check == false) {
                        stop = true;
                    }
                    check = false;
                }
            }
        }
        if (observable instanceof SimulationTick) {
            tick();
        }

    }
}
