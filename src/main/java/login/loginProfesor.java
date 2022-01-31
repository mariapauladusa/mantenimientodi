/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.mycompany.mantenimiento_paula.Conectar;
import com.mycompany.mantenimiento_paula.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mainUsuarios.mainProfesor;


/**
 *
 * @author damA
 */
public class loginProfesor extends javax.swing.JDialog {
    Conectar conectar = null;

    /**
     * Creates new form jd_login_profesor
     */
    public loginProfesor(java.awt.Frame parent, boolean modal) {
        
        conectar = new Conectar();
        
        initComponents();
    }

    public void loginProfesor(){
        Connection cn = conectar.getConexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String user = jtxtUsuarioP.getText();
        String pass = String.valueOf(jpassProfesor.getPassword());
        
        if (user.equals("") || pass.equals("")) {
          
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacìos.");
            
        }else{
            
            try {
               
                ps = cn.prepareStatement("Select login, password from mantenimiento_dusa_p.fp_profesor where login = '" + user + "' and password ='" + pass + "'");
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    
                    this.dispose();
                    System.out.print("Has entrado");
                    
                }else{
                    
                    JOptionPane.showConfirmDialog(this, "Los datos introducidos son incorrectos.");
                }
                 
            } catch (SQLException e) {
                System.err.println(e.toString());
                JOptionPane.showConfirmDialog(this, "Ha ocurrido un error");
                
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtUsuarioP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtnEntrarP = new javax.swing.JButton();
        jbtnVolverP = new javax.swing.JButton();
        jpassProfesor = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Profesor");

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO INSTITUTO");

        jbtnEntrarP.setText("ENTRAR");
        jbtnEntrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarPActionPerformed(evt);
            }
        });

        jbtnVolverP.setText("VOLVER");
        jbtnVolverP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnEntrarP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnVolverP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtUsuarioP, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jpassProfesor))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUsuarioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpassProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnEntrarP)
                    .addComponent(jbtnVolverP))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVolverPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverPActionPerformed
        this.setVisible(false);
        new main().setVisible(true);
    }//GEN-LAST:event_jbtnVolverPActionPerformed

    private void jbtnEntrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarPActionPerformed
       loginProfesor();
    }//GEN-LAST:event_jbtnEntrarPActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnEntrarP;
    private javax.swing.JButton jbtnVolverP;
    private javax.swing.JPasswordField jpassProfesor;
    private javax.swing.JTextField jtxtUsuarioP;
    // End of variables declaration//GEN-END:variables
}
