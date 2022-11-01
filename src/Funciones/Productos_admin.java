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

public class Productos_admin extends javax.swing.JFrame {

      DefaultTableModel TABLE;
    
public Productos_admin() {
        initComponents();
           this.TABLE = (DefaultTableModel) table.getModel();
         Mostrardatos();
    }

public final void Mostrardatos(){
    
//        filtro para el buscador de texto y el combo box
        String texto   = txt.getText();
        int filtro  = comb_0.getSelectedIndex();
          String fltr;
        switch (filtro){
            case 0:
                fltr = " `Codigo` like '"+ texto +"%' ";
                break;
            case 1:
                fltr = "  `Nombre` like '"+ texto +"%' ";
                break;
            case 2:
                fltr = "  `Nombre` like '%"+ texto +"%' ";
                break;
            default : fltr = "";
            break;
        }
        
        int filtro1 = comb_1.getSelectedIndex();
        
//        variable para la organizacion de los datos mostrados en la jtable 
        int order   = Integer.parseInt(orden.getText());
        String ord;
        switch(order){
            case 1:
                ord = "  order by `Codigo` asc";
                break;
            case 2:
                ord = "  order by `Codigo` desc";
                break;
            case 3:
                ord = "  order by `Nombre` asc";
                break;
            case 4:
                ord = "  order by `Nombre` desc";
                break;
            case 5:
                ord = "  order by `Stock` asc";
                break;
            case 6:
                ord = "  order by `Stock` desc";
                break;
            case 7:
                ord = "  order by `Precio Venta` asc";
                break;
            case 8:
                ord = "  order by `Precio Venta` desc";
                break;
            default: 
                ord = "";
            break;
        }
        
//        filtro para los producto que se comercian o no
   String fltr1;
        switch (filtro1){
            case 2:
                fltr1 = " Estado = 'Comerciable'";
                break;
            case 1:
                fltr1 = " Estado = 'No Comerciable'";
                break;
        default : fltr1 = "";
            break;
        }
 
//        filtro para los producto que el poseen el ITBIS o no
        int filtro2 = comb_2.getSelectedIndex();
        String fltr2;
        switch (filtro2){
            case 2:
                fltr2 = " `ITBIS(?)` = 'SI'";
                break;
            case 1:
                fltr2 = " `ITBIS(?)` = 'NO'";
                break;
        default : fltr2 = "";
            break;
        }
        
        MyConnection cc = new MyConnection();
        Connection cn = MyConnection.getConnection();
        Refrescardatos();
        TABLE.addColumn("Codigo");
        TABLE.addColumn("Nombre");
        TABLE.addColumn("P.-Compra");
        TABLE.addColumn("P.-Venta");
        TABLE.addColumn("Ganancia");
        TABLE.addColumn("ITBIS");
        TABLE.addColumn("Stock");
        TABLE.addColumn("Categoria");
        TABLE.addColumn("Provedor");
        TABLE.addColumn("Estado");

        this.table.setModel(TABLE);
        String sql = "";
        
     if (txt.equals("") && filtro1 == 0 && filtro2 == 0 && order == 0) {
       sql = "select * from vista_admin_producto " ;
    }
// como funciona? en base a las variables dependiendo si tiene un valor de uso o no se toma en cuenta para la condicional del "if"
// debido a que no se sabra con determinacion cuantos filtros se aplicara o sea cual si y cual no se colocan las condicionales en
// funcion de que en caso se coloquen varios filtros o la falta de alguno inesperado se pueda agregar un "AND" al String
        else if (!txt.equals("") && filtro1 == 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr;
    }
        else if (txt.equals("") && filtro1 != 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr1;
    }
        else if (txt.equals("") && filtro1 == 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr2;
    }
        else if (txt.equals("") && filtro1 == 0 && filtro2 == 0 && order != 0) {
       sql = "select * from vista_admin_producto " + ord;
    }
        
        else if (!txt.equals("") && filtro1 != 0 && filtro2 == 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr1;
    }
        else if (!txt.equals("") && filtro1 == 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr2;
    }
        else if (!txt.equals("") && filtro1 == 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr + ord;
    }
        else if (txt.equals("") && filtro1 != 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr1 +" AND "+ fltr2 ;
    }
        else if (txt.equals("") && filtro1 != 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr1 + ord;
    }
        else if (txt.equals("") && filtro1 == 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr2 + ord;
    }
     
        
     else if (!txt.equals("") && filtro1 != 0 && filtro2 != 0 && order == 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr1 +" AND "+ fltr2 ;
    }  
     else if (txt.equals("") && filtro1 != 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr1 +" AND "+ fltr2 + ord;
    }
       else if (!txt.equals("") && filtro1 != 0 && filtro2 == 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr1 + ord ;
    }
        else if (!txt.equals("") && filtro1 == 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr2 + ord ;
    }
        
        
        else if (!txt.equals("") && filtro1 != 0 && filtro2 != 0 && order != 0) {
       sql = "SELECT * FROM vista_admin_producto WHERE" + fltr +" AND "+ fltr1 +" AND "+ fltr2 + ord;
    } 
        
        
        
        String[] datos = new String[10];
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
                datos[9] = rs.getString(10);
                TABLE.addRow(datos);
            }
            table.setModel(TABLE);
        } catch (SQLException ex) {
            Logger.getLogger(Productos_admin1.class.getName()).log(Level.SEVERE, null, ex);
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
// se limpian todos los jtextfield's    

txt.setText("");
txt_cod.setText("");
txt_nom.setText("");
txt_stck.setText("");
txt_preC.setText("");
txt_preV.setText("");
txt_ganc.setText("");
txt_tip.setText("");
txt_prov.setText("");
comb_est.setSelectedIndex(1);
comb_it.setSelectedIndex(1);
        
Mostrardatos();
}

