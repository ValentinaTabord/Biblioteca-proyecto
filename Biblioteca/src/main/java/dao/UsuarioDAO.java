/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import views.LibroView;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexion;
    private ConexionBD conexionBD;

    public UsuarioDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }
    
    public void crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, telefono) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Usuario> leerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id_usuario = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                int telefono = resultSet.getInt("telefono");
                Usuario usuario = new Usuario(id_usuario, nombre, email, telefono);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return usuarios;
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET id =?, nombre=?, email=?, telefono=? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, usuario.getId());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getEmail());
            statement.setInt(4, usuario.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarUsuario (int id_usuario) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id_usuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}