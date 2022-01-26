package com.mycompany.examenpaula;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dama
 */
public class Conectar {
    public static final String URL = "jdbc:mysql://servidorifc.iesch.org:3306/mantenimiento_dusa_p";
    public static final String USER = "2_dusa_p";
    public static final String PASS = "fw7e4";
    
    public Connection getConexion() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }catch (SQLException ex) {
                Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
