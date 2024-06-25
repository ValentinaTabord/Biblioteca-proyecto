/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author linki
 */
public class ConexionBD {
    
    public static Connection getConexion() {
        // Datos de conexión
        // Cambia por tu nombre de base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        // Cambia por tu usuario de la base de datos
        String usuario = "root";
        // Cambia por tu contraseña de la base de datos si tiene
        String clave = "root";

        // Intentar establecer la conexión
        Connection conexion = null;
        try {
            /*Eliminar -> Connection*/
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa a la base de datos.");
            //conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        // Devuelve el objeto conexion
        return conexion;
    }

    public static void closeConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Se cerro la conexion de forma exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion base de datos: " + e.getMessage());
            }
        }
    }
    
}
