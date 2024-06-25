/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import views.LibroView;
import model.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    private Connection conexion;
    private ConexionBD conexionBD;

    public PrestamoDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }
    
    public void crearPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?,?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, prestamo.getLibro_id());
            statement.setInt(2, prestamo.getUsuario_id());
            statement.setString(3, prestamo.getFecha_prestamo());
            statement.setString(4, prestamo.getFecha_devolucion());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Prestamo> leerPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                //int prestamosid = resultSet.getInt("prestamosid");
                int libro_id = resultSet.getInt("libro_id");
                int usuario_id = resultSet.getInt("usuario_id");
                String fecha_prestamo = resultSet.getString("fecha_prestamo");
                String fecha_devolucion = resultSet.getString("fecha_devolucion");
                Prestamo prestamo = new Prestamo(libro_id, usuario_id, fecha_prestamo, fecha_devolucion);
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return prestamos;
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE prestamos SET libro_id=?, usuario_id=?, fecha_prestamo=?,fecha_devolucion=? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            //statement.setInt(1, prestamo.getPrestamosid());
            statement.setInt(1, prestamo.getLibro_id());
            statement.setInt(1, prestamo.getUsuario_id());
            statement.setString(1, prestamo.getFecha_prestamo());
            statement.setString(1, prestamo.getFecha_devolucion());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarPrestamo (int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}