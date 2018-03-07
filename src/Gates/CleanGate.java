package Gates;

import Box.State;
import GUI.BoxColour;
import java.awt.Color;

public class CleanGate {

    private final BoxColour[][] points;

    public CleanGate(BoxColour[][] points ) {
        this.points = points;
    }

    private boolean checkIsTemporary(int i, int j) {
        return points[i][j].getState() == State.States.TEMPORARY;
    }

    private void setState(int i, int j) {
        if (points[i][j].getBackground() == Color.YELLOW) {
            points[i][j].setState(State.States.CONDUCTOR);
        } else if (points[i][j].getBackground() == Color.BLUE) {
            points[i][j].setState(State.States.ELECTRON_HEAD);
        } else if (points[i][j].getBackground() == Color.RED) {
            points[i][j].setState(State.States.ELECTRON_TAIL);
        }
    }

    private void checkTemporary(int i, int j) {
        if (checkIsTemporary(i, j)) {
            setState(i, j);
        }
    }

    public void setClean() {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                checkTemporary(i, j);
            }
        }
    }

}
