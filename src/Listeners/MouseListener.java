package Listeners;

import GUI.Map;
import GUI.BoxColour;
import Box.State;
import Gates.CleanGate;
import Gates.Diode1;
import Gates.Diode2;
import Gates.GateAN;
import Gates.GateOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class MouseListener extends MouseAdapter implements Serializable {

    private boolean mouseButton1Pressed, mouseButton2Pressed, mouseButton3Pressed;
    private boolean mode = false;
    private final Map map;
    private GateOR gateOR;
    private GateAN gateAN;
    private Diode1 diode1;
    private Diode2 diode2;
    private int rotate;
    private String gate;

    public MouseListener(Map map) {
        this.map = map;
    }

    private void MakeBoxConductor(BoxColour point) {
        map.labelPressed(point, State.States.CONDUCTOR);
    }

    private void MakeBoxEmpty(BoxColour point) {
        map.labelPressed(point, State.States.EMPTY);
    }

    private void MakeBoxElectronHead(BoxColour point) {
        map.labelPressed(point, State.States.ELECTRON_HEAD);
    }

    private void MakeBoxElectronTail(BoxColour point) {
        map.labelPressed(point, State.States.ELECTRON_TAIL);
    }

    public void modeActivate(String gate) {
        mode = true;
        this.gate = gate;
    }

    public void modeDeactivate( BoxColour[][] points ) {
        mode = false;
        CleanGate clean = new CleanGate( points );
        clean.setClean();
    }

    private void MakeBoxes(BoxColour point) {
        switch (point.getState()) {
            case CONDUCTOR:
                MakeBoxElectronHead(point);
                break;
            case ELECTRON_HEAD:
                MakeBoxElectronTail(point);
                break;
            case ELECTRON_TAIL:
                MakeBoxElectronHead(point);
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseButton1Pressed = false;
        mouseButton2Pressed = false;
        mouseButton3Pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        BoxColour point = (BoxColour) e.getSource();
        if (!mode) {
            if (mouseButton1Pressed) {
                MakeBoxConductor(point);
            } else if (mouseButton2Pressed) {
                MakeBoxes(point);
            } else if (mouseButton3Pressed) {
                MakeBoxEmpty(point);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        BoxColour point = (BoxColour) e.getSource();
        if (!mode) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    mouseButton1Pressed = true;
                    MakeBoxConductor(point);
                    break;
                case MouseEvent.BUTTON2:
                    mouseButton2Pressed = true;
                    MakeBoxes(point);
                    break;
                case MouseEvent.BUTTON3:
                    mouseButton3Pressed = true;
                    MakeBoxEmpty(point);
                    break;
            }
        } else if (gate.equals("Diode1")) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                rotate = 0;
                diode1 = new Diode1(point, map, rotate);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (diode1 != null) {
                    rotate += 90;
                    diode1.setGate(rotate);
                }
            }
        } else if (gate.equals("Diode2")) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                rotate = 0;
                diode2 = new Diode2(point, map, rotate);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (diode2 != null) {
                    rotate += 90;
                    diode2.setGate(rotate);
                }
            }
        } else if (gate.equals("OR")) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                rotate = 0;
                gateOR = new GateOR(point, map, rotate);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (gateOR != null) {
                    rotate += 90;
                    gateOR.setGate(rotate);
                }
            }
        } else if (gate.equals("AN")) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                rotate = 0;
                gateAN = new GateAN(point, map, rotate);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (gateAN != null) {
                    rotate += 90;
                    gateAN.setGate(rotate);
                }
            }
        }
    }
}
