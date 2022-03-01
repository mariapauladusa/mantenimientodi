/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import com.mycompany.mantenimiento_paula.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import profesor.profe_addInci;
import profesor.profe_screen;

/**
 *
 * @author damA
 */
public class add_usuario extends javax.swing.JDialog {
    // Conexion Base de Datos
    Conectar conectar = new Conectar();
    // Variables relacionadas con el id
    String usuario;
    String id;
    
    // COMPROBAR SI NECESIDO EL ID DEL USUARIO

    /**
     * Creates new form add_usuario
     */
    public add_usuario(javax.swing.JDialog parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        
        conectar.getConexion();
        
        usuario = user;
        
        saberId();
        
        rellenarRol();
        rellenarDepa();
        
        icono();
    }
    
    // Metodo del icono
    public void icono(){
        ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
        this.setIconImage(img.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpass_usuario = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jtxt_nombreCompleto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcb_rol = new javax.swing.JComboBox<>();
        jcb_departamento = new javax.swing.JComboBox<>();
        jbtn_volver = new javax.swing.JButton();
        jcbMostrarOcultar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nombre de Usuario:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo Usuario");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre Completo:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Rol:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Departamento:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcb_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_rolActionPerformed(evt);
            }
        });

        jcb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_departamentoActionPerformed(evt);
            }
        });

        jbtn_volver.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_volver.setText("Volver");
        jbtn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_volverActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtn_volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(15, 15, 15)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(51, 51, 51)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxt_nombreCompleto)
                            .addComponent(jtxt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jcb_departamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcb_rol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jpass_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbMostrarOcultar)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpass_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMostrarOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxt_nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbtn_volver))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Boton que llama al metodo para crear un nuevo usuario
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       crearUsuario();
     
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // JComboBox relleno con cada rol
    private void jcb_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_rolActionPerformed
       rellenarRol();
    }//GEN-LAST:event_jcb_rolActionPerformed

    // JComboBox relleno con la informacion de cada departamento
    private void jcb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_departamentoActionPerformed
        rellenarDepa();
    }//GEN-LAST:event_jcb_departamentoActionPerformed

    // Boton Volver
    private void jbtn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_volverActionPerformed
        this.setVisible(false);
        ver_profesores screen = new ver_profesores(this, true, usuario);
        screen.setVisible(true);
    }//GEN-LAST:event_jbtn_volverActionPerformed
    
    // JCheckBox para mostrar u ocultar la contraseña
    private void jcbMostrarOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarOcultarActionPerformed
        // Si el JCheckBox esta seleccionado
        if (jcbMostrarOcultar.isSelected()) {
            // Muestro lo que haya introducido
            jpass_usuario.setEchoChar((char)0);
        }else{
            // Si no esta seleccionado/con el tick mostrar lo introducido con *****
            jpass_usuario.setEchoChar('*');
        }
    }//GEN-LAST:event_jcbMostrarOcultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbtn_volver;
    private javax.swing.JCheckBox jcbMostrarOcultar;
    private javax.swing.JComboBox<String> jcb_departamento;
    private javax.swing.JComboBox<String> jcb_rol;
    private javax.swing.JPasswordField jpass_usuario;
    private javax.swing.JTextField jtxt_email;
    private javax.swing.JTextField jtxt_nombre;
    private javax.swing.JTextField jtxt_nombreCompleto;
    // End of variables declaration//GEN-END:variables

    // Metodo para saber el id del usuario que se ha conectado
    private void saberId() {       
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("select id_profesor from fp_profesor where login = '" + usuario + "';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getString(1);
            }
            
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Rellenar ComboBox de Rol
    private void rellenarRol() {
        Connection conexion = conectar.getConexion();
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement("SELECT distinct id_rol, rol FROM fp_rol");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                jcb_rol.addItem(rs.getString("id_rol") + " - " + rs.getString("rol"));
            }
            
            conexion.close();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(profe_addInci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Rellenar ComboBox con los departamento
    private void rellenarDepa() {
         Connection conexion = conectar.getConexion();
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement("SELECT distinct id_departamento, departamento FROM fp_departamento");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                jcb_departamento.addItem(rs.getString("id_departamento") + " - " + rs.getString("departamento"));
            }
            
            conexion.close();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(profe_addInci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Insertar un nuevo usuario
    private void crearUsuario() {       
        String login = jtxt_nombre.getText();
        String pass = String.valueOf(jpass_usuario.getPassword());
        String nombre = jtxt_nombreCompleto.getText();
        String email = jtxt_email.getText();
        String activo = "1";
        String rol = (String) jcb_rol.getSelectedItem();
        String depa = (String) jcb_departamento.getSelectedItem();
        
        String[] r = rol.toString().split(" - ");
        String rolis = r[0];
        
        String[] d = depa.toString().split(" - ");
        String depas = d[0];

        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO fp_profesor(login, password, nombre_completo, email, activo, id_rol, id_departamento) VALUES('" + login + "','" + pass + "','" + nombre + "','" + email + "','" + activo + "','" + rolis + "','" + depas + "')");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario Creado");
            
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(profe_addInci.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
}
