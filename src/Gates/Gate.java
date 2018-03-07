package Gates;

import Box.State;
import GUI.Map;
import GUI.BoxColour;
import java.awt.Color;

public class Gate {

    private final BoxColour[][] points;
    private final BoxColour point;
    private final Map map;
    private int x, y;

    public Gate(BoxColour point, Map map) {
        this.points = map.getPoints();
        this.map = map;
        this.point = point;
    }

    private void setPointsY(int i, State.States state) {
        if (points[x][i].getState() != State.States.TEMPORARY) {
            map.labelPressed(points[x][i], state);
        }
    }

    private void setPointsX(int j, State.States state) {
        if (points[j][y].getState() != State.States.TEMPORARY) {
            map.labelPressed(points[j][y], state);
        }
    }

    private void setPointTempY(int i) {
        points[x][i].setState(State.States.TEMPORARY);
    }

    private void setPointTempX(int j) {
        points[j][y].setState(State.States.TEMPORARY);
    }

    private boolean checkIsEmptyY(int i) {
        return points[x][i].getState() != State.States.EMPTY;
    }

    private boolean checkIsEmptyX(int j) {
        return points[j][y].getState() != State.States.EMPTY;
    }

    private boolean checkIsTemporaryY(int i) {
        return points[x][i].getState() == State.States.TEMPORARY;
    }

    private boolean checkIsTemporaryX(int j) {
        return points[j][y].getState() == State.States.TEMPORARY;
    }

    private void setStateY(int i) {
        if (points[x][i].getBackground() == Color.YELLOW) {
            points[x][i].setState(State.States.CONDUCTOR);
        } else if (points[x][i].getBackground() == Color.BLUE) {
            points[x][i].setState(State.States.ELECTRON_HEAD);
        } else if (points[x][i].getBackground() == Color.RED) {
            points[x][i].setState(State.States.ELECTRON_TAIL);
        }
    }

    private void setStateX(int j) {
        if (points[j][y].getBackground() == Color.YELLOW) {
            points[j][y].setState(State.States.CONDUCTOR);
        } else if (points[j][y].getBackground() == Color.BLUE) {
            points[j][y].setState(State.States.ELECTRON_HEAD);
        } else if (points[j][y].getBackground() == Color.RED) {
            points[j][y].setState(State.States.ELECTRON_TAIL);
        }
    }

    private void checkEmptyY(int i) {
        if (checkIsEmptyY(i)) {
            setPointTempY(i);
        }
    }

    private void checkEmptyX(int j) {
        if (checkIsEmptyX(j)) {
            setPointTempX(j);
        }
    }

    private void checkTemporaryY(int i) {
        if (checkIsTemporaryY(i)) {
            setStateY(i);
        }
    }

    private void checkTemporaryX(int j) {
        if (checkIsTemporaryX(j)) {
            setStateX(j);
        }
    }

    private void defaultX() {
        x = point.getRow();
    }

    private void defaultY() {
        y = point.getCol();
    }

    private void makeCon(int rotate, int con) {
        if (rotate % 180 == 0) {
            x = point.getRow() + con;
        } else {
            y = point.getCol() - con;
        }
    }

    private boolean makePoint(int rotate, int con) {
        if (rotate == 0) {
            if (x + con >= 0 && x + con < points.length && y - con < points[0].length) {
                makeCon(rotate, con);
                return true;
            } else {
                return false;
            }
        }
        if (rotate == 90) {
            if (y - con >= 0 && x + con < points.length && y - con < points[0].length) {
                makeCon(rotate, con);
                return true;
            } else {
                return false;
            }
        }
        if (rotate == 180) {
            if (y - con >= 0 && x + con >= 0 && x + con < points.length) {
                makeCon(rotate, con);
                return true;
            } else {
                return false;
            }
        }
        if (rotate == 270) {
            if (y - con >= 0 && x + con >= 0 && y - con < points[0].length) {
                makeCon(rotate, con);
                return true;
            } else {
                return false;
            }
        } else {
            makeCon(rotate, con);
            return true;
        }
    }

    private void makeInit(int a, int b, int c, int con) {
        for (int j = a + b; j <= a + c; j++) {
            if (j - b - c >= 0) {
                if (makePoint(270, con)) {
                    checkEmptyX(j - b - c);
                }
            }
            defaultY();
        }
    }

    private void executeY(int rotate, int a, int b, int c, int con) {
        rotate = rotate % 360;
        for (int i = a + b; i <= a + c; i++) {
            switch (rotate) {
                case 0:
                    if (i < points[0].length) {
                        if (makePoint(rotate, con)) {
                            checkEmptyY(i);
                            setPointsY(i, State.States.CONDUCTOR);
                        }
                    }
                    defaultX();
                    break;
                case 90:
                    if (i < points[0].length) {
                        if (makePoint(rotate - 90, con)) {
                            setPointsY(i, State.States.EMPTY);
                            checkTemporaryY(i);
                        }
                    }
                    defaultX();
                    break;
                case 180:
                    if (i - b - c >= 0) {
                        if (makePoint(rotate, con)) {
                            checkEmptyY(i - b - c);
                            setPointsY(i - b - c, State.States.CONDUCTOR);
                        }
                    }
                    defaultX();
                    break;
                case 270:
                    if (i - b - c >= 0) {
                        if (makePoint(rotate - 90, con)) {
                            setPointsY(i - b - c, State.States.EMPTY);
                            checkTemporaryY(i - b - c);
                        }
                    }
                    defaultX();
                    break;
                default:
                    break;
            }
        }
    }

    private void executeX(int rotate, int a, int b, int c, int con) {
        if (rotate == 0) {
            makeInit(a, b, c, con);
        }
        rotate = rotate % 360;
        for (int j = a + b; j <= a + c; j++) {
            switch (rotate) {
                case 0:
                    if (j - b - c >= 0) {
                        if (makePoint(270, con)) {
                            setPointsX(j - b - c, State.States.EMPTY);
                            checkTemporaryX(j - b - c);
                        }
                    }
                    defaultY();
                    break;
                case 90:
                    if (j < points.length) {
                        if (makePoint(rotate, con)) {
                            checkEmptyX(j);
                            setPointsX(j, State.States.CONDUCTOR);
                        }
                    }
                    defaultY();
                    break;

                case 180:
                    if (j < points.length) {
                        if (makePoint(rotate - 90, con)) {
                            setPointsX(j, State.States.EMPTY);
                            checkTemporaryX(j);
                        }
                    }
                    defaultY();
                    break;
                case 270:
                    if (j - b - c >= 0) {
                        if (makePoint(rotate, con)) {
                            checkEmptyX(j - b - c);
                            setPointsX(j - b - c, State.States.CONDUCTOR);
                        }
                    }
                    defaultY();
                    break;
                default:
                    break;
            }
        }
    }

    protected void execute(int rotate, int a, int b, int con) {
        defaultX();
        defaultY();
        executeX(rotate, x, a, b, con);
        executeY(rotate, y, a, b, con);
    }

}
