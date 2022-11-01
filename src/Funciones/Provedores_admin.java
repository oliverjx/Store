package Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Provedores_admin extends javax.swing.JFrame {
 
    DefaultTableModel TABLE;
    
    public Provedores_admin() {
        initComponents();
         this.TABLE = (DefaultTableModel) table.getModel();
         Mostrardatos();
    }

    public final void Mostrardatos(){
        String texto   = txt.getText();
        int filtro  = comb_fltr1.getSelectedIndex();
        
        int filtro1 = Integer.parseInt(F_C.getText());
        int filtro2 = Integer.parseInt(F_I.getText());
        
        int order   = Integer.parseInt(orden.getText());
        
        int fltr3 = comb_fltr1.getSelectedIndex();
        
        String ord;
        switch(order){
            case 1:
                ord = "  order by `ID` asc";
                break;
            case 2:
                ord = "  order by `ID` desc";
                break;
            case 3:
                ord = "  order by `Nombre` asc";
                break;
            case 4:
                ord = "  order by `Nombre` desc";
                break;
            case 5:
                ord = "  order by `DNI` asc";
                break;
            case 6:
                ord = "  order by `DNI` desc";
                break;
            
            default: 
                ord = "";
            break;
        }
        String fltr;
        switch (filtro){
            
            case 1:
                fltr = " `ID` like '"+ texto +"%' ";
                break;
            case 2:
                fltr = "  `DNI` like '"+ texto +"%' ";
                break;
            case 3:
                fltr = "  `Nombre` like '%"+ texto +"%' ";
                break;
            case 4:
                fltr = "  `Nombre` like '"+ texto +"%' ";
                break;
            default : 
                    fltr = "";;
            break;
        }
        String fltr1;
        switch (filtro1){
            case 1:
                fltr1 = " Estado = 'Activado'";
                break;
            case 2:
                fltr1 = " Estado = 'Desactivado'";
                break;
        default : fltr1 = "";
            break;
        }
        String fltr2;
        switch (filtro2){
            case 1:
                    fltr2 = " `Tipo DNI` = 'CEDULA'";
                break;
            case 2:
                fltr2 = " `Tipo DNI` = 'RNC'";
                break;
        default : fltr2 = "";
            break;
        }
        
        MyConnection cc = new MyConnection();
        Connection cn = MyConnection.getConnection();
        Refrescardatos();
        TABLE.addColumn("ID");
        TABLE.addColumn("Nombre");
        TABLE.addColumn("DNI");
        TABLE.addColumn("Tipo DNI");
        TABLE.addColumn("Contacto1");
        TABLE.addColumn("Contacto2");
        TABLE.addColumn("Estado");
        TABLE.addColumn("Concepto");
        TABLE.addColumn("Notas");
 

        this.table.setModel(TABLE);
        String sql = "";
        
        if (filtro == 0 && filtro1 == 0 && filtro2 == 0 && order == 0) {
       sql = "select * from vista_admin_provedor " ;
    }
     
        else if (filtro != 0 && filtro1 == 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr;
    }
        else if (filtro == 0 && filtro1 != 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr1;
    }
        else if (filtro == 0 && filtro1 == 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr2;
    }
        else if (filtro == 0 && filtro1 == 0 && filtro2 == 0 && order != 0) {
       sql = "select * from vista_admin_provedor " + ord;
    }
        
        else if (filtro != 0 && filtro1 != 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr1;
    }
        else if (filtro != 0 && filtro1 == 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr2;
    }
        else if (filtro != 0 && filtro1 == 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr + ord;
    }
        else if (filtro == 0 && filtro1 != 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr1 +" AND "+ fltr2 ;
    }
        else if (filtro == 0 && filtro1 != 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr1 + ord;
    }
        else if (filtro == 0 && filtro1 == 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr2 + ord;
    }
     
        
     else if (filtro != 0 && filtro1 != 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr1 +" AND "+ fltr2 ;
    }  
     else if (filtro == 0 && filtro1 != 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr1 +" AND "+ fltr2 + ord;
    }
       else if (filtro != 0 && filtro1 != 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr1 + ord ;
    }
        else if (filtro != 0 && filtro1 == 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr2 + ord ;
    }
        
        
        else if (filtro != 0 && filtro1 != 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_provedor WHERE" + fltr +" AND "+ fltr1 +" AND "+ fltr2 + ord;
    } 
        
        
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                TABLE.addRow(datos);
            }
            table.setModel(TABLE);
        } catch (SQLException ex) {
            Logger.getLogger(Provedores_admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }

public void Refrescardatos() {
        try {
            TABLE.setColumnCount(0);
            TABLE.setRowCount(0);
            table.revalidate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }


  

    public void limpiar(){
    txt_nom.setText("");
    txt_id.setText("");
    txt_contc1.setText("");
    txt_contc2.setText("");
    txt_dni.setText("");
    txt.setText("");
    comb_tip.setSelectedIndex(0);
    comb_est.setSelectedIndex(0);
      Mostrardatos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_contc1 = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        comb_est = new javax.swing.JComboBox<>();
        comb_tip = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txt_contc2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_conp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nota = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        C_no = new javax.swing.JRadioButton();
        C_si = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        I1 = new javax.swing.JRadioButton();
        I2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        O_ID = new javax.swing.JRadioButton();
        O_nom = new javax.swing.JRadioButton();
        O_DNI = new javax.swing.JRadioButton();
        F_I = new javax.swing.JLabel();
        F_C = new javax.swing.JLabel();
        orden = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        comb_fltr1 = new javax.swing.JComboBox<>();
        txt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Savoye LET", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Panel de Proveedores");

        jLabel7.setFont(new java.awt.Font("Snell Roundhand", 0, 24)); // NOI18N
        jLabel7.setText("BookStore");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Savoye LET", 2, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("(administracion)");

        jLabel11.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel11.setText("ID");

        txt_nom.setEditable(false);
        txt_nom.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_nom.setEnabled(false);

        txt_contc1.setEditable(false);
        txt_contc1.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc1.setEnabled(false);

        txt_id.setEditable(false);
        txt_id.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_id.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel6.setText("Contacto1");

        jLabel21.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel21.setText("Estado:");

        comb_est.setFont(new java.awt.Font("Mshtakan", 1, 14)); // NOI18N
        comb_est.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desactivado", "Activado" }));
        comb_est.setEnabled(false);

        comb_tip.setFont(new java.awt.Font("Mshtakan", 1, 14)); // NOI18N
        comb_tip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "RNC", "Cedula" }));
        comb_tip.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel22.setText("Tipo");

        txt_contc2.setEditable(false);
        txt_contc2.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_contc2.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel23.setText("Contacto2");

        txt_dni.setEditable(false);
        txt_dni.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_dni.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel24.setText("DNI");

        txt_conp.setEditable(false);
        txt_conp.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_conp.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel9.setText("Concepto");

        jLabel12.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel12.setText("Notas");

        txt_nota.setEditable(false);
        txt_nota.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_nota.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_contc1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_contc2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comb_est, 0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_conp, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comb_est, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_contc1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(txt_contc2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_conp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/004-menu.png"))); // NOI18N
        jButton2.setText("Volver");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/015-impresora-1.png"))); // NOI18N
        jButton4.setText("Reportar");

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/019-estado.png"))); // NOI18N
        jButton8.setText("Des/Activar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Des_Activar_Prod(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/016-goma-de-borrar.png"))); // NOI18N
        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_Prod(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-guia.png"))); // NOI18N

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/018-lapiz.png"))); // NOI18N
        jButton6.setText("Editar");

        jLabel14.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Base de Datos:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/020-flexible.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_Prod(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("a c c i o n e s :");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(31, 31, 31))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );

        jLabel28.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-buscar.png"))); // NOI18N
        jLabel28.setText("Filtrar Por:");

        C_no.setText("SI");
        C_no.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                C_noF_Comerciable_No(evt);
            }
        });

        C_si.setText("NO");
        C_si.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                C_siF_Comerciable_Si(evt);
            }
        });

        jLabel3.setText("Activado: ");

        jLabel8.setText("Tipo DNI");

        I1.setText("RNC");
        I1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                I1ItemStateChanged(evt);
            }
        });

        I2.setText("CEDULA");
        I2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                I2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(I1)
                            .addComponent(C_si))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C_no)
                            .addComponent(I2)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_si)
                    .addComponent(C_no)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(I1)
                    .addComponent(I2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Inf. Proveedores");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel29.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-grafico-de-cotizaciones.png"))); // NOI18N
        jLabel29.setText("Ordenar Por:");

        buttonGroup2.add(R1);
        R1.setSelected(true);
        R1.setText("A - Z");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1Orden1(evt);
            }
        });

        buttonGroup2.add(R2);
        R2.setText("Z - A");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2Orden_1(evt);
            }
        });

        buttonGroup1.add(O_ID);
        O_ID.setText("ID");
        O_ID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_ID(evt);
            }
        });

        buttonGroup1.add(O_nom);
        O_nom.setSelected(true);
        O_nom.setText("Nombre ");
        O_nom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_nom(evt);
            }
        });

        buttonGroup1.add(O_DNI);
        O_DNI.setText("DNI");
        O_DNI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_DNI(evt);
            }
        });

        F_I.setText("0");

        F_C.setText("0");

        orden.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(O_nom)
                                    .addComponent(O_ID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(R1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(R2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(O_DNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(F_I)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F_C)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orden)
                        .addGap(55, 55, 55))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(O_ID)
                    .addComponent(R1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(O_nom)
                    .addComponent(R2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(F_I)
                        .addComponent(F_C)
                        .addComponent(orden))
                    .addComponent(O_DNI))
                .addGap(15, 15, 15))
        );

        jLabel13.setFont(new java.awt.Font("Savoye LET", 0, 20)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("(en tiempo real)");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        table.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        comb_fltr1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comb_fltr1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "DNI", "Parte del Nombre", "Nombre" }));
        comb_fltr1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comb_fltr1ItemStateChanged(evt);
            }
        });

        txt.setFont(new java.awt.Font("Songti TC", 2, 16)); // NOI18N
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMouseClicked(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel19.setText("Buscar Prov.:");

        jLabel20.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel20.setText("Por:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb_fltr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb_fltr1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void C_noF_Comerciable_No(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_C_noF_Comerciable_No
        C_si.setSelected(false);
        if (!C_no.isSelected() && !C_si.isSelected()) {
            F_C.setText("0");
        }else{
            F_C.setText("1");
        }
        Mostrardatos();
    }//GEN-LAST:event_C_noF_Comerciable_No

    private void C_siF_Comerciable_Si(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_C_siF_Comerciable_Si
        C_no.setSelected(false);
        if (!C_no.isSelected() && !C_si.isSelected()) {
            F_C.setText("0");
        }else{
            F_C.setText("2");
        }        Mostrardatos();
    }//GEN-LAST:event_C_siF_Comerciable_Si

    private void I1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_I1ItemStateChanged
        I2.setSelected(false);
        if (!I2.isSelected() && !I1.isSelected()) {
            F_I.setText("0");
        }else{
            F_I.setText("2");
        }
        Mostrardatos();
    }//GEN-LAST:event_I1ItemStateChanged

    private void I2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_I2ItemStateChanged
        I1.setSelected(false);
        if (!I2.isSelected() && !I1.isSelected()) {
            F_I.setText("0");
        }else{
            F_I.setText("1");
        }
        Mostrardatos();
    }//GEN-LAST:event_I2ItemStateChanged

    
    // Otorgamiento de valor al jlabel "orden"
    private void R1Orden1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1Orden1


