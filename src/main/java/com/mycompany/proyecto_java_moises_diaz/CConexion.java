/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.proyecto_java_moises_diaz;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author ESPOSO
 */
public class CConexion {
    
    Connection conectar= null;
    
    String usuario = "root";
    String contraseña = "";
    String bd = "bd_escuela";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            //JOptionPane.showMessageDialog(null,"la conexion se ha realizado con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null, "error al conectarse a la base de datos, error:"+ e.toString());
            
        }
        return conectar;
    }
    
}

