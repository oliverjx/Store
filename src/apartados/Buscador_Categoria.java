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


public class Buscador_Categoria extends javax.swing.JFrame {

DefaultTableModel TABLE;
    
    public Buscador_Categoria() {
        initComponents();

    this.TABLE = (DefaultTableModel) table.getModel();
        
        Mostrardatos();
    }
    
     public final void Mostrardatos(){
      
        String valor = txt.getText();
        int a = comb.getSelectedIndex();
        MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
        Refrescardatos();
            
            TABLE.addColumn("ID");
            TABLE.addColumn("Categoria");
            TABLE.addColumn("Descripcion");
            
            this.table.setModel(TABLE);
            String sql = "";
            if (valor.equals(""))
            {
            sql="select * from Categoria";
            }
            else{
             switch(a){
                case 0:{  sql="SELECT * FROM Categoria WHERE `categoria_id` like '"+valor+"%'";
                break;} 
                case 1:{  sql="SELECT * FROM Categoria WHERE `Nombre` like '"+valor+"%'";
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

            
            TABLE.addRow(datos);
            }
            table.setModel(TABLE);
            }catch(SQLException ex){
            Logger.getLogger(Buscador_Categoria.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        } 
  public void Refrescardatos(){
        try {
        TABLE.setColumnCount(0);
        TABLE.setRowCount(0);
        table.revalidate();
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
        table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        comb = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();

        variable.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                colocar_datos(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel11.setFont(new java.awt.Font("Savoye LET", 2, 30)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Buscador de Productos");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Categoria" }));
        comb.setSelectedIndex(1);
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

        jToggleButton1.setText("X");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jToggleButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

this.dispose();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void colocar_datos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colocar_datos

    int x = Integer.parseInt(variable.getText());
// x = variable que se manda junto al llamado de esta pantalla para asi saber el uso dar al click selected

    switch (x) {
  
       case 0:{
// case 0 se solicita de la pantalla "Agregar_Producto"       
        String  a = (String) TABLE.getValueAt(table.getSelectedRow(), 1);
        Agregar_Producto.txt_tip.setText(a);
     
       }
       
       case 1:{
       
            String  b = (String) TABLE.getValueAt(table.getSelectedRow(), 1);
        Funciones.Productos_admin.txt_tip.setText(b);
           
       }
}
this.dispose();
    }//GEN-LAST:event_colocar_datos
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador_Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt;
    public static javax.swing.JLabel variable;
    // End of variables declaration//GEN-END:variables
}