// DEPENDIENDO CUAL DE LOS OTROS JBUTTON ESTE TRUE SE DEFINIRA UN VALOR A LA VARIABLE ORDEN
        
        if (O_ID.isSelected()) {
            orden.setText("1");// id ordenado de A a Z
        }else if (O_nom.isSelected()) {
            orden.setText("3");// nombre ordenado de A a Z
        }else if (O_DNI.isSelected()) {
            orden.setText("5");// DNI ordenado de A a Z
        }
        Mostrardatos();
    }//GEN-LAST:event_R1Orden1

    private void R2Orden_1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2Orden_1
        

// DEPENDIENDO CUAL DE LOS OTROS JBUTTON ESTE TRUE SE DEFINIRA UN VALOR A LA VARIABLE ORDEN
        
       if (O_ID.isSelected()) {
            orden.setText("2");// id ordenado de Z a A
        }else if (O_nom.isSelected()) {
            orden.setText("4");// nombre ordenado de Z a A
        }else if (O_DNI.isSelected()) {
            orden.setText("6");// DNI ordenado de Z a A
        }
        Mostrardatos();
    }//GEN-LAST:event_R2Orden_1

    private void O_ID(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_ID

        Mostrardatos();
    }//GEN-LAST:event_O_ID

    private void O_nom(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_nom

        
        Mostrardatos();
    }//GEN-LAST:event_O_nom

    private void O_DNI(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_DNI

        R1.setSelected(false);
        R2.setSelected(false);
        if (O_DNI.isSelected()) {
            R1.setSelected(false);R1.setEnabled(false);
            R2.setSelected(false);R2.setEnabled(false);
        }
        
        Mostrardatos();
    }//GEN-LAST:event_O_DNI

    /* funcion para eliminar un provedor, en caso de que este no este vinculado con la bdd
    ; si resulta estar previamente vinculado se procedera a la desactivación*/
    private void Eliminar_Prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_Prod

          String a = txt_id.getText();
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, " Necesitas Seleccionar El producto ");
        }else{
            
            PreparedStatement ps;
            String query = "DELETE FROM PROVEDOR WHERE `provedor_id`= ?";
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                
                ps.setString(1, a);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Provedor Eliminado ");
                    limpiar();
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
              Mostrardatos();


    }//GEN-LAST:event_Eliminar_Prod
    
    // llama una pantalla para agregar un nuevo provedor
    private void Agregar_Prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_Prod

     apartados.Agregar_Provedores mf = new apartados.Agregar_Provedores();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);
    }//GEN-LAST:event_Agregar_Prod

    //funcino para desactivar o activar un provedor guardado en la base de datos
    private void Des_Activar_Prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Des_Activar_Prod

   String a = txt_id.getText();
   int b = comb_est.getSelectedIndex();
   
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, " Necesitas Seleccionar El Provedor ");
        }else{
           
            if (b == 0) {
            
            PreparedStatement ps;
            String query = "UPDATE PROVEDOR SET `estado`= true where `provedor_id`=?";
           
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                
                ps.setString(1, a);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Provedor Activado ");
                    limpiar();
                }
            }
        catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
            else if (b == 1) {
            
            PreparedStatement ps;
            String query = "UPDATE PROVEDOR SET `estado`= false where `provedor_id`=?";
           
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                
                ps.setString(1, a);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "Provedor Desactivado ");
                    limpiar();
                }
            }
        catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }
