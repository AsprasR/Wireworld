package Simulation;

import java.io.Serializable;
import java.util.Observable;

public class NextTick extends Observable implements Serializable {

    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }
}
