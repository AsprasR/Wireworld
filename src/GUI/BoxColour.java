package GUI;

import Box.State;
import java.awt.Color;
import javax.swing.JLabel;

public final class BoxColour extends JLabel {

    private final int x, y;
    private State.States state;

    public BoxColour(int x, int y) {
        this.x = x;
        this.y = y;
        setState(State.States.EMPTY);
    }

    public int getRow() {
        return x;
    }

    public int getCol() {
        return y;
    }

    public State.States getState() {
        return state;
    }

    public void setState(State.States state) {
        this.state = state;
        switch (this.state) {
            case ELECTRON_HEAD:
                setBackground(Color.BLUE);
                break;
            case ELECTRON_TAIL:
                setBackground(Color.RED);
                break;
            case CONDUCTOR:
                setBackground(Color.YELLOW);
                break;
            case TEMPORARY:
                break;
            default:
                setBackground(Color.BLACK);
        }
    }
}