Mostrardatos();
    }//GEN-LAST:event_Des_Activar_Prod

    
    
    // llaman a mostrar datos debido a que su accion influye en la busqueda
    
    
    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        Mostrardatos();
    }//GEN-LAST:event_txtMouseClicked

    private void txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyTyped
        Mostrardatos();
    }//GEN-LAST:event_txtKeyTyped

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        Mostrardatos();
    }//GEN-LAST:event_txtKeyPressed

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        Mostrardatos();
    }//GEN-LAST:event_txtKeyReleased

    private void comb_fltr1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comb_fltr1ItemStateChanged
        Mostrardatos();
    }//GEN-LAST:event_comb_fltr1ItemStateChanged

    
    
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        // evento para pasar los datos de las filas seleccionada en la jtable a los jtextflieds correspondientes
        
        String a = (String) TABLE.getValueAt(table.getSelectedRow(),0);
        txt_id.setText(a);// id del provedor
        String b = (String) TABLE.getValueAt(table.getSelectedRow(),1);
        txt_nom.setText(b);// nombre del provedor
        String c = (String) TABLE.getValueAt(table.getSelectedRow(),2);
        txt_dni.setText(c);// DNI del provedor
        String d = (String) TABLE.getValueAt(table.getSelectedRow(),3);
        //tipo del dni del provedor
        if (d.equals("DNI")) {
            comb_tip.setSelectedIndex(1);
        }else if (d.equals("Cedula")) {
            comb_tip.setSelectedIndex(2);
        }else{
            comb_tip.setSelectedIndex(0);
        }
        String e = (String) TABLE.getValueAt(table.getSelectedRow(),4);
        txt_contc1.setText(e);// contacto #1 del provedor
        String f = (String) TABLE.getValueAt(table.getSelectedRow(),5);
        txt_contc2.setText(f);// contacto #2 del provedor


    }//GEN-LAST:event_tableMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Provedores_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton C_no;
    private javax.swing.JRadioButton C_si;
    private javax.swing.JLabel F_C;
    private javax.swing.JLabel F_I;
    private javax.swing.JRadioButton I1;
    private javax.swing.JRadioButton I2;
    private javax.swing.JRadioButton O_DNI;
    private javax.swing.JRadioButton O_ID;
    private javax.swing.JRadioButton O_nom;
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private static javax.swing.JComboBox<String> comb_est;
    private javax.swing.JComboBox<String> comb_fltr1;
    private static javax.swing.JComboBox<String> comb_tip;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel orden;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt;
    private static javax.swing.JTextField txt_conp;
    private static javax.swing.JTextField txt_contc1;
    private static javax.swing.JTextField txt_contc2;
    private static javax.swing.JTextField txt_dni;
    private static javax.swing.JTextField txt_id;
    private static javax.swing.JTextField txt_nom;
    private static javax.swing.JTextField txt_nota;
    // End of variables declaration//GEN-END:variables
}
