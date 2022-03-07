/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import com.mycompany.mantenimiento_paula.Conectar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import profesor.profe_screen;
import tecnico.tec_screen;

/**
 *
 * @author damA
 */
public class ver_profesores extends javax.swing.JDialog {

    // Conexion a la base de datos
    Conectar conectar = new Conectar();
    // Modelo de la tabla 
    DefaultTableModel dtm = new DefaultTableModel();
    // Variables que utilizo para recoger el usuario
    String usuario;
    String id;

    String idRol;
    String idDepa;

    /**
     * Creates new form ver_profesores
     */
    public ver_profesores(javax.swing.JDialog parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();

        conectar.getConexion();

        verProfesorado();
        popmenu();
        saberId();
        icono();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        // X de la pantalla
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                root_screen screen = new root_screen(ver_profesores.this, true, usuario);
                screen.setVisible(true);
            }
        });

    }

    // Metodo del icono
    public void icono() {
        ImageIcon img = new ImageIcon("src\\main\\java\\resources\\icon.png");
        this.setIconImage(img.getImage());
    }

    // JPopUp Menu
    private void popmenu() {
        // Menu Item con Modificar Incidencia
        JMenuItem modificar = new JMenuItem("Modificar Profesor");
        jppm.add(modificar);
        // Menu item con Eliminar Incidencia
        JMenuItem baja = new JMenuItem("Dar de baja");
        jppm.add(baja);

        jt_profesores.setComponentPopupMenu(jppm);

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardo el id de la incidencia seleccionada
                String idInci = (String) dtm.getValueAt(jt_profesores.getSelectedRow(), 0);
                // Llamo a la pantalla que tengo para modificar incidencia que tengo en tecnico que me sirve aqui tambien
                modify_usuario mu = new modify_usuario(ver_profesores.this, true, usuario, idInci);
                mu.setVisible(true);
                // Para actualizar las incidencias en la tabla
                verProfesorado();
            }
        });

        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darBaja();
                verProfesorado();
            }
        });

    }

    // Metodo para eliminar una incidencia del pop up menu
    private void darBaja() {
        Connection conexion = conectar.getConexion();
        var selectedRow = jt_profesores.getValueAt(jt_profesores.getSelectedRow(), 0);
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE fp_profesor SET activo = 0 where id_profesor = '" + selectedRow + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "El usuario que has seleccionado ha sido dado de baja!", "Usuario Dado de Baja", JOptionPane.OK_OPTION);
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_profesores = new javax.swing.JTable();
        jbtn_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbnt_inactivos = new javax.swing.JButton();
        jbtn_activos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmi_proferoot = new javax.swing.JMenu();
        jmi_exportar = new javax.swing.JMenuItem();
        jmi_importar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jt_profesores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jt_profesores);

        jbtn_add.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_add.setText("Nuevo Usuario");
        jbtn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_addActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROFESORADO");

        jbnt_inactivos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbnt_inactivos.setText("Mostrar Inactivos");
        jbnt_inactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnt_inactivosActionPerformed(evt);
            }
        });

        jbtn_activos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbtn_activos.setText("Mostrar Activos");
        jbtn_activos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_activosActionPerformed(evt);
            }
        });

        jmi_proferoot.setText("Acciones");
        jmi_proferoot.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jmi_exportar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_exportar.setText("Exportar Datos");
        jmi_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_exportarActionPerformed(evt);
            }
        });
        jmi_proferoot.add(jmi_exportar);

        jmi_importar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmi_importar.setText("Importar Datos");
        jmi_importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_importarActionPerformed(evt);
            }
        });
        jmi_proferoot.add(jmi_importar);

        jMenuBar1.add(jmi_proferoot);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_add)
                        .addGap(76, 76, 76)
                        .addComponent(jbnt_inactivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_activos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_add)
                    .addComponent(jbnt_inactivos)
                    .addComponent(jbtn_activos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Boton para mostrar la pantalla que permitira al administrador crear un nuevo usuario
    private void jbtn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_addActionPerformed
        this.setVisible(false);
        add_usuario au = new add_usuario(this, true, usuario);
        au.setVisible(true);
        verProfesorado();
    }//GEN-LAST:event_jbtn_addActionPerformed

    // Boton para mostrar en la tabla los usuarios que estan inactivos
    private void jbnt_inactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnt_inactivosActionPerformed
        verInactivos();
    }//GEN-LAST:event_jbnt_inactivosActionPerformed

    // Metodo para ver los usuarios que estan inactivos
    public void verInactivos() {
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Id del profesor", "Nombre de Usuario", "Contraseña", "Nombre Completo", "Email Técnica", "Activo", "Rol", "Departamento"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_profesores.setRowSorter(elQueOrdena);

        String[] a = new String[8];

        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("select p.id_profesor, p.login, p.password, p.nombre_completo, p.email, p.activo, r.rol, d.departamento\n"
                    + "from fp_profesor p inner join fp_rol r\n"
                    + "on p.id_rol = r.id_rol inner join fp_departamento d\n"
                    + "on p.id_departamento = d.id_departamento where p.activo = 0 ");

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

                dtm.addRow(a);
            }

            jt_profesores.setModel(dtm);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Boton que muestra en la tabla los usuarios activos, por defecto mostrara los usuarios activos
    private void jbtn_activosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_activosActionPerformed
        verProfesorado();
    }//GEN-LAST:event_jbtn_activosActionPerformed

    // Metodo para mostrar informacion acerca de los profesores en la tabla
    private void verProfesorado() {
        dtm.setNumRows(0);
        dtm.setColumnIdentifiers(new String[]{"Nombre de Usuario", "Contraseña", "Nombre Completo", "Email", "Activo", "Rol", "Departamento"});
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        jt_profesores.setRowSorter(elQueOrdena);

        String[] a = new String[8];

        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("select p.login, p.password, p.nombre_completo, p.email, p.activo, r.rol, d.departamento\n"
                    + "from fp_profesor p inner join fp_rol r\n"
                    + "on p.id_rol = r.id_rol inner join fp_departamento d\n"
                    + "on p.id_departamento = d.id_departamento where p.activo = 1 ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a[0] = rs.getString(1);
                a[1] = rs.getString(2);
                a[2] = rs.getString(3);
                a[3] = rs.getString(4);
                a[4] = rs.getString(5);
                a[5] = rs.getString(6);
                a[6] = rs.getString(7);

                dtm.addRow(a);
            }

            jt_profesores.setModel(dtm);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(tec_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Menu Item de MenuBar con la opcion de exportar los datos
    private void jmi_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_exportarActionPerformed

        //Workbook wb = new XSSFWorkbook();

        JFileChooser file = new JFileChooser();
        int option = file.showSaveDialog(this);

        FileFilter filter = new FileNameExtensionFilter("Excel file", "xls");
        file.addChoosableFileFilter(filter);

        String ruta = file.getSelectedFile().getAbsolutePath();

        ruta = ruta + ".xls";
        File datos = new File(ruta);

        if (option == JFileChooser.APPROVE_OPTION) {

            if (!datos.exists()) {
                if (!ruta.contains(".xls")) {

                    Exportar(datos, jt_profesores);
                    JOptionPane.showMessageDialog(this, "Archivo exportado con exito!", ":)", JOptionPane.OK_OPTION);

                } else {
                    Exportar(datos, jt_profesores);
                }
            } else {
                 JOptionPane.showMessageDialog(this, "El archivo ya existe!!", ":(", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_jmi_exportarActionPerformed

    // Metodo para exportar datos de la tabla en excel
    public void Exportar(File archivo, JTable tabla) {

        int NumeroFila = tabla.getRowCount(), NumeroColumna = tabla.getColumnCount();

        if (archivo.getName().endsWith("xls")) {
            book = new HSSFWorkbook();
        } else {
            book = new XSSFWorkbook();
        }

        Sheet hoja = book.createSheet("Hoja1");

        try {

            for (int i = -1; i < NumeroFila; i++) {

                Row fila = hoja.createRow(i + 1);

                for (int j = 0; j < NumeroColumna; j++) {

                    Cell celda = fila.createCell(j);

                    if (i == -1) {

                        celda.setCellValue(String.valueOf(tabla.getColumnName(j)));

                    } else {

                        celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                    }

                    book.write(new FileOutputStream(archivo));
                }
            }
            JOptionPane.showMessageDialog(this, "Archivo exportado con exito!", ":)", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Vaya algo ha ido mal!!", ":(", JOptionPane.OK_OPTION);
        }

    }

    Workbook book;

    // Menu Item de MenuBar con la opcion de importar los datos
    private void jmi_importarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_importarActionPerformed
        importExcelToJtableJava();
    }//GEN-LAST:event_jmi_importarActionPerformed
    // Metodo para importar archivos a la tabla ya su vez a la base de datos
    public void importExcelToJtableJava() {

        int a = JOptionPane.showConfirmDialog(this, "Se importara un archivo con nuevos datos a la tabla y también se subirán a la base de datos", "Información antes de continuar", JOptionPane.OK_CANCEL_OPTION);

        if (a == JOptionPane.OK_OPTION) {
            
            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            XSSFWorkbook excelImportToJTable = null;

            JFileChooser excelFileChooser = new JFileChooser();
            excelFileChooser.setDialogTitle("Select Excel File");

            FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
            excelFileChooser.setFileFilter(fnef);

            int excelChooser = excelFileChooser.showOpenDialog(null);

            if (excelChooser == JFileChooser.APPROVE_OPTION) {

                try {
                    excelFile = excelFileChooser.getSelectedFile();
                    excelFIS = new FileInputStream(excelFile);
                    excelBIS = new BufferedInputStream(excelFIS);
                    excelImportToJTable = new XSSFWorkbook(excelBIS);
                    
                    XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                    for (int row = 1; row < excelSheet.getLastRowNum()+1 ; row++) {
                        
                        XSSFRow excelRow = excelSheet.getRow(row);

                        XSSFCell login = excelRow.getCell(0);
                        XSSFCell passsword = excelRow.getCell(1);
                        XSSFCell nombre_completo = excelRow.getCell(2);
                        XSSFCell email = excelRow.getCell(3);
                        XSSFCell activo = excelRow.getCell(4);
                        XSSFCell id_rol = excelRow.getCell(5);
                        XSSFCell id_departamento = excelRow.getCell(6);

                        dtm.addRow(new Object[]{login, passsword, nombre_completo, email, activo, id_rol, id_departamento});
                        
                        if (dtm.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(this, "La tabla esta vacia!!", "Tabla Vacía", JOptionPane.OK_OPTION);
                            
                        } else {
                            
                            try {
                                
                                Connection conexion = conectar.getConexion();

                                String query = "insert into fp_profesor(login, password, nombre_completo, email, activo, id_rol, id_departamento)values(?,?,?,?,?,?,?)";
                                PreparedStatement ps = conexion.prepareStatement(query);

                                ps.setString(1, login.toString());
                                ps.setString(2, passsword.toString());
                                ps.setString(3, nombre_completo.toString());
                                ps.setString(4, email.toString());
                                ps.setString(5, activo.toString());
                                ps.setString(6, saberIdRol(id_rol.toString()));
                                ps.setString(7, saberIdDepa(id_departamento.toString()));

                                ps.execute();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    verProfesorado();

                   JOptionPane.showConfirmDialog(this, "Información subida a la base de datos!!", ":D", JOptionPane.OK_OPTION);

                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }

        } else {
             JOptionPane.showConfirmDialog(this, "Pues que mal, no podrás importar un archivo sin subirlo a base de datos, tendras que aceptar!!", ":(", JOptionPane.OK_OPTION);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnt_inactivos;
    private javax.swing.JButton jbtn_activos;
    private javax.swing.JButton jbtn_add;
    private javax.swing.JMenuItem jmi_exportar;
    private javax.swing.JMenuItem jmi_importar;
    private javax.swing.JMenu jmi_proferoot;
    private javax.swing.JPopupMenu jppm;
    private javax.swing.JTable jt_profesores;
    // End of variables declaration//GEN-END:variables

    // Metodo para everiguar el id del usuario correspondiente
    private void saberId() {
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

    // Metodo para everiguar el id del rol para usarlo en importar
    private String saberIdRol(String Rol) {
        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("select id_rol from fp_rol where rol= '" + Rol + "';");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                idRol = rs.getString(1);
            }
            return idRol;
        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Metodo para everiguar el id del departamento para usarlo en importar
    private String saberIdDepa(String epa) {
        Connection conexion = conectar.getConexion();

        try {
            PreparedStatement ps = conexion.prepareStatement("select id_departamento from fp_departamento where departamento= '" + epa + "';");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                idDepa = rs.getString(1);
            }
            return idDepa;
        } catch (SQLException ex) {
            Logger.getLogger(profe_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
