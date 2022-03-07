/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mantenimiento_paula;

import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;

/**
 *
 * @author damA
 */
public class ayuda {
    //Método llamado al cargar la ayuda.

    public void cargarAyuda(JButton b) {
        try {
            // Carga el fichero de ayuda
            File fichero = new File("src\\main\\java\\help\\help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();


            hb.enableHelpOnButton(b, "aplicacion", helpset);
            hb.enableHelpOnButton(b, "aplicacion", helpset);
            hb.enableHelpOnButton(b, "aplicacion", helpset);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
