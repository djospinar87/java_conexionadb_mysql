/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bd_conexion_prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author djosp
 */
public class Bd_Conexion_Prueba {
    
    private static String url = "jdbc:mysql://localhost/bd_conexion_prueba";
    private static String usuario = "root";
    private static String contraseña = "";

public static Connection conectar(){
    
    Connection conexion = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion exitosa con la base de datos");
            
        } catch (Exception e) {
        
            System.out.println("Error: " +e);
            
        }
        
        return conexion;
        
    }
    
    public static void main(String[] args) {
        
         try {
            Connection conexion = conectar();
            String sql = "INSERT INTO datos (nombre,codigo_postal,telefono) VALUES ('Diego',750034,1109265310)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.executeUpdate();
            conexion.close();
            
        } catch (Exception e) {
            
            System.out.println("Error:  " +e);
            
        }
           
    }
    
}
