package GUI;

import Box.Coords;
import Box.State;
import Box.Box;
import Box.CoordsState;
import Simulation.NextTick;
import Listeners.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public final class Map extends JPanel implements Observer {

    private final BoxColour[][] points;
    private final NextTick tick;
    private final SizeofMap sizeMap;
    private final MouseListener mouseListener;
    private final Dimension cellSize;
    private int columns, rows, size;

    public Map(SizeofMap sizeMap) {
        this.sizeMap = sizeMap;
        setSize();
        points = new BoxColour[rows][columns];
        tick = new NextTick();
        mouseListener = new MouseListener(this);

        cellSize = new Dimension(size, size);

        setLayout(new GridLayout(rows, columns));
        addBox();
    }
    
    private void setSize() {
        columns = sizeMap.getColumns();
        rows = sizeMap.getRows();
        size = sizeMap.getSize();
    }
    
    public SizeofMap getSizeMap() {
        return this.sizeMap;
    }
    
    public BoxColour[][] getPoints() {
        return this.points;
    }
    
    public NextTick getNextTick() {
        return this.tick;
    }
    
    public void activate( String gate) {
        mouseListener.modeActivate( gate );
    }
    
    public void deactivate() {
        mouseListener.modeDeactivate( points );
    }

    public void labelPressed(BoxColour point, State.States state) {
        point.setState(state);
        tick.setChanged();
        tick.notifyObservers(new CoordsState(new Coords(point.getRow(), point.getCol()), new State(state)));
    }

    private void addBox() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                points[i][j] = new BoxColour(i, j);
                points[i][j].setOpaque(true);
                points[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                points[i][j].addMouseListener(mouseListener);
                points[i][j].setPreferredSize(cellSize);
                add(points[i][j]);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Box) {
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points[0].length; j++) {
                    labelPressed(points[i][j], ((Box) arg).getState(i, j));
                }
            }
        }
    }
}
