/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.mycompany.mantenimiento_paula.Conectar;
import com.mycompany.mantenimiento_paula.encriptarPwd;
import com.mycompany.mantenimiento_paula.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import profesor.profe_screen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author damA
 */     
public class loginProfesor extends javax.swing.JDialog {
    // Conexion a la base de datos
    Conectar conectar = new Conectar();
    // Variable para el usuario y la contraseña
    String user;
    String pass;
    // Para saber si el usuario esta activo o no
    String activo;
    String a;    
    /**
     * Creates new form jd_login_profesor
     */
    public loginProfesor(java.awt.Frame parent, boolean modal) {       
        conectar.getConexion();
        // activo sera activo
        a = activo;        
        initComponents();
        // Metodo iconos
        iconosLabel();
        iconoPrograma();
        // Metodo para recoger activo
        saberActivo();
        
        jpassProfesor.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    loginProfesor();
                }
            }
  
        });
    }
    
    // Metodo para el icono del programa
    public void iconoPrograma(){
       ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
       this.setIconImage(img.getImage());
    }
    
    // Método para los iconos de usuario y contraseña
    public void iconosLabel(){
        jLabel2.setIcon(new ImageIcon("src\\main\\java\\resources\\usuario.png"));
        jLabel3.setIcon(new ImageIcon("src\\main\\java\\resources\\padlock.png"));
    }

    // Metod para el login del profesor
    public void loginProfesor(){       
        // Conexión a la base de datos
        Connection cn = conectar.getConexion();          
        // Recojo valor de txt user y jpass
        user = jtxtUsuarioP.getText();
        pass = String.valueOf(encriptarPwd.encode(jpassProfesor.getText()));
        
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        // Indico que el rol es 3 que corresponde con profesor
        int rol = 3;
        // Indico que activo sera true
        a = "1";
        
        // Si los txt estan vacioes
        if (user.equals("") || pass.equals("")) {          
            // Mostrara un mensaje de campos vacios, los campos no pueden estar vacios
            JOptionPane.showMessageDialog(this, "Si quieres entrar no dejes los campos vacios :( ", "Campos vacíos", 0);
        // Si el rol corresponde con su rol en este caso 3 para profesor    
        }else if (rol == rol) {            
            try {
            // Si activo corresponde con true/activo
                if (a==a) {                    
                    ps = cn.prepareStatement("Select id_profesor, login, password, activo, id_rol from mantenimiento_dusa_p.fp_profesor where login = '" + user + "' and password = '" + pass + "' and id_rol = '" + rol + "' and activo = '" + a + "'");
                    rs = ps.executeQuery();                   
                    if (rs.next()) {                   
                        this.setVisible(false);
                        profe_screen mp = new profe_screen(this, true, user);
                        mp.setVisible(true);                    
                    }else{                        
                        JOptionPane.showMessageDialog(this, "ERROR!!\nEl usuario introducio no corresponde o esta inactivo.");
                    }                    
                }else{                   
                    //JOptionPane.showMessageDialog(this, "El usuario introducido no esta activo.", "Usuario Inactivo", 0);
                }
                // Cierro conexion cuando termine de usarla
                cn.close();               
            } catch (SQLException e) {               
                System.err.println(e.toString());
                JOptionPane.showConfirmDialog(this, "No se que ha pasado, pero algo ha ido mal :( ", "Errorsito", 2);               
            }           
        }else{
            // Por aqui nunca entra
            //JOptionPane.showConfirmDialog(null, "El usuario introducido no corresponde a Profesor", "Error Log In", 0);
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

        jtxtUsuarioP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtnEntrarP = new javax.swing.JButton();
        jbtnVolverP = new javax.swing.JButton();
        jpassProfesor = new javax.swing.JPasswordField();
        jcbMostrarOcultar = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));

        jtxtUsuarioP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Profesor");

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO INSTITUTO");

        jbtnEntrarP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtnEntrarP.setText("ENTRAR");
        jbtnEntrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarPActionPerformed(evt);
            }
        });

        jbtnVolverP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtnVolverP.setText("VOLVER");
        jbtnVolverP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverPActionPerformed(evt);
            }
        });

        jpassProfesor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jpassProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpassProfesorActionPerformed(evt);
            }
        });

        jcbMostrarOcultar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jcbMostrarOcultar.setText("Ver");
        jcbMostrarOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMostrarOcultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnVolverP)
                        .addGap(123, 123, 123)
                        .addComponent(jbtnEntrarP))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtUsuarioP, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jpassProfesor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMostrarOcultar)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtUsuarioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcbMostrarOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jpassProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnVolverP)
                    .addComponent(jbtnEntrarP))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Al darle al boton de volver atras esta ventana ya no sera visible y se mostrara la pantalla principal
    private void jbtnVolverPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverPActionPerformed
        // Quito la visibilidad de esta pantalla
        this.setVisible(false);
        // Muestro la pantalla principal
        new main().setVisible(true);
    }//GEN-LAST:event_jbtnVolverPActionPerformed

    // Al darle en el boton de entrar, llamo al metodo que he creado para realizar el login
    private void jbtnEntrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarPActionPerformed
       loginProfesor();
       // Declaro los JText a null para que se vacie la informacion introducida al entrar
       jtxtUsuarioP.setText(null);
       jpassProfesor.setText(null);
    }//GEN-LAST:event_jbtnEntrarPActionPerformed

    // Check Box para mostrar o no la contraseña al darle
    private void jcbMostrarOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarOcultarActionPerformed
        // Si el JCheckBox esta seleccionado
        if (jcbMostrarOcultar.isSelected()) {
            // Muestro lo que haya introducido
            jpassProfesor.setEchoChar((char)0);
        }else{
            // Si no esta seleccionado/con el tick mostrar lo introducido con *****
            jpassProfesor.setEchoChar('*');
        }
    }//GEN-LAST:event_jcbMostrarOcultarActionPerformed

    // No hace falta pero no puedo borrar
    private void jpassProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpassProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpassProfesorActionPerformed

     // Metodo para recoger el estado de activo
    private void saberActivo() {
        Connection conexion = conectar.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement("select activo from fp_profesor where activo = '" + activo + "';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnEntrarP;
    private javax.swing.JButton jbtnVolverP;
    private javax.swing.JCheckBox jcbMostrarOcultar;
    private javax.swing.JPasswordField jpassProfesor;
    private javax.swing.JTextField jtxtUsuarioP;
    // End of variables declaration//GEN-END:variables
}
