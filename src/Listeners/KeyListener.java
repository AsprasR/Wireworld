package Listeners;

import GUI.Map;
import Simulation.Simulation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private final Simulation simulation;
    private final Map map;

    public KeyListener(Simulation simulation, Map map) {
        this.simulation = simulation;
        this.map = map;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_1) {
            simulation.setMovesPerSecond(1);
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            simulation.setMovesPerSecond(2);
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            simulation.setMovesPerSecond(4);
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            simulation.setMovesPerSecond(8);
        } else if (e.getKeyCode() == KeyEvent.VK_5) {
            simulation.setMovesPerSecond(16);
        } else if (e.getKeyCode() == KeyEvent.VK_6) {
            simulation.setMovesPerSecond(32);
        } else if (e.getKeyCode() == KeyEvent.VK_7) {
            simulation.setMovesPerSecond(64);
        } else if (e.getKeyCode() == KeyEvent.VK_8) {
            simulation.setMovesPerSecond(128);
        } else if (e.getKeyCode() == KeyEvent.VK_9) {
            simulation.setMovesPerSecond(256);
        } else if (e.getKeyCode() == KeyEvent.VK_0) {
            simulation.setMovesPerSecond(512);
        } else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            map.deactivate();
        }
    }
}
