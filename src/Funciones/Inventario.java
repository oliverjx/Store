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

public class Inventario extends javax.swing.JFrame {

    DefaultTableModel TABLE_inventario;

    public Inventario() {
        initComponents();
        this.TABLE_inventario = (DefaultTableModel) table_inventario.getModel();
        Mostrardatos();
        
  
    }
    
    public final void Mostrardatos(){

        //variable valor, toma el el texto que se usa en el filtro del sql
    String valor = txt_prod.getText();
    
        // se seleciona la variable determinada por los radio button para elegir el codigo que ordenara los resultados en la jtable
        int x = Integer.parseInt(orden.getText());
        String ord; // variable que usa el switch para determinar una parte de String sql
        switch(x){
                case 1:{ ord = "order by `Nombre` asc";
                    } break;
                case 2:{ ord = "order by `Nombre` desc";
                    } break;
                case 3:{ ord = "order by `Codigo` asc";
                    } break;
                case 4:{ ord = "order by `Codigo` desc";
                    } break;
                case 5:{ ord = "order by `Stock` asc";
                    } break;
                case 6:{ ord = "order by `Stock` desc";
                    } break;
                default:{ ord = "";
                    } break;
        }
        
        
        MyConnection cc = new MyConnection();
        Connection cn = MyConnection.getConnection();
            Refrescardatos();
            TABLE_inventario.addColumn("Codigo");
            TABLE_inventario.addColumn("Nombre");
            TABLE_inventario.addColumn("Stock");

        this.table_inventario.setModel(TABLE_inventario);
        String sql = "";
        
         if (valor.equals("")) {
       
             sql = "select * from vista_inventario " + ord;
            
        }else{
        
        int b = comb_fltr.getSelectedIndex(); 
        // se selecciona el index del filtro asi denominar una columna a filtra a la table_inventario
        
        switch(b){
            
        // 1: Nombre   2: Codigo    3: Parte del Nombre
            case 1:
                sql= "Select * from vista_inventario where `Nombre` like '"+ valor+ "%' " + ord;
                break;
            case 2:
                sql= "Select * from vista_inventario where `Codigo` like '"+ valor + "%' " + ord;
                break;
            case 3:
                sql= "Select * from vista_inventario where `Nombre` like '%" + valor + "%' " + ord;
                break;
        }
        
         
        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                TABLE_inventario.addRow(datos);
            }
            table_inventario.setModel(TABLE_inventario);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }
    
    //metodo para refrescar la tabla
    public void Refrescardatos() {
        try {
            TABLE_inventario.setColumnCount(0);
            TABLE_inventario.setRowCount(0);
            table_inventario.revalidate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }
    }

