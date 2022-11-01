package apartados;


import Funciones.MyConnection;
import Funciones.Ventas_Productos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Buscador_Cliente extends javax.swing.JFrame {

DefaultTableModel TABLE_buscador_clientes;
    
    public Buscador_Cliente() {
        initComponents();

            this.TABLE_buscador_clientes = (DefaultTableModel) table_buscador_clientes.getModel();
            Mostrardatos();
     }
    
    public final void Mostrardatos(){
      
        String valor = txt.getText(); // varible para obtener lo escribo en el jtextflied
        int b = Integer.parseInt(R.getText());// variable para el filtro del RNC
        
        String fltr;// variable a la cual se le asigna una parte del sql para llevar un filtro
        switch(b){
            case 1:
                fltr = "AND WHERE `tipo_dni`= 'RNC'";
            break;
            case 2:
                fltr = "AND WHERE `tipo_dni` = 'Cedula'";
            break;
            default: 
                fltr = "";
            break;

        }
        
        MyConnection cc=new MyConnection();
        Connection cn=MyConnection.getConnection();
        Refrescardatos();
            
            TABLE_buscador_clientes.addColumn("ID");
            TABLE_buscador_clientes.addColumn("Nombre");
            TABLE_buscador_clientes.addColumn("DNI");
            
            this.table_buscador_clientes.setModel(TABLE_buscador_clientes);
            String sql = "";
            if (valor.equals("")){
                
            sql="select * from buscador_clientes" + fltr;
            
            }
            
            else {
            int a = comb.getSelectedIndex(); // variable para determinar el filtro de la columna
            
            switch(a){
                case 0:{  sql="SELECT * FROM buscador_clientes WHERE `ID` like '"+valor+"%' " + fltr;
                break;} 
                case 1:{  sql="SELECT * FROM buscador_clientes WHERE `Nombre` like '"+valor+"%' " + fltr;
                break;}
                case 2:{  sql="SELECT * FROM buscador_clientes WHERE `DNI` LIKE '"+valor+"%' " + fltr;
                break;} 
                        }   
                }
           

            String[] datos=new String [3];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);

            
            TABLE_buscador_clientes.addRow(datos);
            }
            table_buscador_clientes.setModel(TABLE_buscador_clientes);
            }catch(SQLException ex){
            Logger.getLogger(Buscador_Cliente.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        } 
    public void Refrescardatos(){
        try {
        TABLE_buscador_clientes.setColumnCount(0);
        TABLE_buscador_clientes.setRowCount(0);
        table_buscador_clientes.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        variable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_buscador_clientes = new javax.swing.JTable();
        txt = new javax.swing.JTextField();
        comb = new javax.swing.JComboBox<>();
        R1 = new javax.swing.JRadioButton();
        R2 = new javax.swing.JRadioButton();
        R = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        variable.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_buscador_clientes.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        table_buscador_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                colocar_datos(evt);
            }
        });
        jScrollPane1.setViewportView(table_buscador_clientes);

        txt.setFont(new java.awt.Font("Mshtakan", 0, 18)); // NOI18N
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
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

        comb.setFont(new java.awt.Font("Mshtakan", 1, 14)); // NOI18N
        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "DNI" }));
        comb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combItemStateChanged(evt);
            }
        });
        comb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combMouseClicked(evt);
            }
        });
        comb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combActionPerformed(evt);
            }
        });

        R1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        R1.setText("RNC");
        R1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R1ItemStateChanged(evt);
            }
        });

        R2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        R2.setText("Cedula");
        R2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                R2ItemStateChanged(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(204, 0, 51));
        jButton1.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(R1)
                            .addComponent(R2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(449, Short.MAX_VALUE)
                    .addComponent(R)
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(116, Short.MAX_VALUE)
                    .addComponent(R)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // todos hasta colocar datos son solo llamadas al metodo "Mostrardatos"
    
    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed

Mostrardatos();

    }//GEN-LAST:event_txtActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
   Mostrardatos();
    }//GEN-LAST:event_txtKeyPressed

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
   Mostrardatos();
    }//GEN-LAST:event_txtKeyReleased

    private void txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyTyped
   Mostrardatos();
    }//GEN-LAST:event_txtKeyTyped

    private void combItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combItemStateChanged
   Mostrardatos();
    }//GEN-LAST:event_combItemStateChanged

    private void combActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combActionPerformed
   Mostrardatos();
    }//GEN-LAST:event_combActionPerformed

    private void combMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combMouseClicked
   Mostrardatos();
    }//GEN-LAST:event_combMouseClicked

    private void combMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combMousePressed
   Mostrardatos();
    }//GEN-LAST:event_combMousePressed

    private void combMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combMouseReleased
   Mostrardatos();
    }//GEN-LAST:event_combMouseReleased

    /* Procedimiento de Colocar datos -- DE SUMA IMPORTANCIA --
    Al esta pantalla ser llamada de varias pantallas distintas al momento de llamarle
    dan un valor a el jlabel "variable" asi determinar a que pantalle y a cuales jtextflieds  
    mandar los datos del clientes, esto se programa en un switch en el evento  acontinuacion */
    
    private void colocar_datos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colocar_datos
// x es una variable enviada desde donde fue llamado el Ventas_Productos para definir a que jtextflied's seran enviados los datos al hacer click

    int x = Integer.parseInt(variable.getText());
        
    switch (x) {
        case 0: 
// si selecciona la primera fila, es decir, el cliente es un Contado se habilitaran los jtextflies requeridos para entrar su informacion
            if(table_buscador_clientes.getSelectedRow() == 0){
            
                Ventas_Productos.txt_cli.setText("Contado");
                Ventas_Productos.txt_nom_cli.setEnabled(true);
                Ventas_Productos.txt_num_cli.setEnabled(true);
                Ventas_Productos.txt_dni_cli.setEnabled(true);
       
            this.dispose();
                
            }else{
// si no es un cliente del contado solo se pasaran sus datos que estan previamente almacenado en la bdd
                String a = (String) TABLE_buscador_clientes.getValueAt(table_buscador_clientes.getSelectedRow(),0);
                String b = (String) TABLE_buscador_clientes.getValueAt(table_buscador_clientes.getSelectedRow(),1);
                String c = (String) TABLE_buscador_clientes.getValueAt(table_buscador_clientes.getSelectedRow(),2);
                String d = (String) TABLE_buscador_clientes.getValueAt(table_buscador_clientes.getSelectedRow(),3);
                
                    Ventas_Productos.txt_cli.setText(a);
                    Ventas_Productos.txt_nom_cli.setText(b);
                    Ventas_Productos.txt_num_cli.setText(c);
                    Ventas_Productos.txt_dni_cli.setText(d);
                
            this.dispose();
            }
        break;

       case 1:{
       
          
           
       }
}

    }//GEN-LAST:event_colocar_datos

    // dan el valor al jlabel R para asi determinar un filtro de RNC a la jtable de clientes
    
    private void R1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R1ItemStateChanged
R.setText("1");
    }//GEN-LAST:event_R1ItemStateChanged

    private void R2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_R2ItemStateChanged
R.setText("2");
    }//GEN-LAST:event_R2ItemStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel R;
    private javax.swing.JRadioButton R1;
    private javax.swing.JRadioButton R2;
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_buscador_clientes;
    private javax.swing.JTextField txt;
    public static javax.swing.JLabel variable;
    // End of variables declaration//GEN-END:variables
}
