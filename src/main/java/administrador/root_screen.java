/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package administrador;

import profesor.profe_screen;
import com.mycompany.mantenimiento_paula.Conectar;
import com.mycompany.mantenimiento_paula.ayuda;
import com.mycompany.mantenimiento_paula.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import profesor.enviarCorreo;
import tecnico.tec_addIncidencia;
import tecnico.tec_modifyIncidencia;
import tecnico.tec_screen;
import tecnico.tipos;

/**
 *
 * @author nicol
 */
public class root_screen extends javax.swing.JDialog {

    // Conexion a la base de datos
    Conectar conectar = new Conectar();
    // Variables que utilizo para recoger el usuario
    String usuario;
    String id;
    // Modelo de la tabla 
    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form screenRoot
     */
    public root_screen(javax.swing.JDialog parent, boolean modal, String user) {
        conectar.getConexion();
        initComponents();
        usuario = user;
        saberId();
        verIncidencias();
        popmenu();
        icono();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_root = new javax.swing.JTable();
        jbtn_urgencia = new javax.swing.JButton();
        jtxt_buscar = new javax.swing.JTextField();
        jbtn_estado = new javax.swing.JButton();
        jbtn_consultar = new javax.swing.JButton();
        jbtn_actualizar = new javax.swing.JButton();
        jbtn_ayudaroot = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuroot = new javax.swing.JMenu();
        jmi_correo = new javax.swing.JMenuItem();
        jmi_incidencia = new javax.swing.JMenuItem();
        jmi_profesores = new javax.swing.JMenuItem();
        jmi_estadistica = new javax.swing.JMenuItem();
        jmi_helpRoot = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("screenRoot"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(832, 555));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INCIDENCIAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jt_root.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jt_root);

