/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnico;

import com.mycompany.mantenimiento_paula.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import profesor.add_incidencia;
import profesor.screenProfesor;

/**
 *
 * @author damA
 */
public class modify_incidencia_tec extends javax.swing.JDialog {

    Conectar conectar = new Conectar();

    // Variable para el id del usuario
    String usuario;
    String id;
    // Variable para el id de la incidencia
    String idIn;

    /**
     * Creates new form modify_incidencia_tec
     */
    public modify_incidencia_tec(javax.swing.JDialog parent, boolean modal, String user, String idInci) {
        super(parent, modal);

        conectar.getConexion();

        usuario = user;
        idIn = idInci;

        initComponents();

        icono();
        saberId();

        rellenar_urg();
        rellenar_es();
        rellenar_ubis();

        rellenarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxta_observaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxta_descrTec = new javax.swing.JTextArea();
        jbtn_guardar = new javax.swing.JButton();
        jbtn_volver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jcbo_estado = new javax.swing.JComboBox<>();
        jcb_urgencia = new javax.swing.JComboBox<>();
        jtxt_horas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxt_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxt_fechaini = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxt_fechafin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxta_descripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jcbo_ubis = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jlbl_estado = new javax.swing.JLabel();
        jlbl_urg = new javax.swing.JLabel();
        jlbl_ubis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(909, 598));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Observaciones:");

        jtxta_observaciones.setColumns(20);
        jtxta_observaciones.setRows(5);
        jScrollPane3.setViewportView(jtxta_observaciones);

        jtxta_descrTec.setColumns(20);
        jtxta_descrTec.setRows(5);
        jScrollPane2.setViewportView(jtxta_descrTec);

