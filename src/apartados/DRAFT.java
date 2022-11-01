package apartados;


public class DRAFT extends javax.swing.JFrame {

    public DRAFT() {
        initComponents();
 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        R3 = new javax.swing.JRadioButton();
        txt = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(R1);
        R1.setText("jRadioButton1");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(R2);
        R2.setText("jRadioButton2");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(R3);
        R3.setText("jRadioButton3");
        R3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(721, Short.MAX_VALUE)
                .addComponent(txt)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(R2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(R1)
                                .addGap(128, 128, 128))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(R3)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(R2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(R3)
                                .addGap(18, 18, 18)
                                .addComponent(R1)))))
                .addGap(22, 22, 22)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(txt)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void R2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2ItemStateChanged

if(R1.isSelected()) {
txt.setText("1");
}else if (R2.isSelected()){
txt.setText("2");
}
else if (R3.isSelected()){
txt.setText("3");
}
else{
txt.setText("0");
}

    }//GEN-LAST:event_R2ItemStateChanged

    private void R1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1ItemStateChanged

if(R1.isSelected()) {
txt.setText("1");
}else if (R2.isSelected()){
txt.setText("2");
}
else if (R3.isSelected()){
txt.setText("3");
}
else{
txt.setText("0");
}

    }//GEN-LAST:event_R1ItemStateChanged

    private void R3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R3ItemStateChanged

if(R1.isSelected()) {
txt.setText("1");
}
else if (R2.isSelected()){
txt.setText("2");
}
else if (R3.isSelected()){
txt.setText("3");
}
else{
txt.setText("0");
}
    }//GEN-LAST:event_R3ItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DRAFT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JRadioButton R3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
