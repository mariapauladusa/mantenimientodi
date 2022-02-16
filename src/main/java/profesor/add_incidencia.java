/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import com.mycompany.mantenimiento_paula.Conectar;
import com.mycompany.mantenimiento_paula.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author damA
 */
public class add_incidencia extends javax.swing.JDialog {

    Conectar conectar = new Conectar();

    String usuario;
    String id;

    public add_incidencia(javax.swing.JDialog parent, boolean modal, String user) {
        super(parent, modal);
        conectar.getConexion();

        initComponents();

        usuario = user;

        saberId();

        icono();

    }
    
    // METODO QUE HE CREADO EN LA PANTALLA PRINCIPAL PARA EL ICONO Y LO LLAMO AQUI.
    public void icono() {
        main m = new main();
        m.iconoPrograma();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxta_descr = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jtxt_fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbo_ubs = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxta_obsv = new javax.swing.JTextArea();
        jbtn_crear = new javax.swing.JButton();
        jbtn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVA INCIDENCIA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        jtxta_descr.setColumns(20);
        jtxta_descr.setRows(5);
        jScrollPane1.setViewportView(jtxta_descr);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Fecha:");

        jtxt_fecha.setToolTipText("AAAA-MM-DD");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Ubicación:");

        jcbo_ubs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Click aquí para mostrar", " " }));
        jcbo_ubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbo_ubsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Observaciones:");

        jtxta_obsv.setColumns(20);
        jtxta_obsv.setRows(5);
        jScrollPane2.setViewportView(jtxta_obsv);

        jbtn_crear.setText("Guardar");
        jbtn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_crearActionPerformed(evt);
            }
        });

        jbtn_volver.setText("Volver");
        jbtn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jcbo_ubs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jtxt_fecha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_crear)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbo_ubs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_crear)
                    .addComponent(jbtn_volver))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // BOTON PARA VOLVER A LA PANTALLA DEL PROFESOR
    private void jbtn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_volverActionPerformed
        dispose();
    }//GEN-LAST:event_jbtn_volverActionPerformed

    // JCBO QUE MOSTRARA LAS UBICACIONES QUE EXISTAN PARA QUE PUEDA CREAR UNA
    private void jcbo_ubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbo_ubsActionPerformed

        conectar = new Conectar();
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("SELECT id_ubicacion, ubicacion FROM man_ubicacion");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jcbo_ubs.addItem(rs.getString("id_ubicacion") + " - " + rs.getString("ubicacion"));
            }

        } catch (SQLException ex) {

            Logger.getLogger(add_incidencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbo_ubsActionPerformed

    private void jbtn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_crearActionPerformed
        insertarIncidencia();
    }//GEN-LAST:event_jbtn_crearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtn_crear;
    private javax.swing.JButton jbtn_volver;
    private javax.swing.JComboBox<String> jcbo_ubs;
    private javax.swing.JTextField jtxt_fecha;
    private javax.swing.JTextArea jtxta_descr;
    private javax.swing.JTextArea jtxta_obsv;
    // End of variables declaration//GEN-END:variables

    private void saberId() {

        conectar = new Conectar();
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("select id_profesor from fp_profesor where login = '" + usuario + "';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(screenProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarIncidencia() {

        String descripcion = jtxta_descr.getText();

        String fecha = jtxt_fecha.getText();

        String ubicacion = (String) jcbo_ubs.getSelectedItem();

        String observaciones = jtxta_obsv.getText();

        String[] s = ubicacion.toString().split(" - ");
        String sid = s[0];

        // Conexion a la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO man_incidencias(id_profesor_crea, descripcion, fecha, id_ubicacion, observaciones) VALUES('" + id + "','" + descripcion + "','" + fecha + "','" + sid + "','" + observaciones + "')");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos insertados. Espera un segundo y lo verás en la tabla.");

        } catch (SQLException ex) {

            Logger.getLogger(add_incidencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();

    }

}
