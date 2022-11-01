
package apartados;

import Funciones.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Agregar_Provedores extends javax.swing.JFrame {


    public Agregar_Provedores() {
        initComponents();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_not = new javax.swing.JEditorPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        comb_tip = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_dni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_dni2 = new javax.swing.JTextField();
        txt_dni4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_dni3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_dni5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_contc1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_contc2 = new javax.swing.JTextField();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txt_contc5 = new javax.swing.JTextField();
        txt_contc4 = new javax.swing.JTextField();
        R4 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txt_contc3 = new javax.swing.JTextField();
        txt_contc6 = new javax.swing.JTextField();
        R3 = new javax.swing.JRadioButton();
        R5 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_conp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_nota = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jScrollPane1.setViewportView(txt_not);

        jLabel14.setFont(new java.awt.Font("Songti TC", 0, 14)); // NOI18N
        jLabel14.setText("Algo que desee remarcar del provedor");

        jLabel13.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel13.setText(" Nota:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comb_tip.setFont(new java.awt.Font("Mshtakan", 1, 14)); // NOI18N
        comb_tip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "RNC" }));
        comb_tip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                habilitar(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel22.setText("Tipo DNI");

        txt_dni.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("-");

        txt_dni2.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_dni2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dni2KeyTyped(evt);
            }
        });

        txt_dni4.setEditable(false);
        txt_dni4.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni4.setToolTipText("");
        txt_dni4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_dni4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dni4KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("-");

        jLabel25.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel25.setText(" RNC : ");

        txt_dni3.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_dni3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dni3KeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel24.setText("Cedula:");

        txt_dni5.setEditable(false);
        txt_dni5.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_dni5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dni5KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_dni4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dni5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txt_dni2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dni3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_dni4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txt_contc1.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc1.setEnabled(false);
        txt_contc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validar(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel6.setText("Contacto1:");

        txt_contc2.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc2.setEnabled(false);
        txt_contc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contc2KeyTyped(evt);
            }
        });

        R1.setText("Numero de Contacto");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1ItemStateChanged(evt);
            }
        });

        R2.setText("Correo Electronico");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(R1)
                            .addComponent(R2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_contc1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(txt_contc2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contc1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contc2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2))
                .addContainerGap())
        );

        txt_contc5.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc5.setEnabled(false);

        txt_contc4.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc4.setEnabled(false);
        txt_contc4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contc4KeyTyped(evt);
            }
        });

        R4.setText("Numero de Contacto");
        R4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R4ItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel9.setText("Contacto2:");

        txt_contc3.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc3.setEnabled(false);
        txt_contc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contc3KeyTyped(evt);
            }
        });

        txt_contc6.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc6.setEnabled(false);

        R3.setText("Correo Electronico");
        R3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R3ItemStateChanged(evt);
            }
        });

        R5.setText("Otro");
        R5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R5ItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel11.setText("Especifique");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(R5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_contc5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_contc6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(R3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_contc4))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(R4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_contc3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contc3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R3)
                    .addComponent(txt_contc4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(R5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_contc6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_contc5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        txt_nom.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        txt_conp.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel12.setText("Concepto:");

        txt_nota.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel15.setText("Notas:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nom)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_conp, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nota)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_conp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txt_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/020-flexible.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7GUARDAR_PROD(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/003-anterior.png"))); // NOI18N
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8SALIR(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contc2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contc2KeyTyped
        String b = txt_contc2.getText();
        if (b.length()>85) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_contc2KeyTyped

    private void txt_contc4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contc4KeyTyped

        String b = txt_contc4.getText();
        if (b.length()>85) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_contc4KeyTyped

    private void txt_contc3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contc3KeyTyped

        char a = evt.getKeyChar();

        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_contc3KeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped

        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
        String b = txt_dni.getText();
        if (b.length() >2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dniKeyTyped

    private void txt_dni2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dni2KeyTyped

        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
        String b = txt_dni2.getText();
        if (b.length() >6) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dni2KeyTyped

    private void txt_dni4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dni4KeyTyped

        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }

        String b = txt_dni4.getText();
        if (b.length() >7) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dni4KeyTyped

    private void txt_dni3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dni3KeyTyped

        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }

        String b = txt_dni3.getText();
        if (b.length() >0) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dni3KeyTyped

    private void txt_dni5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dni5KeyTyped

        char a = evt.getKeyChar();
        if (!Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }

        String b = txt_dni5.getText();
        if (b.length() >0) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_dni5KeyTyped

    private void jButton7GUARDAR_PROD(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7GUARDAR_PROD

        String a = txt_nom.getText();
        String b = txt_dni.getText() + txt_dni2.getText() + txt_dni3.getText() + txt_dni4.getText() + txt_dni5.getText();
        String c = String.valueOf(comb_tip.getSelectedIndex());
        String d = txt_contc1.getText() + txt_contc2.getText();
        String e = txt_contc3.getText() + txt_contc4.getText() + txt_contc5.getText() + txt_contc6.getText();
        String g = txt_conp.getText();
        String h = txt_not.getText();
        
        PreparedStatement ps;
        String query = "INSERT INTO PROVEDOR(`nombre`,`DNI`,`tipo_dni`,`contacto1`,`contacto2`,`estado`,`concepto`,`Notas`) VALUES(?,?,?,?,?,1,?,?);";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            ps.setString(5, e);
            ps.setString(6, g);
            ps.setString(7, h);

            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, " Producto Agregado");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Agregar_Provedores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }

    }//GEN-LAST:event_jButton7GUARDAR_PROD

    private void jButton8SALIR(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8SALIR
        this.dispose();
    }//GEN-LAST:event_jButton8SALIR

    private void R5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R5ItemStateChanged