    //metodo para limpiar todos los elementos
    public void limpiar(){
    txt_stcka.setText("");
    txt_stckn.setText("");
    txt_cod.setText("");
    txt_prod.setText("");
    R1.setSelected(false);
    R2.setSelected(false);
    R_cod.setSelected(false);
    R_nom.setSelected(false);
    R_az.setSelected(false);
    R_za.setSelected(false);
    Mostrardatos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        orden = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        R_az = new javax.swing.JRadioButton();
        R_za = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        R1 = new javax.swing.JRadioButton();
        R_cod = new javax.swing.JRadioButton();
        R_nom = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_inventario = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        comb_fltr = new javax.swing.JComboBox<>();
        txt_stockn1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_prod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_stcka = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_stckn = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();

        orden.setText("6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Savoye LET", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventario");

        jLabel7.setFont(new java.awt.Font("Snell Roundhand", 0, 24)); // NOI18N
        jLabel7.setText("BookStore");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Savoye LET", 2, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("(Stock de Productos)");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/001-inventario.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/004-menu.png"))); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volver_Action(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/002-grafico-de-cotizaciones.png"))); // NOI18N
        jLabel15.setText("Ordenar Por:");

        buttonGroup3.add(R_az);
        R_az.setText("A - Z");
        R_az.setEnabled(false);
        R_az.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R_azItemStateChanged(evt);
            }
        });

        buttonGroup3.add(R_za);
        R_za.setText("Z - A");
        R_za.setEnabled(false);
        R_za.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R_zaItemStateChanged(evt);
            }
        });

        buttonGroup2.add(R2);
        R2.setText("> - <");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(R1);
        R1.setText("< - >");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(R_cod);
        R_cod.setText("Codigo :");
        R_cod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R_codItemStateChanged(evt);
            }
        });

        buttonGroup2.add(R_nom);
        R_nom.setText("Nombre :");
        R_nom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R_nomItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(R_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R_az, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(R_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R_za, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(32, 32, 32))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_az)
                    .addComponent(R_cod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R_za)
                    .addComponent(R_nom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R1)
                    .addComponent(R2))
                .addContainerGap())
        );

        table_inventario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        table_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_inventarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_inventario);

        comb_fltr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Codigo", "Parte del Nombre" }));

        txt_stockn1.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Savoye LET", 0, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("(en tiempo real)");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("El Inventario Actual");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel17.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel17.setText("Por:");

        jLabel18.setFont(new java.awt.Font("Savoye LET", 0, 24)); // NOI18N
        jLabel18.setText("Buscar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_stockn1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comb_fltr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(comb_fltr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_stockn1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Todos");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Sin Existencia");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-inventario-1.png"))); // NOI18N
        jButton4.setText("Imprimir inventario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Inventario(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Con Existencia");

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/005-guia.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))))
                .addGap(12, 12, 12))
        );

        jLabel6.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel6.setText("Codigo:");

        txt_cod.setEditable(false);
        txt_cod.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel5.setText("Producto:");

        txt_prod.setEditable(false);
        txt_prod.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel3.setText("Stock Actual:");

        txt_stcka.setEditable(false);
        txt_stcka.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Songti TC", 0, 18)); // NOI18N
        jLabel4.setText("Stock Nuevo:");

        txt_stckn.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt_stckn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stcknKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/003-valores.png"))); // NOI18N
        jButton2.setText("Actualizar Stock");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizacion_Stock(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Savoye LET", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Datos del Producto");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txt_stckn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_stcka, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_stcka, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_stckn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Accion para salir de la pantalla
    private void Volver_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver_Action
//funcion para salir de esta pantalla
        this.dispose();
    }//GEN-LAST:event_Volver_Action
 
    // Funcion del Mouse Clicked - se tranfieren valores de la table_inventario a algunos jtextflieds especificos
    private void table_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventarioMouseClicked

    // se transfiere el Codigo del producto a jtextflied "txt_cod"
    String  c = (String) TABLE_inventario.getValueAt(table_inventario.getSelectedRow(), 0);
    txt_cod.setText(c);
    // se transfiere el nombre del producto a jtextflied "txt_prod"
    String  d = (String) TABLE_inventario.getValueAt(table_inventario.getSelectedRow(), 1);
    txt_prod.setText(d);
    // se transfiere el Stock Actual del producto a jtextflied "txt_stcka"
    String  e = (String) TABLE_inventario.getValueAt(table_inventario.getSelectedRow(), 2);
    txt_stcka.setText(e);
    }//GEN-LAST:event_table_inventarioMouseClicked

    // Funcion para actualizar el campo de "Stock" en la base de datos
    private void Actualizacion_Stock(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizacion_Stock
  
String  a= txt_stckn.getText();// variable para guardar el Stock nuevo del producto(stock a actualizar)    
String  b= txt_cod.getText(); // variable para guardar el Codigo del producto
int     c= Integer.parseInt(txt_stcka.getText());// variable para guardar el Stock Actual(al actualizar el antiguo) del producto
int     d= Integer.parseInt(b); // variable para la conversion de stcok nuevo del producto del producto
        

// condicion para que los jtextflied no esten vacios
        if(a.equals("") && b.equals(""))
          {
            JOptionPane.showMessageDialog(null, "Agregue los datos necesarios");
          }
// condicion para que 1 jtextflied no este vacio       
        else if(a.equals(""))
          {
            JOptionPane.showMessageDialog(null, "Agregue los datos necesarios");
          }
// condicion para que 1 jtextflied no este vacio       
        else if(b.equals(""))
          {
            JOptionPane.showMessageDialog(null, "Agregue los datos necesarios");
          }
// condicion para que el stock actual y el nuevo no sean los mismos 
        else if(c == d)
          {
            JOptionPane.showMessageDialog(null, "El Stock Nuevo no puede ser igual al Antiguo");
          }
          
            else{
        // llamada de un Procedure que realiza la actualizacion del Stock del Producto
                     PreparedStatement ps;
                     String query = "call DATA_BASE.Intenario(?,?);";
                try {
                     ps = MyConnection.getConnection().prepareStatement(query);
                     
                     ps.setString(1, a);// variable a es el stock nuevo(a actualizar)
                     ps.setString(2, b);// variable b es el Codigo del producto
                     
                      if(ps.executeUpdate() > 0)
                          {
                            JOptionPane.showMessageDialog(null, "Stock Actualizado");
                                Mostrardatos();
                                limpiar();
                          }
                    } 
                  catch (SQLException ex) {
                     Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
                     }        
              }
        
        
    }//GEN-LAST:event_Actualizacion_Stock

    //codigo para realizar un reporte del inventario
    private void Reporte_Inventario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Inventario



    }//GEN-LAST:event_Reporte_Inventario

    // Evento que evita el ingreso de otro caracter que no sea numero
    private void txt_stcknKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stcknKeyTyped

