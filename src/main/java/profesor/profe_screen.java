/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import com.mycompany.mantenimiento_paula.Conectar;
import com.mycompany.mantenimiento_paula.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author damA
 */
public class profe_screen extends javax.swing.JDialog {

    Conectar conectar = new Conectar();

    // Variable para guardar el id del usuario
    String usuario;
    String id;

    // Modelo de la tabla 
    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form jd_mainProfesor
     *
     * @param <error>
     */
    public profe_screen(javax.swing.JDialog parent, boolean modal, String user) {

        conectar.getConexion();

        initComponents();

        usuario = user;

        saberId();
        verIncidencias();
        popmenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        // X de la pantalla
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new main().setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppm = new javax.swing.JPopupMenu();
        jsp_profesor = new javax.swing.JScrollPane();
        jt_profesor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbtn_ayuda = new javax.swing.JButton();
        jmb_profesor = new javax.swing.JMenuBar();
        jmi_mas = new javax.swing.JMenu();
        jmi_verProfesores = new javax.swing.JMenuItem();
        jmi_add = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jt_profesor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jt_profesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsp_profesor.setViewportView(jt_profesor);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INCIDENCIAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbtn_ayuda.setBackground(new java.awt.Color(0, 0, 204));
        jbtn_ayuda.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jbtn_ayuda.setForeground(new java.awt.Color(0, 0, 204));
        jbtn_ayuda.setText("?");
        jbtn_ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ayudaActionPerformed(evt);
            }
        });

        jmb_profesor.setForeground(new java.awt.Color(60, 63, 65));

        jmi_mas.setText("Acciones");
        jmi_mas.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N

        jmi_verProfesores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_verProfesores.setText("Enviar Correo");
        jmi_verProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_verProfesoresActionPerformed(evt);
            }
        });
        jmi_mas.add(jmi_verProfesores);

        jmi_add.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_add.setText("Nueva Incidencia");
        jmi_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_addActionPerformed(evt);
            }
        });
        jmi_mas.add(jmi_add);

        jmb_profesor.add(jmi_mas);

        setJMenuBar(jmb_profesor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsp_profesor, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtn_ayuda)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jsp_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_ayuda)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Opcion del Menu Bar para a??adir una nueva incidencia
    private void jmi_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_addActionPerformed
        this.setVisible(false);
        profe_addInci add = new profe_addInci(this, true, usuario);
        add.setVisible(true);
        verIncidencias();
    }//GEN-LAST:event_jmi_addActionPerformed

    // Opcion del Menu Bar para ver los profesores existentes
    private void jmi_verProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_verProfesoresActionPerformed
        enviarCorreo vp = new enviarCorreo(this, true);
        vp.setVisible(true);
    }//GEN-LAST:event_jmi_verProfesoresActionPerformed

    // Boton para mostrar ayuda
    private void jbtn_ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ayudaActionPerformed
        cargarAyuda(jbtn_ayuda);
    }//GEN-LAST:event_jbtn_ayudaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JButton jbtn_ayuda;
    private javax.swing.JMenuBar jmb_profesor;
    private javax.swing.JMenuItem jmi_add;
    private static javax.swing.JMenu jmi_mas;
    private javax.swing.JMenuItem jmi_verProfesores;
    private javax.swing.JPopupMenu jppm;
    private javax.swing.JScrollPane jsp_profesor;
    private javax.swing.JTable jt_profesor;
    // End of variables declaration//GEN-END:variables

    // Metodo para everiguar el id del usuario correspondiente
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

    // Metodo para mostrar las incidencias correspondientes al usuario que entra en el JTable
    public void verIncidencias() {

        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id Incidencia", "Nombre", "Descripci??n", "Fecha", "Ubicaci??n", "Observaciones"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_profesor.setRowSorter(elQueOrdena);

        String[] a = new String[6];

        Connection conexion = conectar.getConexion();

        try {

            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.fecha, u.ubicacion, m.observaciones\n"
                    + "from man_incidencias m inner join fp_profesor p on p.id_profesor = m.id_profesor_crea\n"
                    + "inner join man_ubicacion u on u.id_ubicacion = m.id_ubicacion\n"
                    + "where m.id_profesor_crea = '" + id + "'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
                a[2] = rs.getString(3);
                a[3] = rs.getString(4);
                a[4] = rs.getString(5);
                a[5] = rs.getString(6);

                dtm.addRow(a);

            }

            jt_profesor.setModel(dtm);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo para cargar la ayuda
    public void cargarAyuda(JButton b) {
        try {
            // Carga el fichero de ayuda
            File fichero = new File("src\\main\\java\\help\\help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(b, "aplicacion", helpset);
            hb.enableHelpKey(this.getRootPane(), "aplicacion", helpset);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // JPopUp Menu
    private void popmenu() {

        // Menu Item con Modificar Incidencia
        JMenuItem modificar = new JMenuItem("Modificar incidencia");
        jppm.add(modificar);
        // Menu item con Eliminar Incidencia
        JMenuItem borrar = new JMenuItem("Eliminar incidencia");
        jppm.add(borrar);

        jt_profesor.setComponentPopupMenu(jppm);

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idInci = (String) dtm.getValueAt(jt_profesor.getSelectedRow(), 0);

                profe_modifyInci add = new profe_modifyInci(profe_screen.this, true, usuario, idInci);
                add.setVisible(true);

                verIncidencias();
            }
        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                deleteRow();
                verIncidencias();
            }
        });

    }

    // Metodo para eliminar una incidencia en conjunto con el popupmenu
    private void deleteRow() {
        Connection conexion = conectar.getConexion();

        var selectedRow = jt_profesor.getValueAt(jt_profesor.getSelectedRow(), 0);

        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM man_incidencias WHERE id_incidencia = '" + selectedRow + "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Incidencia Eliminada");

            conexion.close();

        } catch (Exception e) {
        }
    }
}