R3.setSelected(false);
R4.setSelected(false);
        
txt_contc3.setText("");
txt_contc4.setText("");
txt_contc5.setText("");
txt_contc6.setText("");
txt_contc3.setEnabled(false);
txt_contc4.setEnabled(false);
txt_contc5.setEnabled(true);
txt_contc6.setEnabled(true);

    }//GEN-LAST:event_R5ItemStateChanged

    private void R3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R3ItemStateChanged
R5.setSelected(false);
R4.setSelected(false);

txt_contc3.setText("");
txt_contc4.setText("");
txt_contc5.setText("");
txt_contc6.setText("");

txt_contc3.setEnabled(false);
txt_contc4.setEnabled(true);
txt_contc5.setEnabled(false);
txt_contc6.setEnabled(false);

    }//GEN-LAST:event_R3ItemStateChanged

    private void R4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R4ItemStateChanged
R3.setSelected(false);
R5.setSelected(false);
        
txt_contc3.setText("");
txt_contc4.setText("");
txt_contc5.setText("");
txt_contc6.setText("");


txt_contc3.setEnabled(true);
txt_contc4.setEnabled(false);
txt_contc5.setEnabled(false);
txt_contc6.setEnabled(false);

    }//GEN-LAST:event_R4ItemStateChanged

    private void R1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1ItemStateChanged

    R2.setSelected(false);

txt_contc1.setText("");
txt_contc2.setText("");
txt_contc1.setEnabled(true);
txt_contc2.setEnabled(false);

    }//GEN-LAST:event_R1ItemStateChanged

    private void validar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validar

        char validad = evt.getKeyChar();
        
        if (!Character.isDigit(validad)) {
            getToolkit().beep();
            evt.consume();
        }

        
    }//GEN-LAST:event_validar

    private void habilitar(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_habilitar

int a = comb_tip.getSelectedIndex();

        if (a == 0) {
            txt_dni.setEditable(true);
            txt_dni2.setEditable(true);
            txt_dni3.setEditable(true);
            txt_dni3.setText("");
            txt_dni2.setText("");
            txt_dni.setText("");
            txt_dni5.setEditable(false);
            txt_dni4.setEditable(false);
            txt_dni5.setText("");
            txt_dni4.setText("");
            
        }else if (a == 1){
        txt_dni.setEditable(false);
        txt_dni2.setEditable(false);
        txt_dni3.setEditable(false);
        txt_dni3.setText("");
        txt_dni2.setText("");
        txt_dni.setText("");
        txt_dni5.setEditable(true);
        txt_dni4.setEditable(true);
        txt_dni5.setText("");
        txt_dni4.setText("");
        }

    }//GEN-LAST:event_habilitar

    private void R2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2ItemStateChanged


    R1.setSelected(false);

txt_contc1.setText("");
txt_contc2.setText("");
txt_contc1.setEnabled(false);
txt_contc2.setEnabled(true);



    }//GEN-LAST:event_R2ItemStateChanged


    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_Provedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JRadioButton R3;
    private javax.swing.JRadioButton R4;
    private javax.swing.JRadioButton R5;
    private static javax.swing.JComboBox<String> comb_tip;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField txt_conp;
    private static javax.swing.JTextField txt_contc1;
    private static javax.swing.JTextField txt_contc2;
    private static javax.swing.JTextField txt_contc3;
    private static javax.swing.JTextField txt_contc4;
    private static javax.swing.JTextField txt_contc5;
    private static javax.swing.JTextField txt_contc6;
    private static javax.swing.JTextField txt_dni;
    private static javax.swing.JTextField txt_dni2;
    private static javax.swing.JTextField txt_dni3;
    private static javax.swing.JTextField txt_dni4;
    private static javax.swing.JTextField txt_dni5;
    private static javax.swing.JTextField txt_nom;
    private javax.swing.JEditorPane txt_not;
    private static javax.swing.JTextField txt_nota;
    // End of variables declaration//GEN-END:variables
}
