package Simulation;

public class Simulation extends Thread {

    private final SimulationTick simulation;
    private final int seconds = 1500;
    private int movesPerSecond = 32;
    private final Object object;
    private boolean pause = false;

    public Simulation() {
        this.object = new Object();
        simulation = new SimulationTick();
        simulate();
    }

    private void simulate() {
        start();
        try {
            pauseThread();
        } catch (InterruptedException e) {
        }
    }

    public synchronized void setMovesPerSecond(int movesPerSecond) {
        this.movesPerSecond = movesPerSecond;
    }

    public SimulationTick getSimulationTick() {
        return simulation;
    }

    private void threadSleep() throws InterruptedException {
        Thread.sleep(seconds / movesPerSecond);
    }

    public void pauseThread() throws InterruptedException {
        pause = true;
    }

    private void checkForPaused() {
        synchronized (object) {
            while (pause) {
                try {
                    object.wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    public void resumeThread() {
        synchronized (object) {
            pause = false;
            object.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                checkForPaused();
                threadSleep();
                simulation.setChanged();
                simulation.notifyObservers();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
