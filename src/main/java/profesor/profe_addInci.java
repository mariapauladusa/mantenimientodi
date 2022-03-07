/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import com.mycompany.mantenimiento_paula.Conectar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class profe_addInci extends javax.swing.JDialog {

    Conectar conectar = new Conectar();

    String usuario;
    String id;

    public profe_addInci(javax.swing.JDialog parent, boolean modal, String user) {

        super(parent, modal);
        conectar.getConexion();

        initComponents();

        usuario = user;

        saberId();
        icono();
        rellenarBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        // X de la pantalla
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                profe_screen screen = new profe_screen(profe_addInci.this, true, usuario);
                screen.setVisible(true);
            }
        });

    }

    // Icono del programa
    public void icono() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVA INCIDENCIA");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Descripción:");

        jtxta_descr.setColumns(20);
        jtxta_descr.setRows(5);
        jScrollPane1.setViewportView(jtxta_descr);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Fecha:");

        jtxt_fecha.setToolTipText("AAAA-MM-DD");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Ubicación:");

        jcbo_ubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbo_ubsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Observaciones:");

        jtxta_obsv.setColumns(20);
        jtxta_obsv.setRows(5);
        jScrollPane2.setViewportView(jtxta_obsv);

        jbtn_crear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_crear.setText("Guardar");
        jbtn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jcbo_ubs, javax.swing.GroupLayout.Alignment.LEADING, 0, 202, Short.MAX_VALUE)
                    .addComponent(jtxt_fecha, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(56, 56, 56)
                .addComponent(jbtn_crear)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_crear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbo_ubs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // JComboBox para mostrar las difernetes ubicaciones existentes en man_ubicaciones
    private void jcbo_ubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbo_ubsActionPerformed

        rellenarBox();
    }//GEN-LAST:event_jcbo_ubsActionPerformed

    // Metodo para rellenar el combo box con la informacion de la base de datos
    private void rellenarBox() {
        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("SELECT distinct id_ubicacion, ubicacion FROM man_ubicacion");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                jcbo_ubs.addItem(rs.getString("id_ubicacion") + " - " + rs.getString("ubicacion"));
            }

            conexion.close();

        } catch (SQLException ex) {

            Logger.getLogger(profe_addInci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Boton Crear 
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
    private javax.swing.JComboBox<String> jcbo_ubs;
    private javax.swing.JTextField jtxt_fecha;
    private javax.swing.JTextArea jtxta_descr;
    private javax.swing.JTextArea jtxta_obsv;
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

    // Metodo para insertar una incidencia en la base de datos
    public void insertarIncidencia() {

        String descripcion = jtxta_descr.getText();
        String fecha = jtxt_fecha.getText();
        String ubicacion = (String) jcbo_ubs.getSelectedItem();
        String observaciones = jtxta_obsv.getText();
        String[] s = ubicacion.toString().split(" - ");
        String ubis = s[0];

        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO man_incidencias(id_profesor_crea, descripcion, fecha, id_ubicacion, observaciones) VALUES('" + id + "','" + descripcion + "','" + fecha + "','" + ubis + "','" + observaciones + "')");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos insertados.");

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(profe_addInci.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
}