        jbtn_urgencia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_urgencia.setText("Buscar por urgencia");
        jbtn_urgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_urgenciaActionPerformed(evt);
            }
        });

        jbtn_estado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_estado.setText("Buscar por estado");
        jbtn_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_estadoActionPerformed(evt);
            }
        });

        jbtn_consultar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_consultar.setText("Consultar tipos");
        jbtn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_consultarActionPerformed(evt);
            }
        });

        jbtn_actualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_actualizar.setText("Actualizar Información");
        jbtn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_actualizarActionPerformed(evt);
            }
        });

        jbtn_ayudaroot.setText("Ayuda!");

        jmenuroot.setText("Acciones");
        jmenuroot.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jmi_correo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_correo.setText("Enviar Correo");
        jmi_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_correoActionPerformed(evt);
            }
        });
        jmenuroot.add(jmi_correo);

        jmi_incidencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_incidencia.setText("Nueva Incidencia");
        jmi_incidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_incidenciaActionPerformed(evt);
            }
        });
        jmenuroot.add(jmi_incidencia);

        jmi_profesores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_profesores.setText("Profesorado");
        jmi_profesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_profesoresActionPerformed(evt);
            }
        });
        jmenuroot.add(jmi_profesores);

        jmi_estadistica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_estadistica.setText("Estadistica");
        jmi_estadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_estadisticaActionPerformed(evt);
            }
        });
        jmenuroot.add(jmi_estadistica);

        jmi_helpRoot.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_helpRoot.setText("Ayuda");
        jmi_helpRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_helpRootActionPerformed(evt);
            }
        });
        jmenuroot.add(jmi_helpRoot);

        jMenuBar1.add(jmenuroot);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1401, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtn_consultar)
                        .addGap(62, 62, 62)
                        .addComponent(jbtn_estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_urgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_ayudaroot)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_urgencia)
                    .addComponent(jbtn_estado)
                    .addComponent(jtxt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_consultar)
                    .addComponent(jbtn_actualizar)
                    .addComponent(jbtn_ayudaroot))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // JPopUp Menu
    private void popmenu() {
        // Menu Item con Modificar Incidencia
        JMenuItem modificar = new JMenuItem("Modificar incidencia");
        jppm.add(modificar);
        // Menu item con Eliminar Incidencia
        JMenuItem borrar = new JMenuItem("Eliminar incidencia");
        jppm.add(borrar);

        jt_root.setComponentPopupMenu(jppm);

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardo el id de la incidencia seleccionada
                String idInci = (String) dtm.getValueAt(jt_root.getSelectedRow(), 0);
                // Llamo a la pantalla que tengo para modificar incidencia que tengo en tecnico que me sirve aqui tambien
                tec_modifyIncidencia m = new tec_modifyIncidencia(root_screen.this, true, usuario, idInci);
                m.setVisible(true);
                // Para actualizar las incidencias en la tabla
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

    // Metodo para eliminar una incidencia del pop up menu
    private void deleteRow() {
        Connection conexion = conectar.getConexion();
        var selectedRow = jt_root.getValueAt(jt_root.getSelectedRow(), 0);
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM man_incidencias WHERE id_incidencia = '" + selectedRow + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Incidencia Eliminada");
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Metodo del icono
    public void icono() {
        ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
        this.setIconImage(img.getImage());
    }

    // MOSTRAR INCIDENCIAS EN EL JTABLE
    public void verIncidencias() {
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id Incidencia", "Nombre", "Descripción", "Decripción Técnica", "Horas", "Estado", "Fecha", "Inicio", "Final", "Urgencia", "Ubicación", "Observaciones"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_root.setRowSorter(elQueOrdena);
        String[] a = new String[12];
        Connection conexion = conectar.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.desc_tecnica, m.horas, e.estado, m.fecha, m.fecha_ini_rep, m.fecha_fin_rep, ur.urgencia, ub.ubicacion, m.observaciones\n"
                    + "from man_incidencias m left join fp_profesor p\n"
                    + "on p.id_profesor = m.id_profesor_crea left join man_estado e \n"
                    + "on e.id_estado = m.id_estado left join man_ubicacion ub\n"
                    + "on ub.id_ubicacion = m.id_ubicacion left join man_urgencia ur\n"
                    + "on ur.id_urgencia = m.nivel_urgencia\n");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
                a[2] = rs.getString(3);
                a[3] = rs.getString(4);
                a[4] = rs.getString(5);
                a[5] = rs.getString(6);
                a[6] = rs.getString(7);
                a[7] = rs.getString(8);
                a[8] = rs.getString(9);
                a[9] = rs.getString(10);
                a[10] = rs.getString(11);
                a[11] = rs.getString(12);
                dtm.addRow(a);
            }
            jt_root.setModel(dtm);
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Boton para buscar por urgencia
    private void jbtn_urgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_urgenciaActionPerformed
        buscadorUrgencia();
    }//GEN-LAST:event_jbtn_urgenciaActionPerformed

    // Boton para buscar por estado
    private void jbtn_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_estadoActionPerformed
        buscadorEstado();
    }//GEN-LAST:event_jbtn_estadoActionPerformed

    // Boton para consultar tipos
    private void jbtn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_consultarActionPerformed
        // Llamo a la pantalla que utilizo para consultar los tipos de estado e urgencias 
        // que existen en la bbdd
        tipos t = new tipos(this, true);
        t.setVisible(true);
    }//GEN-LAST:event_jbtn_consultarActionPerformed

    // Menu Item de MenuBar para enviar un correo
    private void jmi_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_correoActionPerformed
        // Llamo a la pantalla que tengo para enviar correos
        enviarCorreo e = new enviarCorreo(this, true);
        e.setVisible(true);
    }//GEN-LAST:event_jmi_correoActionPerformed

    // Menu Item de MenuBar para crear una nueva incidencia
    private void jmi_incidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_incidenciaActionPerformed
        // Llamo a la pantalla para crear una nueva incidencia que tengo en tecnico por que me sirve aqui tambien
        tec_addIncidencia i = new tec_addIncidencia(this, true, usuario);
        i.setVisible(true);
    }//GEN-LAST:event_jmi_incidenciaActionPerformed

    // Introduzco este boton por que despues de buscar se queda la tabla vacia
    private void jbtn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_actualizarActionPerformed
        verIncidencias();
    }//GEN-LAST:event_jbtn_actualizarActionPerformed

    // Menu Item de MenuBar para mostrar la pantalla con la información de cada profesor
    private void jmi_profesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_profesoresActionPerformed
        this.setVisible(false);
        ver_profesores vp = new ver_profesores(this, true, usuario);
        vp.setVisible(true);
    }//GEN-LAST:event_jmi_profesoresActionPerformed

    // Menu Item del MenuBar para mostrar la pantalla con la estadistica
    private void jmi_estadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_estadisticaActionPerformed
        estadistica screen = null;
        try {
            screen = new estadistica(this, true);
        } catch (SQLException ex) {
            Logger.getLogger(root_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        screen.setVisible(true);
    }//GEN-LAST:event_jmi_estadisticaActionPerformed

    // Java Help
    private void jmi_helpRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_helpRootActionPerformed
        ayuda a = new ayuda();
        a.cargarAyuda(jbtn_ayudaroot);
    }//GEN-LAST:event_jmi_helpRootActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_actualizar;
    private javax.swing.JButton jbtn_ayudaroot;
    private javax.swing.JButton jbtn_consultar;
    private javax.swing.JButton jbtn_estado;
    private javax.swing.JButton jbtn_urgencia;
    private javax.swing.JMenu jmenuroot;
    private javax.swing.JMenuItem jmi_correo;
    private javax.swing.JMenuItem jmi_estadistica;
    public static javax.swing.JMenuItem jmi_helpRoot;
    private javax.swing.JMenuItem jmi_incidencia;
    private javax.swing.JMenuItem jmi_profesores;
    private javax.swing.JPopupMenu jppm;
    private javax.swing.JTable jt_root;
    private javax.swing.JTextField jtxt_buscar;
    // End of variables declaration//GEN-END:variables

    // Metodo para everiguar el id del usuario correspondiente
    private void saberId() {
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement("select id_profesor from fp_profesor where login= '" + usuario + "';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para buscar segun urgencia
    private void buscadorUrgencia() {
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id Incidencia", "Nombre", "Descripción", "Decripción Técnica", "Horas", "Estado", "Fecha", "Inicio", "Final", "Urgencia", "Ubicación", "Observaciones"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_root.setRowSorter(elQueOrdena);
        String buscar = jtxt_buscar.getText();
        String[] a = new String[12];
        Connection conexion = conectar.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.desc_tecnica, m.horas, e.estado, m.fecha, m.fecha_ini_rep, m.fecha_fin_rep, ur.urgencia, ub.ubicacion, m.observaciones\n"
                    + "from man_incidencias m left join fp_profesor p\n"
                    + "on p.id_profesor = m.id_profesor_crea left join man_estado e \n"
                    + "on e.id_estado = m.id_estado left join man_ubicacion ub\n"
                    + "on ub.id_ubicacion = m.id_ubicacion left join man_urgencia ur\n"
                    + "on ur.id_urgencia = m.nivel_urgencia\n"
                    + "where ur.urgencia = '" + buscar + "' order by m.nivel_urgencia");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
                a[2] = rs.getString(3);
                a[3] = rs.getString(4);
                a[4] = rs.getString(5);
                a[5] = rs.getString(6);
                a[6] = rs.getString(7);
                a[7] = rs.getString(8);
                a[8] = rs.getString(9);
                a[9] = rs.getString(10);
                a[10] = rs.getString(11);
                a[11] = rs.getString(12);
                dtm.addRow(a);
            }
            jt_root.setModel(dtm);
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo para buscar segun estado
    private void buscadorEstado() {
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id Incidencia", "Nombre", "Descripción", "Decripción Técnica", "Horas", "Estado", "Fecha", "Inicio", "Final", "Urgencia", "Ubicación", "Observaciones"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_root.setRowSorter(elQueOrdena);
        String buscar = jtxt_buscar.getText();
        String[] a = new String[12];
        Connection conexion = conectar.getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.desc_tecnica, m.horas, e.estado, m.fecha, m.fecha_ini_rep, m.fecha_fin_rep, ur.urgencia, ub.ubicacion, m.observaciones\n"
                    + "from man_incidencias m left join fp_profesor p\n"
                    + "on p.id_profesor = m.id_profesor_crea left join man_estado e \n"
                    + "on e.id_estado = m.id_estado left join man_ubicacion ub\n"
                    + "on ub.id_ubicacion = m.id_ubicacion left join man_urgencia ur\n"
                    + "on ur.id_urgencia = m.nivel_urgencia\n"
                    + "where e.estado = '" + buscar + "' order by m.id_estado");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
                a[2] = rs.getString(3);
                a[3] = rs.getString(4);
                a[4] = rs.getString(5);
                a[5] = rs.getString(6);
                a[6] = rs.getString(7);
                a[7] = rs.getString(8);
                a[8] = rs.getString(9);
                a[9] = rs.getString(10);
                a[10] = rs.getString(11);
                a[11] = rs.getString(12);
                dtm.addRow(a);
            }
            jt_root.setModel(dtm);
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
