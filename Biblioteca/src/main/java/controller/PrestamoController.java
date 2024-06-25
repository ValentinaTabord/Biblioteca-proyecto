/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.PrestamoDAO;
import views.LibroView;
import model.Prestamo;

public class PrestamoController {
    private PrestamoDAO prestamoDAO;
    
    public PrestamoController() {
        prestamoDAO = new PrestamoDAO();
    }

public void crearPrestamo(int libro_id, int usuario_id, String fecha_prestamo, String fecha_devolucion) {
        Prestamo prestamo = new Prestamo(libro_id, usuario_id, fecha_prestamo, fecha_devolucion);
        prestamoDAO.crearPrestamo(prestamo);
    }

 public List <Prestamo> leerPrestamo() {
        List<Prestamo> prestamos = prestamoDAO.leerPrestamos();
        return prestamos;
    }

public void actualizarPrestamo(int libro_id, int usuario_id, String fecha_prestamo, String fecha_devolucion) {
        Prestamo prestamo = new Prestamo(libro_id, usuario_id, fecha_prestamo, fecha_devolucion);
        prestamoDAO.actualizarPrestamo(prestamo);
    }

public void eliminarPrestamos(int id) {
        prestamoDAO.eliminarPrestamo(id);
    }

}