        jbtn_guardar.setText("Guardar");
        jbtn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_guardarActionPerformed(evt);
            }
        });

        jbtn_volver.setText("Volver");
        jbtn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_volverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Horas:");

        jcbo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbo_estadoActionPerformed(evt);
            }
        });

        jcb_urgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_urgenciaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Inicial Reparacion:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Fecha Final Reparacion:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Urgencia:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICAR INCIDENCIA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        jtxta_descripcion.setColumns(20);
        jtxta_descripcion.setRows(5);
        jScrollPane1.setViewportView(jtxta_descripcion);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Ubicación:");

        jcbo_ubis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbo_ubisActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Descripción Técnica:");

        jlbl_estado.setForeground(new java.awt.Color(255, 0, 0));

        jlbl_urg.setForeground(new java.awt.Color(255, 0, 0));

        jlbl_ubis.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_fechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlbl_ubis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlbl_urg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jcb_urgencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlbl_estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jcbo_ubis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_guardar)
                        .addGap(80, 80, 80))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtn_volver)
                                    .addComponent(jbtn_guardar))
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxt_fechaini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxt_fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxt_horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbl_ubis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbo_ubis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jlbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jlbl_urg, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcb_urgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Boton guardar
    private void jbtn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_guardarActionPerformed
        modificarIncidencia();
    }//GEN-LAST:event_jbtn_guardarActionPerformed

    // Combo Box de estados
    private void jcbo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbo_estadoActionPerformed
        rellenar_es();
    }//GEN-LAST:event_jcbo_estadoActionPerformed

    // Combo Box de nivel de urgencia
    private void jcb_urgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_urgenciaActionPerformed
        rellenar_urg();
    }//GEN-LAST:event_jcb_urgenciaActionPerformed

    // Combo box de ubicaciones
    private void jcbo_ubisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbo_ubisActionPerformed
        rellenar_ubis();
    }//GEN-LAST:event_jcbo_ubisActionPerformed

    // Boton para volver
    private void jbtn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_volverActionPerformed
        dispose();
    }//GEN-LAST:event_jbtn_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtn_guardar;
    private javax.swing.JButton jbtn_volver;
    private javax.swing.JComboBox<String> jcb_urgencia;
    private javax.swing.JComboBox<String> jcbo_estado;
    private javax.swing.JComboBox<String> jcbo_ubis;
    private javax.swing.JLabel jlbl_estado;
    private javax.swing.JLabel jlbl_ubis;
    private javax.swing.JLabel jlbl_urg;
    private javax.swing.JTextField jtxt_fecha;
    private javax.swing.JTextField jtxt_fechafin;
    private javax.swing.JTextField jtxt_fechaini;
    private javax.swing.JTextField jtxt_horas;
    private javax.swing.JTextArea jtxta_descrTec;
    private javax.swing.JTextArea jtxta_descripcion;
    private javax.swing.JTextArea jtxta_observaciones;
    // End of variables declaration//GEN-END:variables

    // Metodo para poner icono al programa
    private void icono() {
        ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
        this.setIconImage(img.getImage());
    }

    // Metodo para averiguar el id del usuario
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
            Logger.getLogger(modify_incidencia_tec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para modificar una incidencia
    private void modificarIncidencia() {
        String descripcion = jtxta_descripcion.getText();
        String descrTecnico = jtxta_descrTec.getText();
        String horas = jtxt_horas.getText();
        String estado = (String) jcbo_estado.getSelectedItem();
        String fecha = jtxt_fecha.getText();
        String f_ini = jtxt_fechaini.getText();
        String f_fin = jtxt_fechafin.getText();
        String urgencia = (String) jcb_urgencia.getSelectedItem();
        String ubicacion = (String) jcbo_ubis.getSelectedItem();
        String observaciones = jtxta_observaciones.getText();

        String[] u = ubicacion.toString().split(" - ");
        String ubis = u[0];

        String[] e = estado.toString().split(" - ");
        String es = e[0];

        String[] r = urgencia.toString().split(" - ");
        String urg = r[0];

        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("UPDATE man_incidencias set id_incidencia='" + idIn + "',descripcion='" + descripcion + "',desc_tecnica='" + descrTecnico + "',horas='" + horas + "',id_estado='" + es + "',fecha='" + fecha + "',fecha_ini_rep='" + f_ini + "',fecha_fin_rep='" + f_fin + "',nivel_urgencia='" + urg + "',id_ubicacion='" + ubis + "',observaciones='" + observaciones + "' where id_incidencia = '" + idIn + "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos insertados.");

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(add_incidencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();
    }

    // Metodo para rellenar con datos el combo box de estado
    private void rellenar_es() {
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("SELECT id_estado, estado FROM man_estado");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jcbo_estado.addItem(rs.getString("id_estado") + " - " + rs.getString("estado"));
            }

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(modify_incidencia_tec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para rellenar con datos el combo boc de urgencias
    private void rellenar_urg() {
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("SELECT id_urgencia, urgencia FROM man_urgencia");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jcb_urgencia.addItem(rs.getString("id_urgencia") + " - " + rs.getString("urgencia"));
            }

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(modify_incidencia_tec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para rellenar con datos el combo box de ubicaciones
    private void rellenar_ubis() {
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("SELECT id_ubicacion, ubicacion FROM man_ubicacion");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jcbo_ubis.addItem(rs.getString("id_ubicacion") + " - " + rs.getString("ubicacion"));
            }

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(modify_incidencia_tec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para rellenar el JDialog con los datos existentes en la tabla dependiendo de que columna se ha seleccionado
    private void rellenarDatos() {

        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.desc_tecnica, m.horas, e.estado, m.fecha, m.fecha_ini_rep, m.fecha_fin_rep, ur.urgencia, ub.ubicacion, m.observaciones\n"
                    + "from man_incidencias m left join fp_profesor p\n"
                    + "on p.id_profesor = m.id_profesor_crea left join man_estado e \n"
                    + "on e.id_estado = m.id_estado left join man_ubicacion ub\n"
                    + "on ub.id_ubicacion = m.id_ubicacion left join man_urgencia ur\n"
                    + "on ur.id_urgencia = m.nivel_urgencia\n"
                    + "where m.id_incidencia = '" + idIn + "'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jtxta_descripcion.setText(rs.getString(3));
                jtxta_descrTec.setText(rs.getString(4));
                jtxt_horas.setText(rs.getString(5));
                jlbl_estado.setText("Anterior: " + rs.getString(6));
                jtxt_fecha.setText(rs.getString(7));
                jtxt_fechaini.setText(rs.getString(8));
                jtxt_fechafin.setText(rs.getString(9));
                jlbl_urg.setText("Anterior: " + rs.getString(10));
                jlbl_ubis.setText("Anterior: " + rs.getString(11));
                jtxta_observaciones.setText(rs.getString(12));
            }

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(screenProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}