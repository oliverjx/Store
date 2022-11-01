package Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ventas_Productos extends javax.swing.JFrame {

    DefaultTableModel TABLE_detalle, TABLE_producto;
    
    public Ventas_Productos() {
        initComponents();
            
            this.TABLE_detalle = (DefaultTableModel) table_detalle.getModel();
            this.TABLE_producto = (DefaultTableModel) table_producto.getModel();
                Mostrardatos_detalles();
                Mostrardatos_Productos();
    }
        
        public final void Mostrardatos_detalles(){
     
        MyConnection cc = new MyConnection();
        Connection cn = MyConnection.getConnection();
        Refrescardatos_detalles();
        TABLE_detalle.addColumn("Producto");
        TABLE_detalle.addColumn("Cantidad");
        TABLE_detalle.addColumn("Precio");
        TABLE_detalle.addColumn("Subtotal");
        
        this.table_detalle.setModel(TABLE_detalle);
        String sql = "select * from vista_facturacion;";
        
        
        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                TABLE_detalle.addRow(datos);
            }
            table_detalle.setModel(TABLE_detalle);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }
            public void Refrescardatos_detalles() {
        try {
            TABLE_detalle.setColumnCount(0);
            TABLE_detalle.setRowCount(0);
            table_detalle.revalidate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
        } 
        
        public final void Mostrardatos_Productos(){
 
        int x = Integer.parseInt(filtro.getText());
            String fltr;
               switch(x){
                   case 1:
                   fltr = "AND `ITBIS`= true";
                   break;
                   case 2:
                   fltr = "AND `ITBIS`= false";
                   break;
                   default:
                   fltr = "";
                   break;
               }
                
        
        String valor = txt_buscar.getText();
        int a = comb.getSelectedIndex();
        MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
        Refrescardatos_Productos();
            
            TABLE_producto.addColumn("Codigo");
            TABLE_producto.addColumn("Nombre");
            TABLE_producto.addColumn("Stock");
            TABLE_producto.addColumn("Precio");
            
            this.table_producto.setModel(TABLE_producto);
            String sql = "";
            if (valor.equals("") && R0.isSelected())
            {
            sql="select Codigo_prod, Nombre, Stock, Precio_venta from Producto";
            }
            else if(!valor.equals("")){
             switch(a){
                case 0:{  sql="SELECT Codigo_prod, Nombre, Stock, Precio_venta FROM Producto WHERE `Nombre` like '"+valor+"%'"+ fltr;
                break;} 
                case 1:{  sql="SELECT Codigo_prod, Nombre, Stock, Precio_venta FROM Producto WHERE `Codigo_prod` like '"+valor+"%'"+ fltr;
                break;}
                case 2:{  sql="SELECT Codigo_prod, Nombre, Stock, Precio_venta FROM Producto WHERE `Nombre` like '%"+valor+"%'"+ fltr;
                break;} 
            }
            }
            

            String[] datos=new String [4];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);

            
            TABLE_producto.addRow(datos);
            }
            table_producto.setModel(TABLE_producto);
            }catch(SQLException ex){
            Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        } 
            public void Refrescardatos_Productos(){
        try {
        TABLE_producto.setColumnCount(0);
        TABLE_producto.setRowCount(0);
        table_producto.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
  }
  
        public static void no_factura(){
        
       MyConnection cc = new MyConnection();
    Connection cn = MyConnection.getConnection();
    
try {  
    
    String Query = "Select MAX(factura_id) from FACTURA;";
    Statement st = cn.createStatement();
    ResultSet rs;
    rs = st.executeQuery(Query);
    
        while(rs.next()){
          int a = Integer.parseInt(rs.getString("MAX(factura_id)"));
          int b = a + 1;
          String venta = String.valueOf(b);
            System.out.println(venta);
            txt_fac.setText(venta);
            
        }
        
} catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "");}


    }
        
        public void limpiar(){
    txt_buscar.setText("");
    txt_precio.setText("");
    txt_cant.setText("");
    txt_stock.setText("");
    txt_prod.setText("");
    txt_cod.setText("");
    Mostrardatos_detalles();
    Mostrardatos_Productos();
    
    }
    
    public void refrescar_btns(){
    
        int a = table_detalle.getRowCount();
        
        if (a >= 1) {
            Btn5.setEnabled(true);
            Btn6.setEnabled(true);
            Btn7.setEnabled(true);
            Btn8.setEnabled(true);
        }
        
        String b = txt_user.getText();
        String c = txt_cli.getText();
        String d = txt_nom_cli.getText();
        
        if (a >= 1 && !b.equals("") && c.equals("") && d.equals("")) {
            
            Btn9.setEnabled(true);
        } else {
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        variable = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        filtro = new javax.swing.JLabel();
        ITBIS = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_num_cli = new javax.swing.JTextField();
        txt_user = new javax.swing.JTextField();
        txt_nom_cli = new javax.swing.JTextField();
        txt_dni_cli = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Btn1 = new javax.swing.JButton();
        txt_cli = new javax.swing.JTextField();
        txt_fac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Btn3 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Inventario = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_producto = new javax.swing.JTable();
        Buscador = new javax.swing.JPanel();
        comb = new javax.swing.JComboBox<>();
        txt_buscar = new javax.swing.JTextField();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        R0 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Acciones = new javax.swing.JPanel();
        Btn4 = new javax.swing.JButton();
        Btn6 = new javax.swing.JButton();
        Btn5 = new javax.swing.JButton();
        Btn7 = new javax.swing.JButton();
        Btn8 = new javax.swing.JButton();
        Btn9 = new javax.swing.JButton();
        Detalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_detalle = new javax.swing.JTable();
        txt_subtt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Producto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_prod = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        txt_cod = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        variable.setText("jLabel16");

        filtro.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Snell Roundhand", 0, 24)); // NOI18N
        jLabel2.setText("BookStore");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Savoye LET", 2, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Venta de Productos");

        jLabel11.setFont(new java.awt.Font("Savoye LET", 2, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("(facturación)");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-punto-de-venta.png"))); // NOI18N

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/004-menu.png"))); // NOI18N
        volver.setText("Volver");

        jLabel1.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel1.setText("Factura No.");

        txt_num_cli.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_num_cli.setEnabled(false);

        txt_user.setEditable(false);
        txt_user.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_user.setEnabled(false);
        txt_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_userMouseClicked(evt);
            }
        });

        txt_nom_cli.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_nom_cli.setEnabled(false);

        txt_dni_cli.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_dni_cli.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel14.setText("Número:");

        jLabel6.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel6.setText("Cliente:");

        Btn1.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn1.setText("Buscar Cajero");
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });

        txt_cli.setEditable(false);
        txt_cli.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_cli.setEnabled(false);

        txt_fac.setEditable(false);
        txt_fac.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_fac.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel4.setText("Cajero : ");

        jLabel15.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel15.setText("DNI:");

        Btn3.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn3.setText("limpiar datos fac");
        Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_fac(evt);
            }
        });

        Btn2.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn2.setText("Buscar Cliente");
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel23.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 51));
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 51));
        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 51));
        jLabel25.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel24))
                            .addComponent(txt_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addComponent(txt_num_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_nom_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_fac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nom_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_num_cli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dni_cli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        table_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_producto);

        comb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Codigo", "Parte del Nombre" }));

        txt_buscar.setFont(new java.awt.Font("Songti TC", 2, 16)); // NOI18N
        txt_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_buscarMouseClicked(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        ITBIS.add(R1);
        R1.setFont(new java.awt.Font("Mshtakan", 1, 16)); // NOI18N
        R1.setText("✓");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1ItemStateChanged(evt);
            }
        });

        ITBIS.add(R2);
        R2.setFont(new java.awt.Font("Mshtakan", 1, 16)); // NOI18N
        R2.setText("✘");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2ItemStateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Mshtakan", 1, 16)); // NOI18N
        jLabel16.setText("ITBIS");

        ITBIS.add(R0);
        R0.setFont(new java.awt.Font("Mshtakan", 1, 16)); // NOI18N
        R0.setSelected(true);
        R0.setText("●");
        R0.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R0ItemStateChanged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel18.setText("Buscar:");

        jLabel20.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel20.setText("Por:");

        javax.swing.GroupLayout BuscadorLayout = new javax.swing.GroupLayout(Buscador);
        Buscador.setLayout(BuscadorLayout);
        BuscadorLayout.setHorizontalGroup(
            BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R1)
                .addGap(4, 4, 4)
                .addComponent(R2)
                .addContainerGap())
        );
        BuscadorLayout.setVerticalGroup(
            BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(R2, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(R1, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(R0, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(comb, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout InventarioLayout = new javax.swing.GroupLayout(Inventario);
        Inventario.setLayout(InventarioLayout);
        InventarioLayout.setHorizontalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Buscador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InventarioLayout.setVerticalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Btn4.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn4.setText("Añadir Prod.");
        Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Añadir_prod(evt);
            }
        });

        Btn6.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn6.setText("Eliminar Prod.");
        Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_prod(evt);
            }
        });

        Btn5.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn5.setText("Cambiar Cant.");
        Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambiar_cant(evt);
            }
        });

        Btn7.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn7.setText("limpiar datos det");
        Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_det(evt);
            }
        });

        Btn8.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn8.setText("Cancelar Fac.");
        Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar_fac(evt);
            }
        });

        Btn9.setFont(new java.awt.Font("Songti TC", 2, 14)); // NOI18N
        Btn9.setText("Imprimir Fac.");
        Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimir_Fac(evt);
            }
        });

        javax.swing.GroupLayout AccionesLayout = new javax.swing.GroupLayout(Acciones);
        Acciones.setLayout(AccionesLayout);
        AccionesLayout.setHorizontalGroup(
            AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Btn8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        AccionesLayout.setVerticalGroup(
            AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        table_detalle.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        table_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_detalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_detalle);

        txt_subtt.setEditable(false);
        txt_subtt.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_subtt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel7.setText("Sub-Total :");

        txt_desc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Mshtakan", 2, 18)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel9.setText("% :");

        jLabel8.setFont(new java.awt.Font("Songti TC", 1, 18)); // NOI18N
        jLabel8.setText("TOTAL :");

        javax.swing.GroupLayout DetalleLayout = new javax.swing.GroupLayout(Detalle);
        Detalle.setLayout(DetalleLayout);
        DetalleLayout.setHorizontalGroup(
            DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetalleLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addGroup(DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetalleLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_subtt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DetalleLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        DetalleLayout.setVerticalGroup(
            DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_subtt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Songti TC", 3, 18)); // NOI18N
        jLabel17.setText("Producto(s) Añadido(s)");

        jLabel3.setFont(new java.awt.Font("Songti TC", 0, 16)); // NOI18N
        jLabel3.setText("Precio :");

        txt_prod.setEditable(false);
        txt_prod.setFont(new java.awt.Font("Mshtakan", 2, 16)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Songti TC", 0, 16)); // NOI18N
        jLabel22.setText("Cod.:");

        jLabel12.setFont(new java.awt.Font("Songti TC", 0, 16)); // NOI18N
        jLabel12.setText("Prod.:");

        txt_precio.setEditable(false);
        txt_precio.setFont(new java.awt.Font("Mshtakan", 2, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Songti TC", 0, 16)); // NOI18N
        jLabel5.setText("Cant.:");

        txt_cant.setFont(new java.awt.Font("Mshtakan", 2, 16)); // NOI18N
        txt_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantKeyTyped(evt);
            }
        });

        txt_cod.setEditable(false);
        txt_cod.setFont(new java.awt.Font("Mshtakan", 2, 16)); // NOI18N

        javax.swing.GroupLayout ProductoLayout = new javax.swing.GroupLayout(Producto);
        Producto.setLayout(ProductoLayout);
        ProductoLayout.setHorizontalGroup(
            ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ProductoLayout.setVerticalGroup(
            ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Acciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Acciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Songti TC", 3, 18)); // NOI18N
        jLabel21.setText("Buscar Producto(s)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volver)))
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // boton para limpiar los jtextflieds de la seccion de los datos de factura
    private void Limpiar_fac(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_fac
 txt_cli.setText("");
 txt_nom_cli.setText("");
 txt_num_cli.setText("");
 txt_dni_cli.setText("");
 txt_user.setText("");
 txt_fac.setText("");

    }//GEN-LAST:event_Limpiar_fac

    // boton para añadir producto a la factura(detalles)
    private void Añadir_prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir_prod

// variable para la cantidad del producto a ser agragado a detalle
String aa = txt_cant.getText();
// variable para guardar el nombre del Ventas_Productos seleccionado a agregar a detalle
String bb = txt_prod.getText();

int a = Integer.parseInt(aa);// conversion de aa de String a int
// variable para la cantidad que hay en el producto actualmente(antes de ser agragado a detalle)
int b = Integer.parseInt(txt_stock.getText());

// condicional para que el stock actula no sea igual a 0
        if (b <= 0) {
                 JOptionPane.showMessageDialog(null," No hay Articulos Disponibles ");
        }
// condicional para que el stock a pedir no sea mayor que el actual
        else if (a > b) {  
                 JOptionPane.showMessageDialog(null," Stock Insuficiente ");
        }
// condicional para que no se ingrese ningun producto con un "0" de cantidad
        else if (aa.equals("")) {
                 JOptionPane.showMessageDialog(null," Ingrese una cantidad ");
        }
//condicional para que seleccion un producto y con este el nombre
        else if (bb.equals("")) {
                 JOptionPane.showMessageDialog(null," Se necesita un Producto seleccionado ");
        }
//se llama a un procedimiento de la base de datos
        else{
            
             PreparedStatement ps;
                 String query = "call DATA_BASE.procedure_detalle(?,?)";
            try {
                 ps = MyConnection.getConnection().prepareStatement(query);
                 
                 ps.setString(1, bb);// nombre del producto
                 ps.setString(2, aa);// cantidad del detalle
                 
                  if(ps.executeUpdate() > 0)
                      {
                      JOptionPane.showMessageDialog(null, "Producto Agregado");
                      limpiar();
                    Mostrardatos_Productos();
                    Mostrardatos_detalles();
                      }
                } 
            catch (SQLException ex) {
                 Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "error "+ex);
                 }          
            
        }
       
    }//GEN-LAST:event_Añadir_prod

    // boton para eliminar todos los detalles actuales sin facturar
    private void Cancelar_fac(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar_fac
// ejecucion de un query que elimina los detalles que no estan enlazados a una factura
// es decir, los detalles que no han sido facturados 
 PreparedStatement ps;
                 String query = "DELETE FROM DETALLE WHERE `factura_id` IS NULL";
            try {
                 ps = MyConnection.getConnection().prepareStatement(query);
                 
                  if(ps.executeUpdate() > 0)
                      {
                      JOptionPane.showMessageDialog(null, "Factura Cancelada!");
                      
                        Mostrardatos_Productos();
                        Mostrardatos_detalles();
                      }
                } 
            catch (SQLException ex) {
                 Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "error "+ex);
                 }     
    }//GEN-LAST:event_Cancelar_fac

    
    // se realiza la factura oficialmente ingresando los datos de factura a la bdd
    // y se imprime la misma
    private void Imprimir_Fac(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimir_Fac
    
        String a = txt_desc.getText();
        String b = txt_user.getText();
        String cc = txt_cli.getText();
        String d = txt_num_cli.getText();
        String e = txt_nom_cli.getText();
        String f = txt_dni_cli.getText();
        
        String c = "";
        switch (cc){
            case "Contado":
                c = "0";
            default: 
                c = cc;
        }
        PreparedStatement ps;
                 String query = "call insert_factura(?,?,?,?,?,?)";
            try {
                 ps = MyConnection.getConnection().prepareStatement(query);
                 
                 ps.setString(1, a);
                 ps.setString(2, b);
                 ps.setString(3, c);
                 ps.setString(4, d);
                 ps.setString(5, e);
                 ps.setString(6, f);
                 
                  if(ps.executeUpdate() > 0)
                      {
                      JOptionPane.showMessageDialog(null, "Factura Realizada");
                      limpiar();
                      }
                } 
            catch (SQLException ex) {
                 Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "error "+ex);
                 }
            

int x = Integer.parseInt(txt_fac.getText());
Connection cn;
        cn = MyConnection.getConnection();
        try{

            JasperReport jr = (JasperReport) JRLoader.loadObject(Ventas_Productos.class.getResource("/Reportes/report1"));
            Map parametros = new HashMap<>();
            parametros.put("NUM", x);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
       
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        
txt_fac.setText("");
limpiar();

    }//GEN-LAST:event_Imprimir_Fac

    //elimina un producto especifico de la factura
    private void Eliminar_prod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_prod

        String a = txt_cod.getText();// variable para el codigo del producto a eliminar
        
         PreparedStatement ps;
                 String query = "delete from DETALLE where `cod_prod` = ? and `factura_id` is null";
            try {
                 ps = MyConnection.getConnection().prepareStatement(query);
                 
                 ps.setString(1, a);// codigo del producto
                 
                  if(ps.executeUpdate() > 0)
                      {
                      JOptionPane.showMessageDialog(null, "Producto Descontado");
                      limpiar();
                        Mostrardatos_Productos();
                        Mostrardatos_detalles();
                      }
                } 
            catch (SQLException ex) {
                 Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "error "+ex);
                 }          

    }//GEN-LAST:event_Eliminar_prod

    //cambia la cantidad de un producto ya introducido a los detalles
    private void Cambiar_cant(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cambiar_cant


      String a = txt_cod.getText();  // variable para albergar el codigo del producto
      String b = txt_cant.getText(); // variable para albergar la cantidad del producto
        
         PreparedStatement ps;// se llama un metodo creado para esta funcion en la base de datos
                 String query = "call DATA_BASE.update_cant(?, ?);";
            try {
                 ps = MyConnection.getConnection().prepareStatement(query);
                 
                 ps.setString(2, a);
                 ps.setString(1, b);
                 
                  if(ps.executeUpdate() > 0)
                      {
                      JOptionPane.showMessageDialog(null, "Cantidad Cambiada");
                      limpiar();
                      }
                } 
            catch (SQLException ex) {
                 Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "error "+ex);
                 }   

// se llaman los metodos para mostrar y refrescar datos
Mostrardatos_Productos();
Mostrardatos_detalles();
refrescar_btns();
    }//GEN-LAST:event_Cambiar_cant

    // se seleccion un producto de los añadidos para ejecutar una funcion
    private void table_detalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_detalleMouseClicked

        
    // se seleccion los datos de una fila de la tabla detalles y se pasan a los jtextflieds de jpanel producto
        String  a = (String) TABLE_detalle.getValueAt(table_detalle.getSelectedRow(), 0);
    txt_prod.setText(a);                                                                   // nombre del producto
        String  b = (String) TABLE_detalle.getValueAt(table_detalle.getSelectedRow(), 1);
    txt_cant.setText(b);                                                                   // cantidad del producto
        String  c = (String) TABLE_detalle.getValueAt(table_detalle.getSelectedRow(), 2);
    txt_precio.setText(c);                                                                 // precio del producto

    
    
  PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT codigo_prod, stock FROM PRODUCTO WHERE `nombre` =? ";

            try {

                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setString(1, a);
                rs = ps.executeQuery();

               

                while(rs.next()){

                String aa = rs.getString("codigo_prod");
                String bb = rs.getString("stock");
                                
                txt_cod.setText(aa);
                txt_buscar.setText(aa);
                txt_stock.setText(bb);
                
                }
            }catch (java.sql.SQLException ex) {
                Logger.getLogger(Ventas_Productos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error " + ex);
            }


    }//GEN-LAST:event_table_detalleMouseClicked

    private void txt_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_userMouseClicked


apartados.Buscador_Empleado mf = new apartados.Buscador_Empleado();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);

                apartados.Buscador_Empleado.variable.setText("1");



    }//GEN-LAST:event_txt_userMouseClicked

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        Mostrardatos_Productos();
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        Mostrardatos_Productos();
    }//GEN-LAST:event_txt_buscarKeyTyped

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        Mostrardatos_Productos();
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Mostrardatos_Productos();
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void R1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1ItemStateChanged

        if (R1.isSelected()) {
            filtro.setText("1");
        }else if (R2.isSelected()) {
            filtro.setText("2");
        }else{
            filtro.setText("0");
        }
        Mostrardatos_Productos();
    }//GEN-LAST:event_R1ItemStateChanged

    private void R2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2ItemStateChanged

        if (R1.isSelected()) {
            filtro.setText("1");
        }else if (R2.isSelected()) {
            filtro.setText("2");
        }else{
            filtro.setText("0");
        }
        Mostrardatos_Productos();
    }//GEN-LAST:event_R2ItemStateChanged

    private void R0ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R0ItemStateChanged
        Mostrardatos_Productos();
    }//GEN-LAST:event_R0ItemStateChanged

    private void table_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productoMouseClicked

        String a = (String) TABLE_producto.getValueAt(table_producto.getSelectedRow(),0);
        String b = (String) TABLE_producto.getValueAt(table_producto.getSelectedRow(),1);
        String c = (String) TABLE_producto.getValueAt(table_producto.getSelectedRow(),2);
        String d = (String) TABLE_producto.getValueAt(table_producto.getSelectedRow(),3);

        txt_cod.setText(a);
        txt_prod.setText(b);
        txt_stock.setText(c);
        txt_precio.setText(d);


    }//GEN-LAST:event_table_productoMouseClicked

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2ActionPerformed

        apartados.Buscador_Cliente mf = new apartados.Buscador_Cliente();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);

        apartados.Buscador_Cliente.variable.setText("0");



    }//GEN-LAST:event_Btn2ActionPerformed

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed

        
        apartados.Buscador_Empleado mf = new apartados.Buscador_Empleado();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);

        apartados.Buscador_Empleado.variable.setText("1");
        
    }//GEN-LAST:event_Btn1ActionPerformed

    private void txt_cantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyTyped

        char validar = evt.getKeyChar();
        
        if (!Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txt_cantKeyTyped

    private void limpiar_det(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_det
txt_cod.setText("");
txt_prod.setText("");
txt_precio.setText("");
txt_cant.setText("");

    }//GEN-LAST:event_limpiar_det

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas_Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acciones;
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton Btn4;
    private javax.swing.JButton Btn5;
    private javax.swing.JButton Btn6;
    private javax.swing.JButton Btn7;
    private javax.swing.JButton Btn8;
    private javax.swing.JButton Btn9;
    private javax.swing.JPanel Buscador;
    private javax.swing.JPanel Detalle;
    private javax.swing.ButtonGroup ITBIS;
    private javax.swing.JPanel Inventario;
    private javax.swing.JPanel Producto;
    private javax.swing.JRadioButton R0;
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JLabel filtro;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_detalle;
    private javax.swing.JTable table_producto;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cant;
    public static javax.swing.JTextField txt_cli;
    public static javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_desc;
    public static javax.swing.JTextField txt_dni_cli;
    private static javax.swing.JTextField txt_fac;
    public static javax.swing.JTextField txt_nom_cli;
    public static javax.swing.JTextField txt_num_cli;
    public static javax.swing.JTextField txt_precio;
    public static javax.swing.JTextField txt_prod;
    public static javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_subtt;
    private javax.swing.JTextField txt_total;
    public static javax.swing.JTextField txt_user;
    public static javax.swing.JLabel variable;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
