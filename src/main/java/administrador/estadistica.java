/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import com.mycompany.mantenimiento_paula.Conectar;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author damA
 */
public class estadistica extends javax.swing.JDialog {
    
    Conectar conectar = new Conectar();

    /**
     * Creates new form estadistica
     */
    public estadistica(javax.swing.JDialog parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        conectar.getConexion();
        
        grafico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbl_grafico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbl_grafico;
    // End of variables declaration//GEN-END:variables

    private void grafico() throws SQLException {
        Connection conexion = conectar.getConexion();
        if (conexion != null) {
            try {
                DefaultCategoryDataset datos = new DefaultCategoryDataset();
                
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("SELECT MonthName(fecha) AS mes, count(*) AS numFilas FROM man_incidencias GROUP BY mes");

                while (rs.next()) {
                    datos.setValue(rs.getInt(2), "", rs.getString(1));
                }            
                
                JFreeChart grafico_barras = ChartFactory.createBarChart("Incidencias por mes", "Meses", "Numero incidencias", datos, PlotOrientation.VERTICAL, false, false, false);

                BarRenderer r = (BarRenderer) grafico_barras.getCategoryPlot().getRenderer();
                r.setSeriesPaint(0, Color.ORANGE);

                BufferedImage image = grafico_barras.createBufferedImage(513, 405);

                jlbl_grafico.setIcon(new ImageIcon(image));

                pack();
                repaint();
                
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(this, "Datos no cargados");
            }
            conexion.close();

        } else {
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }
}