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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author damA
 */
public class screenProfesor extends javax.swing.JDialog {

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
    public screenProfesor(javax.swing.JDialog parent, boolean modal, String user) {
        
        conectar.getConexion();

        initComponents();

        usuario = user;

        saberId();
        verIncidencias();
        icono();        
        popmenu();

        
    }
    
     // Metodo del icono
    public void icono(){
        ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
        this.setIconImage(img.getImage());
    }
    
      // JPopUp Menu
    private void popmenu(){
        
       // Menu Item con Modificar Incidencia
       JMenuItem modificar = new JMenuItem ("Modificar incidencia");
       jppm.add(modificar);
       // Menu item con Eliminar Incidencia
       JMenuItem borrar = new JMenuItem ("Eliminar incidencia");
       jppm.add(borrar);
       
       jt_profesor.setComponentPopupMenu(jppm);
       
       modificar.addActionListener(new ActionListener() { 
           @Override
           public void actionPerformed(ActionEvent e) {
               
               String idInci = (String) dtm.getValueAt(jt_profesor.getSelectedRow(), 0);
              
               modify_incidencia add = new modify_incidencia(screenProfesor.this, true, usuario, idInci);
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
    
    // Metodo para eliminar una incidencia
    private void deleteRow() {
        Connection conexion = conectar.getConexion();
        
        var selectedRow = jt_profesor.getValueAt(jt_profesor.getSelectedRow(), 0);
        
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM man_incidencias WHERE id_incidencia = '"+selectedRow+"'");
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Incidencia Eliminada");
            
            conexion.close();
            
        } catch (Exception e) {
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

        jppm = new javax.swing.JPopupMenu();
        jsp_profesor = new javax.swing.JScrollPane();
        jt_profesor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbtnSalirP = new javax.swing.JButton();
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

        jbtnSalirP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtnSalirP.setText("SALIR");
        jbtnSalirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirPActionPerformed(evt);
            }
        });

        jmi_mas.setText("Más...");
        jmi_mas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsp_profesor, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnSalirP, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jsp_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnSalirP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Boton salir
    private void jbtnSalirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirPActionPerformed
        this.setVisible(false);
        new main().setVisible(true);
    }//GEN-LAST:event_jbtnSalirPActionPerformed
    
    // Opcion del Menu Bar para añadir una nueva incidencia
    private void jmi_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_addActionPerformed
       add_incidencia add = new add_incidencia(this, true, usuario);
       add.setVisible(true);
       verIncidencias();
    }//GEN-LAST:event_jmi_addActionPerformed

    // Opcion del Menu Bar para ver los profesores existentes
    private void jmi_verProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_verProfesoresActionPerformed
        enviarCorreo vp = new enviarCorreo(this, true);
        vp.setVisible(true);
    }//GEN-LAST:event_jmi_verProfesoresActionPerformed

    // Metodo para mostrar las incidencias correspondientes al usuario que entra en el JTable
    public void verIncidencias() {
        
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id Incidencia","Nombre", "Descripción", "Fecha", "Ubicación", "Observaciones"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_profesor.setRowSorter(elQueOrdena);

        String[] a = new String[6];

        Connection conexion = conectar.getConexion();
     
        try {

            PreparedStatement ps = conexion.prepareStatement("select m.id_incidencia, p.nombre_completo, m.descripcion, m.fecha, u.ubicacion, m.observaciones\n"
                    + "from man_incidencias m inner join fp_profesor p on p.id_profesor = m.id_profesor_crea\n"
                    + "inner join man_ubicacion u on u.id_ubicacion = m.id_ubicacion\n"
                    + "where m.id_profesor_crea = '"+id+"'");

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
            Logger.getLogger(screenProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnSalirP;
    private javax.swing.JMenuBar jmb_profesor;
    private javax.swing.JMenuItem jmi_add;
    private javax.swing.JMenu jmi_mas;
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
            Logger.getLogger(screenProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