public void buscador_local(){
         
        
            PreparedStatement ps;
            ResultSet rs;
            String query = "select  Nombre, `Precio Compra`, `Precio Venta`, `ITBIS(?)`, Ganancia, Stock, Categoria, Estado, Provedor,`Nombre Provedor`, `DNI Provedor`, `Tipo DNI` from vista_admin_producto where Codigo = ?;";
            String a = txt_cod.getText();
            try {

                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, a);
                rs = ps.executeQuery();


                    while(rs.next()){
                
                    
                    String b=rs.getString("Nombre");
                    String c=rs.getString("Precio Compra");
                    String d=rs.getString("Precio Venta");
                    String e=rs.getString("Ganancia");
                    String f=rs.getString("Stock");
                    String g=rs.getString("Categoria");
                    String h=rs.getString("Provedor");
                    String i=rs.getString("Estado");
                    String j=rs.getString("ITBIS(?)");
                    String k=rs.getString("Nombre Provedor");
                    String l=rs.getString("DNI Provedor");
                    String m=rs.getString("Tipo DNI");
                    
                    txt_cod.setText(a);
                    txt_nom.setText(b);
                    txt_preC.setText(c);
                    txt_preV.setText(d);
                    txt_ganc.setText(e);
                    txt_stck.setText(f);
                    txt_tip.setText(g);
                    txt_prov.setText(h);
                    txt_prov1.setText(k);
                    txt_prov2.setText(l);
                    
                        if (!i.equals("Comerciable")) {
                            comb_est.setSelectedIndex(0);
                        }else{
                            comb_est.setSelectedIndex(1);
                        }
                        if (!j.equals("SI")) {
                            comb_it.setSelectedIndex(0);
                        }else{
                            comb_it.setSelectedIndex(1);
                        }
                        if (m.equals("RNC")) {
                            comb_prov.setSelectedIndex(1);
                        } else if(m.equals("Cedula")) {
                            comb_prov.setSelectedIndex(0);
                        }else if (m.equals("Pasaporte")) {
                            comb_prov.setSelectedIndex(2);
                        }else{
                            comb_prov.setSelectedIndex(3);
                        }
                            
                          
                    }
            }catch (java.sql.SQLException ex) {
                                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "error " + ex);
                            }


}

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_preC = new javax.swing.JTextField();
        txt_cod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_stck = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_preV = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_ganc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tip = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comb_est = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        comb_it = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        F_I = new javax.swing.JLabel();
        F_C = new javax.swing.JLabel();
        F_txt = new javax.swing.JLabel();
        orden = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        O_cod = new javax.swing.JRadioButton();
        O_nom = new javax.swing.JRadioButton();
        O_stck = new javax.swing.JRadioButton();
        R3 = new javax.swing.JRadioButton();
        R4 = new javax.swing.JRadioButton();
        O_preV = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comb_1 = new javax.swing.JComboBox<>();
        comb_2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        comb_0 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        comb_prov = new javax.swing.JComboBox<>();
        txt_prov1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_prov = new javax.swing.JTextField();
        txt_prov2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Savoye LET", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Panel de Productos");

        jLabel7.setFont(new java.awt.Font("Snell Roundhand", 0, 24)); // NOI18N
        jLabel7.setText("BookStore");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Savoye LET", 2, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("(administracion)");

        jLabel11.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel11.setText("Codigo:");

        txt_nom.setFont(new java.awt.Font("Mshtakan", 0, 16)); // NOI18N

        txt_preC.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        txt_cod.setEditable(false);
        txt_cod.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel6.setText("Compra");

        txt_stck.setEditable(false);
        txt_stck.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel12.setText("Stock");

        jLabel18.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel18.setText(" Venta");

        txt_preV.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Songti TC", 2, 18)); // NOI18N
        jLabel19.setText("Precios de:");

        jLabel20.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel20.setText("Ganancia:");

        txt_ganc.setEditable(false);
        txt_ganc.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel8.setText("Tipo");

        txt_tip.setEditable(false);
        txt_tip.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel21.setText("Estado:");

        comb_est.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        comb_est.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Comerciable", "Comerciable" }));

        jLabel25.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel25.setText("ITBIS");

        comb_it.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        comb_it.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nom))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tip))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_preC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_preV, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ganc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_stck, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comb_it, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comb_est, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel6)
                    .addComponent(txt_preC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txt_preV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txt_ganc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_stck, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comb_est, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comb_it, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(11, 11, 11))
        );

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/004-menu.png"))); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-guia.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("a c c i o n e s :");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel14.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Base de Datos:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/015-impresora-1.png"))); // NOI18N
        jButton4.setText("Reporte");

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/019-estado.png"))); // NOI18N
        jButton8.setText("Des/Activar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesActivar_Prod(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/016-goma-de-borrar.png"))); // NOI18N
        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar_prod(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/020-flexible.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Palatino", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/018-lapiz.png"))); // NOI18N
        jButton6.setText("Editar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_Prod(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        F_I.setText("0");

        F_C.setText("0");

        F_txt.setText("0");

        orden.setText("0");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/010-iniciar-sesion.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-grafico-de-cotizaciones.png"))); // NOI18N
        jLabel23.setText("Ordenar Por:");

        R1.setText("a-z");
        R1.setEnabled(false);
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Orden1(evt);
            }
        });

        R2.setText("z-a");
        R2.setEnabled(false);
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Orden_1(evt);
            }
        });

        O_cod.setText("Codigo :");
        O_cod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_cod(evt);
            }
        });

        O_nom.setText("Nombre :");
        O_nom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_nom(evt);
            }
        });

        O_stck.setText("Stock");
        O_stck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_stck(evt);
            }
        });

        R3.setText("asc");
        R3.setEnabled(false);
        R3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Orden2(evt);
            }
        });

        R4.setText("desc");
        R4.setEnabled(false);
        R4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Orden_2(evt);
            }
        });

        O_preV.setText("Precio V.");
        O_preV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                O_preV(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(O_nom)
                            .addComponent(O_cod)
                            .addComponent(O_stck, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O_preV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(R1)
                            .addComponent(R2)
                            .addComponent(R3)
                            .addComponent(R4)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel23))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(O_cod)
                    .addComponent(R1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(R2)
                    .addComponent(O_nom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(R3)
                    .addComponent(O_stck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(O_preV, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-buscar.png"))); // NOI18N
        jLabel24.setText("Filtrar Por:");

        jLabel3.setText("Comerciable : ");

        jLabel4.setText("ITBIS : ");

        comb_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "No", "SI" }));

        comb_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "No", "SI" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comb_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comb_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comb_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        table.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
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

        jLabel13.setFont(new java.awt.Font("Savoye LET", 0, 20)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("(en tiempo real)");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel15.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Inf. Productos");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        txt.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
        });

        comb_0.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Parte del Nombre" }));

        jLabel26.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel26.setText("Por : ");

        jLabel38.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel38.setText("Buscar Producto:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comb_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comb_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel38)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel35.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel35.setText("Tipo");

        jLabel36.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel36.setText("DNI");

        comb_prov.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        comb_prov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "RNC", "Pasaporte" }));

        txt_prov1.setEditable(false);
        txt_prov1.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel9.setText("Provedor");

        txt_prov.setEditable(false);
        txt_prov.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        txt_prov2.setEditable(false);
        txt_prov2.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel37.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comb_prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_prov2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txt_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_prov1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txt_prov1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txt_prov2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F_I)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F_C)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(F_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orden))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel34))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(F_I)
                            .addComponent(F_C)
                            .addComponent(F_txt)
                            .addComponent(orden))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void O_cod(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_cod
O_nom.setSelected(false);
R1.setSelected(false);
R2.setSelected(false);
R3.setSelected(false);
R4.setSelected(false);
if ( !O_nom.isSelected() && !O_cod.isSelected()) {
R1.setSelected(false);R1.setEnabled(false);
R2.setSelected(false);R2.setEnabled(false);
orden.setText("0");
}else{
R1.setEnabled(true);
R2.setEnabled(true);
}
    }//GEN-LAST:event_O_cod

    private void O_nom(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_nom
O_cod.setSelected(false);
R1.setSelected(false);
R2.setSelected(false);
R3.setSelected(false);
R4.setSelected(false);
if ( !O_nom.isSelected() && !O_cod.isSelected()) {
R1.setSelected(false);R1.setEnabled(false);
R2.setSelected(false);R2.setEnabled(false);
orden.setText("0");
}else{
R1.setEnabled(true);
R2.setEnabled(true);
}
    }//GEN-LAST:event_O_nom

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
apartados.Agregar_Producto mf = new apartados.Agregar_Producto();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void O_preV(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_preV
O_stck.setSelected(false);
O_nom.setSelected(false);
O_cod.setSelected(false);
R3.setSelected(false);
R4.setSelected(false);
R3.setSelected(false);
R4.setSelected(false);
if ( !O_stck.isSelected() && !O_preV.isSelected()) {
R3.setSelected(false);R3.setEnabled(false);
R4.setSelected(false);R4.setEnabled(false);
orden.setText("0");
}else{
R3.setEnabled(true);
R4.setEnabled(true);
}        Mostrardatos();

    }//GEN-LAST:event_O_preV

    private void O_stck(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_O_stck
O_preV.setSelected(false);
O_nom.setSelected(false);
O_cod.setSelected(false);
R1.setSelected(false);
R2.setSelected(false);
R3.setSelected(false);
R4.setSelected(false);
if ( !O_stck.isSelected() && !O_preV.isSelected()) {
R3.setSelected(false);R3.setEnabled(false);
R4.setSelected(false);R4.setEnabled(false);
orden.setText("0");
}else{
R3.setEnabled(true);
R4.setEnabled(true);
}        Mostrardatos();

    }//GEN-LAST:event_O_stck

    private void Borrar_prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_prod

        String a = txt_cod.getText();
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, " Necesitas Seleccionar El producto ");
        }else{
            
            PreparedStatement ps;
            String query = "DELETE FROM PRODUCTO WHERE `codigo_prod`= ?";
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                
                ps.setString(1, a);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Producto Eliminado ");
                    limpiar();
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
            
    }//GEN-LAST:event_Borrar_prod

    private void Editar_Prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_Prod

  String a = txt_cod.getText();
  String b = txt_nom.getText();
  String c = txt_preC.getText();
  String d = txt_preV.getText();
  String e = txt_prov.getText();
  String f = txt_tip.getText();
  
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, " Necesitas Seleccionar El producto ");
        }else{
            
            PreparedStatement ps;
            String query = "UPDATE PRODUCTO SET `Nombre` = ?,`precio_compra` = ?,`precio_venta` = ?,`provedor_id` = (SELECT `provedor_id` FROM PROVEDOR WHERE `nombre` = ?),`categoria_id` = (SELECT `categoria_id` FROM CATEGORIA WHERE `nombre` = ?) WHERE `codigo_prod`= ?";
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                
                ps.setString(6, a);
                ps.setString(1,b);
                ps.setString(2, c);
                ps.setString(3, d);
                ps.setString(4, e);
                ps.setString(5, f);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Producto Editado ");
                    limpiar();
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_Editar_Prod

    private void DesActivar_Prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesActivar_Prod

        String a = txt_cod.getText();
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, " Necesitas Seleccionar El producto ");
        }else{

            int b = comb_est.getSelectedIndex();
            if (b == 0) {
                
                
                PreparedStatement ps;
                String query = "UPDATE PRODUCTO SET `estado` = 1 WHERE `codigo_prod`= ?";
                try {
                    ps = MyConnection.getConnection().prepareStatement(query);
                    
                    ps.setString(1, a);
                    
                    if(ps.executeUpdate() > 0)
                    {
                        limpiar();
                        JOptionPane.showMessageDialog(null, " Producto Editado ");
                    }
                }
                catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "error "+ex);
                }
            } else if(b == 1){
                PreparedStatement ps;
                String query = "UPDATE PRODUCTO SET `estado` = 0 WHERE `codigo_prod`= ?";
                try {
                    ps = MyConnection.getConnection().prepareStatement(query);
                    
                    ps.setString(1, a);
                    
                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, " Producto Editado ");
                        limpiar();
                    }
                }
                catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "error "+ex);
                }
            }
        }
        
    }//GEN-LAST:event_DesActivar_Prod

    private void Orden1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Orden1
