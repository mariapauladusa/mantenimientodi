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
import administrador.screenRoot;

/**
 *
 * @author damA
 */
public class loginRoot extends javax.swing.JDialog {
    
    // Conexion a la base de datos
    Conectar conectar = new Conectar();
    
    // usuario y contraseña
    public String user;
    public String pass;

    /**
     * Creates new form jdlr
     */
    public loginRoot(java.awt.Frame parent, boolean modal) {
        
        conectar.getConexion();
        
        initComponents();
        
        iconoPrograma();
        //iconosLabel();
      
    }
    
    // METODO PARA PONER UN ICONO
    public void iconoPrograma(){
        main m = new main();
        m.iconoPrograma();
    }
     
    
    //public void iconosLabel(){
    //    jLabel2.setIcon(new ImageIcon("src\\main\\java\\resources\\usuario.png"));
    //    jLabel3.setIcon(new ImageIcon("src\\main\\java\\resources\\padlock.png"));
    //}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbMostrarOcultar = new javax.swing.JCheckBox();
        jtxtUsuarioA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtnEntrarP = new javax.swing.JButton();
        jbtnVolverP = new javax.swing.JButton();
        jpassAdmin = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));

        jcbMostrarOcultar.setText("Ver");
        jcbMostrarOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMostrarOcultarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Administrador");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnEntrarP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnVolverP))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtUsuarioA)
                            .addComponent(jpassAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMostrarOcultar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUsuarioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpassAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMostrarOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnVolverP)
                    .addComponent(jbtnEntrarP))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   // JCB PARA MOSTRAR U OCULTAR LA CONTRASEÑA
    private void jcbMostrarOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarOcultarActionPerformed
         if (jcbMostrarOcultar.isSelected()) {
            jpassAdmin.setEchoChar((char)0);
        }else{
            jpassAdmin.setEchoChar('*');
        }
    }//GEN-LAST:event_jcbMostrarOcultarActionPerformed

    // BOTON PARA ENTRAR
    private void jbtnEntrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarPActionPerformed
        loginA();
    }//GEN-LAST:event_jbtnEntrarPActionPerformed

    // BOTON PARA VOLVER
    private void jbtnVolverPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverPActionPerformed
        this.setVisible(false);
        new main().setVisible(true);
    }//GEN-LAST:event_jbtnVolverPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnEntrarP;
    private javax.swing.JButton jbtnVolverP;
    private javax.swing.JCheckBox jcbMostrarOcultar;
    private javax.swing.JPasswordField jpassAdmin;
    private javax.swing.JTextField jtxtUsuarioA;
    // End of variables declaration//GEN-END:variables

    // METODO PARA EL LOGIN DE ADMINISTRADOR
    private void loginA() {
        
        Connection cn = conectar.getConexion();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        user = jtxtUsuarioA.getText();
        pass = String.valueOf(jpassAdmin.getPassword());
        
        int rol = 1;
        
        if (user.equals("") || pass.equals("")) {
          
            JOptionPane.showMessageDialog(this, "Si quieres entrar no dejes los campos vacios :( .", "Campos vacíos", 0);
            
        }else{
            
            try {
               
                ps = cn.prepareStatement("Select login, password, activo, id_rol from mantenimiento_dusa_p.fp_profesor where login = '" + user + "' and password = '" + pass + "' and id_rol = '" + rol + "'");
                
                if (rol==rol) {
                    
                    rs = ps.executeQuery();
                
                    if (rs.next()) {
                    
                        screenRoot sa = new screenRoot(this,true,user);
                        sa.setVisible(true);
                    
                    }else{
                        
                        JOptionPane.showMessageDialog(this, "El usuario introducido no corresponde como Administración.", "Usuario Incorrecto", 0);
                    }
                    
                }else{
                    
                    JOptionPane.showMessageDialog(this, "El usuario introducido no corresponde como Administración.", "Usuario Incorrecto", 0);
                }
                
                 
            } catch (SQLException e) {
                
                System.err.println(e.toString());
                JOptionPane.showConfirmDialog(this, "No se que ha pasado, pero algo ha ido mal :( .", "Errorsito", 2);
                
            }
        }
        
    }
}
