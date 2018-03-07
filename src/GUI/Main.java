package GUI;

import Box.Box;
import File.FileExporter;
import File.FileImporter;
import Simulation.NextGeneration;
import Simulation.Simulation;
import Listeners.KeyListener;
import Simulation.SimulationTick;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Main extends javax.swing.JFrame implements Observer {

    private static NextGeneration nextGeneration;
    private static SizeofMap size;
    private static Map map;
    private static Simulation simulation;
    HashMap<String, Object> retrieved;
    private boolean started;
    private JFileChooser fileChooser;

    public Main() {
        initComponents();
        size = new SizeofMap();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        buttons = new javax.swing.JPanel();
        startStop = new javax.swing.JButton();
        next = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        load = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        resize = new javax.swing.JMenu();
        resize0 = new javax.swing.JMenu();
        resize1 = new javax.swing.JMenuItem();
        resize2 = new javax.swing.JMenuItem();
        resize3 = new javax.swing.JMenuItem();
        resize4 = new javax.swing.JMenuItem();
        gates = new javax.swing.JMenu();
        diode1 = new javax.swing.JMenuItem();
        diode2 = new javax.swing.JMenuItem();
        gateOR = new javax.swing.JMenuItem();
        gateAN = new javax.swing.JMenuItem();
        options = new javax.swing.JMenu();
        clean = new javax.swing.JMenuItem();
        help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wireworld");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        board.setLayout(new java.awt.BorderLayout());

        buttons.setLayout(new java.awt.GridLayout(2, 1));

        startStop.setText("Start");
        startStop.setFocusable(false);
        startStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopActionPerformed(evt);
            }
        });
        buttons.add(startStop);

        next.setText("Next");
        next.setFocusable(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        buttons.add(next);

        file.setText("File");

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        file.add(load);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        menu.add(file);

        resize.setText("Resize");

        resize0.setText("Resize");

        resize1.setText("16x16");
        resize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resize1ActionPerformed(evt);
            }
        });
        resize0.add(resize1);

        resize2.setText("32x32");
        resize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resize2ActionPerformed(evt);
            }
        });
        resize0.add(resize2);

        resize3.setText("64x64");
        resize3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resize3ActionPerformed(evt);
            }
        });
        resize0.add(resize3);

        resize4.setText("Custom");
        resize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resize4ActionPerformed(evt);
            }
        });
        resize0.add(resize4);

        resize.add(resize0);

        menu.add(resize);

        gates.setText("Gates");

        diode1.setText("Diode1");
        diode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diode1ActionPerformed(evt);
            }
        });
        gates.add(diode1);

        diode2.setText("Diode2");
        diode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diode2ActionPerformed(evt);
            }
        });
        gates.add(diode2);

        gateOR.setText("Gate OR");
        gateOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gateORActionPerformed(evt);
            }
        });
        gates.add(gateOR);

        gateAN.setText("Gate AN");
        gateAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gateANActionPerformed(evt);
            }
        });
        gates.add(gateAN);

        menu.add(gates);

        options.setText("Options");

        clean.setText("Clean");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });
        options.add(clean);

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        options.add(help);

        menu.add(options);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeMap() {
        deleteObservers();
       
        map = new Map(size);
        nextGeneration = new NextGeneration(map);
        
        addObservers();
    }
    
    private void deleteObservers() {
        board.remove(map);
        
        nextGeneration.deleteObserver(map);
        map.getNextTick().deleteObserver(nextGeneration);
        simulation.getSimulationTick().deleteObserver(nextGeneration);
    }
    
    private void addObservers() {
        nextGeneration.addObserver(map);
        map.getNextTick().addObserver(nextGeneration);
        simulation.getSimulationTick().addObserver(nextGeneration);

        addKeyListener(new KeyListener(simulation, map));
        board.add(map);
        pack();
    }

    private void addfileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "Wireworld file (*.w)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".w");
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SimulationTick) {
            if (nextGeneration.getStop()) {
                startStop.setText("Start");
                started = false;
                try {
                    simulation.pauseThread();
                } catch (InterruptedException ignore) {
                }
            }
        }
    }

    private void resize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resize1ActionPerformed
        size.set(16, 16);
        changeMap();
    }//GEN-LAST:event_resize1ActionPerformed

    private void resize2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resize2ActionPerformed
        size.set(32, 32);
        changeMap();
    }//GEN-LAST:event_resize2ActionPerformed

    private void resize3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resize3ActionPerformed
        size.set(64, 64);
        changeMap();
    }//GEN-LAST:event_resize3ActionPerformed

    private void resize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resize4ActionPerformed
        CustomWindow window = new CustomWindow(this, true, size);
        window.setVisible(true);
        changeMap();
    }//GEN-LAST:event_resize4ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        simulation.getSimulationTick().setChanged();
        simulation.getSimulationTick().notifyObservers();
    }//GEN-LAST:event_nextActionPerformed

    private void startStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopActionPerformed
        if (!started) {
            startStop.setText("Stop");
            simulation.getSimulationTick().addObserver(this);
            started = true;
            simulation.resumeThread();
        } else {
            startStop.setText("Start");
            simulation.getSimulationTick().deleteObserver(this);
            started = false;
            try {
                simulation.pauseThread();
            } catch (InterruptedException e1) {
            }
        }
    }//GEN-LAST:event_startStopActionPerformed

    private void diode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diode1ActionPerformed
        map.activate("Diode1");
    }//GEN-LAST:event_diode1ActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        int status = fileChooser.showOpenDialog(this);

        if (status == JFileChooser.APPROVE_OPTION) {
            File fold = fileChooser.getSelectedFile();
            FileImporter importer = new FileImporter();

            try {
                retrieved = new HashMap(importer.gridImport(fold));
                deleteObservers();
                pack();
                
                map = (Map) retrieved.get("Map");
                nextGeneration = new NextGeneration((Box) retrieved.get("Box"), map);

                addObservers();
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_loadActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        int status = fileChooser.showSaveDialog(this);

        if (status == JFileChooser.APPROVE_OPTION) {
            File fold = fileChooser.getSelectedFile();

            if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".w")) {
                fold = new File(fileChooser.getSelectedFile() + ".w");
            }

            FileExporter exporter = new FileExporter();

            try {
                exporter.gridExport(nextGeneration, map, fold);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        changeMap();
    }//GEN-LAST:event_cleanActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        String helper = "<html>"
                + "<body>"
                + "<p>Lewy przycisk myszy powoduje powstanie "
                + "<span style=\"color:yellow;\">Conductora</span>.</p>"
                + "<p>Jeżeli klocek jest Conductorem, to środkowy przycisk myszy powoduje powstanie "
                + "<span style=\"color:blue;\">Election Head</span>"
                + ", a ponowne wciśnięcie powoduje powstanie "
                + "<span style=\"color:red;\">Election Tail</span>.</p>"
                + "<p>Prawy przycisk myszy powoduje usunięcie każdego stanu.</p>"
                + "<p>Wybranie dowolnego gatu powoduje przejście w stan wstawiania gate.</p>"
                + "<p>Lewy przycisk powoduje wstawienie gata w miejscu wciśnięcia klocka. "
                + "Do zmiany kąta położenia należy użyć prawego przycisku myszy.</p>"
                + "<p>Aby wyjść z tego trybu należy wcisnąć klawisz ESC.</p>"
                + "<p>Do symulacji służy przycisk START. Można ustawić szybkość symulacji klawiszami 0-9.</p>"
                + "</body>"
                + "</html>";
        JOptionPane.showMessageDialog(null, helper, "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpActionPerformed

    private void gateORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gateORActionPerformed
        map.activate("OR");
    }//GEN-LAST:event_gateORActionPerformed

    private void gateANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gateANActionPerformed
        map.activate("AN");
    }//GEN-LAST:event_gateANActionPerformed

    private void diode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diode2ActionPerformed
        map.activate("Diode2");
    }//GEN-LAST:event_diode2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            Main main = new Main();
            simulation = new Simulation();

            map = new Map(size);

            nextGeneration = new NextGeneration(map);
            nextGeneration.addObserver(map);
            map.getNextTick().addObserver(nextGeneration);
            simulation.getSimulationTick().addObserver(nextGeneration);

            main.addKeyListener(new KeyListener(simulation, map));
            main.setFocusable(true);
            main.addfileChooser();
            main.board.add(map, BorderLayout.CENTER);

            main.pack();
            main.setVisible(true);
            main.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - main.getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - main.getHeight()) / 2);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel board;
    private javax.swing.JPanel buttons;
    private javax.swing.JMenuItem clean;
    private javax.swing.JMenuItem diode1;
    private javax.swing.JMenuItem diode2;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem gateAN;
    private javax.swing.JMenuItem gateOR;
    private javax.swing.JMenu gates;
    private javax.swing.JMenuItem help;
    private javax.swing.JMenuItem load;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton next;
    private javax.swing.JMenu options;
    private javax.swing.JMenu resize;
    private javax.swing.JMenu resize0;
    private javax.swing.JMenuItem resize1;
    private javax.swing.JMenuItem resize2;
    private javax.swing.JMenuItem resize3;
    private javax.swing.JMenuItem resize4;
    private javax.swing.JMenuItem save;
    private javax.swing.JButton startStop;
    // End of variables declaration//GEN-END:variables

}
