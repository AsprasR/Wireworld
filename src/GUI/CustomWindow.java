package GUI;

import javax.swing.JOptionPane;

public class CustomWindow extends javax.swing.JDialog {

    private final SizeofMap size;

    public CustomWindow(java.awt.Frame parent, boolean modal, SizeofMap size) {
        super(parent, modal);
        initComponents();
        this.size = size;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        columns = new javax.swing.JTextField();
        rows = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        labelColumns = new javax.swing.JLabel();
        labelRows = new javax.swing.JLabel();
        accept = new javax.swing.JButton();

        close.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("Number of Boxes in the map");
        description.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelColumns.setText("Columns:");

        labelRows.setText("Rows:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelColumns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columns, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRows)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rows, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(description)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelColumns)
                    .addComponent(labelRows)
                    .addComponent(rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        accept.setText("OK");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accept))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        try {
            int numberofRows = Integer.parseInt(rows.getText());
            int numberofColumns = Integer.parseInt(columns.getText());
            if (numberofRows < 16 || numberofRows > 64 || numberofColumns < 16 && numberofColumns > 64) {
                JOptionPane.showMessageDialog(null, "Please write the numbers between 16 and 64.", "Wrong input", JOptionPane.WARNING_MESSAGE);
            } else {
                size.set(numberofColumns, numberofRows);
                dispose();
            }      
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please write the natural numbers.", "Wrong input", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_acceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton close;
    private javax.swing.JTextField columns;
    private javax.swing.JLabel description;
    private javax.swing.JLabel labelColumns;
    private javax.swing.JLabel labelRows;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField rows;
    // End of variables declaration//GEN-END:variables
}