/* se declara la variable "Validar" y con el evento "evt.getkeychar"
   se adquiera el caracter a introducir al textflied
*/
char validar = evt.getKeyChar();

// si el caracter ingresado no es un numero haz: evt.consume
    if (!Character.isDigit(validar)){
        getToolkit().beep();
        evt.consume();
    }

    }//GEN-LAST:event_txt_stcknKeyTyped

    
    // este es el proceso de los Radio button y como manejan el jlabel de "orden" y se relacionan entre ellos
    
    private void R_codItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R_codItemStateChanged
    // si esta selected habilita los radio button de R_az y R_za
    if(R_cod.isSelected()){
        R_az.setEnabled(true);
        R_za.setEnabled(true);

    }
    // si esta selected habilita los radio button de R_az y R_za
    else{
        R_az.setSelected(false);
        R_za.setSelected(false);
        R_az.setEnabled(false);
        R_za.setEnabled(false); 
    }
    }//GEN-LAST:event_R_codItemStateChanged

    private void R_nomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R_nomItemStateChanged
    // si esta selected habilita los radio button de R_az y R_za
    if(R_nom.isSelected()){
        R_az.setEnabled(true);
        R_za.setEnabled(true);
    }
    // si esta selected habilita los radio button de R_az y R_za
    else{
        R_az.setSelected(false);
        R_za.setSelected(false);
        R_az.setEnabled(false);
        R_za.setEnabled(false);
    }
    }//GEN-LAST:event_R_nomItemStateChanged

    private void R2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2ItemStateChanged
//coloca en el jlabel "6" para denorminar este orden
orden.setText("6");
        Mostrardatos();
    }//GEN-LAST:event_R2ItemStateChanged

    private void R1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1ItemStateChanged
//coloca en el jlabel "5" para denorminar este orden
orden.setText("5");
        Mostrardatos();
    }//GEN-LAST:event_R1ItemStateChanged

    private void R_azItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R_azItemStateChanged
/*coloca en el jlabel "1" para denorminar el orden de A a Z en el codigo
y coloca en el jlabel "2" para denorminar el orden de A a Z en el Nombre
se determina si R_nom/R_codigo . isSelected()
*/
        if (R_nom.isSelected()) {
            orden.setText("1");

        } else if (R_cod.isSelected()) {
            orden.setText("2");
        }
            Mostrardatos();
    }//GEN-LAST:event_R_azItemStateChanged

    private void R_zaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R_zaItemStateChanged
/*coloca en el jlabel "3" para denorminar el orden de Z a A en el codigo 
Y coloca en el jlabel "4" para denorminar el orden de Z a A en el Nombre
se determina si R_nom/R_codigo . isSelected()
 */
        if (R_nom.isSelected()) {
            orden.setText("3");

        } else if (R_cod.isSelected()) {
            orden.setText("4");
        }
            Mostrardatos();
    }//GEN-LAST:event_R_zaItemStateChanged

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JRadioButton R_az;
    private javax.swing.JRadioButton R_cod;
    private javax.swing.JRadioButton R_nom;
    private javax.swing.JRadioButton R_za;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comb_fltr;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel orden;
    private javax.swing.JTable table_inventario;
    public static javax.swing.JTextField txt_cod;
    public static javax.swing.JTextField txt_prod;
    public static javax.swing.JTextField txt_stcka;
    private javax.swing.JTextField txt_stckn;
    private javax.swing.JTextField txt_stockn1;
    // End of variables declaration//GEN-END:variables
}
