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


public class Buscador_Empleado extends javax.swing.JFrame {

DefaultTableModel TABLE;
    
    public Buscador_Empleado() {
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
            TABLE.addColumn("Usuario");
            TABLE.addColumn("ID_empleado");
            TABLE.addColumn("empleado");
            
            this.table.setModel(TABLE);
            String sql = "";
            if (valor.equals(""))
            {
            sql="select * from buscador_cajeros";
            }
            else{
             switch(a){
                case 0:{  sql="SELECT * FROM buscador_cajeros WHERE `usuario` like '"+valor+"%'";
                break;} 
                case 1:{  sql="SELECT * FROM buscador_cajeros WHERE `Nombre` like '"+valor+"%'";
                break;}
                case 2:{  sql="SELECT * FROM buscador_cajeros WHERE `Apellido` = '"+valor+"%'";
                break;}  
                case 3:{  sql="SELECT * FROM buscador_cajeros WHERE `Empleado` = '%"+valor+"%'";
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

            
            TABLE.addRow(datos);
            }
            table.setModel(TABLE);
            }catch(SQLException ex){
            Logger.getLogger(Buscador_Empleado.class.getName()).log(Level.SEVERE,null,ex);
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
        comb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Emp. Nombre", "Emp. Apellido", "Parte del Nombre" }));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
switch (x) {
  
       case 0:{
       
       
     
       }
       
       case 1:{
       
            String  b = (String) TABLE.getValueAt(table.getSelectedRow(), 0);
        Ventas_Productos.txt_user.setText(b);
           
       }
}
this.dispose();
    }//GEN-LAST:event_colocar_datos
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador_Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt;
    public static javax.swing.JLabel variable;
    // End of variables declaration//GEN-END:variables
}