R2.setSelected(false);
        if (!R1.isSelected() ) {
            orden.setText("0");
        }else if ( O_cod.isSelected() && R1.isSelected()) {
            orden.setText("1"); 
        }else if ( O_nom.isSelected() && R1.isSelected()) {
            orden.setText("3"); 
        }
                Mostrardatos();
    }//GEN-LAST:event_Orden1

    private void Orden_1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Orden_1
R1.setSelected(false);
        if (!R1.isSelected() && !R2.isSelected()) {
            orden.setText("0");
        }else if (R2.isSelected() && O_cod.isSelected()) {
            orden.setText("2"); 
        }else if (R2.isSelected() && O_nom.isSelected()) {
            orden.setText("4"); 
        }
        Mostrardatos();
    }//GEN-LAST:event_Orden_1

    private void Orden2(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Orden2
R4.setSelected(false);
        if ( !R3.isSelected()) {
            orden.setText("0");
        }else if (R3.isSelected() && O_stck.isSelected()) {
            orden.setText("5"); 
        }else if (R3.isSelected() && O_preV.isSelected()) {
            orden.setText("7"); 
        }
        Mostrardatos();
    }//GEN-LAST:event_Orden2

    private void Orden_2(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Orden_2
R3.setSelected(false);
        if (!R4.isSelected()) {
            orden.setText("0");
        }else if ( O_stck.isSelected() && R4.isSelected()) {
            orden.setText("6"); 
        }else if ( O_preV.isSelected() && R4.isSelected()) {
            orden.setText("8"); 
        }
                Mostrardatos();
    }//GEN-LAST:event_Orden_2

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

  String  a = (String) TABLE.getValueAt(table.getSelectedRow(), 0);
        txt_cod.setText(a);
     buscador_local();

    }//GEN-LAST:event_tableMouseClicked

    private void txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyTyped
 String valor = txt.getText();
        if (valor.length() > 4){
            getToolkit().beep();
            evt.consume();
            
        }
       

    }//GEN-LAST:event_txtKeyTyped

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel F_C;
    private javax.swing.JLabel F_I;
    private javax.swing.JLabel F_txt;
    private javax.swing.JRadioButton O_cod;
    private javax.swing.JRadioButton O_nom;
    private javax.swing.JRadioButton O_preV;
    private javax.swing.JRadioButton O_stck;
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JRadioButton R3;
    private javax.swing.JRadioButton R4;
    private javax.swing.JComboBox<String> comb_0;
    private javax.swing.JComboBox<String> comb_1;
    private javax.swing.JComboBox<String> comb_2;
    private javax.swing.JComboBox<String> comb_est;
    private javax.swing.JComboBox<String> comb_it;
    private javax.swing.JComboBox<String> comb_prov;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel orden;
    private javax.swing.JTable table;
    public static javax.swing.JTextField txt;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_ganc;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_preC;
    private javax.swing.JTextField txt_preV;
    public static javax.swing.JTextField txt_prov;
    public static javax.swing.JTextField txt_prov1;
    public static javax.swing.JTextField txt_prov2;
    private javax.swing.JTextField txt_stck;
    public static javax.swing.JTextField txt_tip;
    // End of variables declaration//GEN-END:variables
}
