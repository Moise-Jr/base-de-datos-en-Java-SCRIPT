/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_moises_diaz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*import java.sql.*;*/

/**
 *
 * @author ESPOSO
 */
public class CAlumnos {
   

   private int Codigo;
    private String nombresAlumnos;
    private String apellidosAlumnos;
    private String edadAlumnos;
    private String telefonoAlumnos;
    private String direccionAlumnos;

    // Getters y setters
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombresAlumnos() {
        return nombresAlumnos;
    }

    public void setNombresAlumnos(String nombresAlumnos) {
        this.nombresAlumnos = nombresAlumnos;
    }

    public String getApellidosAlumnos() {
        return apellidosAlumnos;
    }

    public void setApellidosAlumnos(String apellidosAlumnos) {
        this.apellidosAlumnos = apellidosAlumnos;
    }

    public String getEdadAlumnos() {
        return edadAlumnos;
    }

    public void setEdadAlumnos(String edadAlumnos) {
        this.edadAlumnos = edadAlumnos;
    }

    public String getTelefonoAlumnos() {
        return telefonoAlumnos;
    }

    public void setTelefonoAlumnos(String telefonoAlumnos) {
        this.telefonoAlumnos = telefonoAlumnos;
    }

    public String getDireccionAlumnos() {
        return direccionAlumnos;
    }

    public void setDireccionAlumnos(String direccionAlumnos) {
        this.direccionAlumnos = direccionAlumnos;
    }

    // Método para insertar alumno
    public void InsertarAlumnos(JTextField paramNombres, JTextField paramApellidos, JTextField paramEdad, JTextField paramTelefono, JTextField paramDireccion) {
        setNombresAlumnos(paramNombres.getText());
        setApellidosAlumnos(paramApellidos.getText());
        setEdadAlumnos(paramEdad.getText());
        setTelefonoAlumnos(paramTelefono.getText());
        setDireccionAlumnos(paramDireccion.getText());

        CConexion objetoConexion = new CConexion();
        String consulta = "INSERT INTO `alumnos`(`DNI`, `Nombres`, `Apellidos`, `Edad`, `Telefono`, `Direccion`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')";
        try {
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, getNombresAlumnos());
            ps.setString(2, getApellidosAlumnos());
            ps.setString(3, getEdadAlumnos());
            ps.setString(4, getTelefonoAlumnos());
            ps.setString(5, getDireccionAlumnos());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el alumno");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el alumno, error: " + e.toString());
        }
    }

    // Método para mostrar alumnos
    public void MostrarAlumnos(JTable paramTableTotalAlumnos) {
        CConexion objetoConexion = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT * FROM `alumnos` WHERE 1";

        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");

        paramTableTotalAlumnos.setModel(modelo);

        try {
            Statement st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String[] datos = new String[6];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }
    }

    // Método para seleccionar un alumno
    public void SeleccionarAlumnos(JTable paramTableAlumnos, JTextField paramDNI, JTextField paramNombres, JTextField paramApellidos, JTextField paramEdad, JTextField paramTelefono, JTextField paramDireccion) {
        try {
            int fila = paramTableAlumnos.getSelectedRow();

            if (fila >= 0) {
                paramDNI.setText(paramTableAlumnos.getValueAt(fila, 0).toString());
                paramNombres.setText(paramTableAlumnos.getValueAt(fila, 1).toString());
                paramApellidos.setText(paramTableAlumnos.getValueAt(fila, 2).toString());
                paramEdad.setText(paramTableAlumnos.getValueAt(fila, 3).toString());
                paramTelefono.setText(paramTableAlumnos.getValueAt(fila, 4).toString());
                paramDireccion.setText(paramTableAlumnos.getValueAt(fila, 5).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    // Método para modificar un alumno
    public void ModificarAlumnos(JTextField paramCodigo, JTextField paramNombres, JTextField paramApellidos, JTextField paramEdad, JTextField paramTelefono, JTextField paramDireccion) {
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombresAlumnos(paramNombres.getText());
        setApellidosAlumnos(paramApellidos.getText());
        setEdadAlumnos(paramEdad.getText());
        setTelefonoAlumnos(paramTelefono.getText());
        setDireccionAlumnos(paramDireccion.getText());

        CConexion objetoConexion = new CConexion();
        String consulta = "UPDATE `alumnos` SET `DNI`='[value-1]',`Nombres`='[value-2]',`Apellidos`='[value-3]',`Edad`='[value-4]',`Telefono`='[value-5]',`Direccion`='[value-6]' WHERE 1";

        try {
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, getNombresAlumnos());
            ps.setString(2, getApellidosAlumnos());
            ps.setString(3, getEdadAlumnos());
            ps.setString(4, getTelefonoAlumnos());
            ps.setString(5, getDireccionAlumnos());
            ps.setInt(6, getCodigo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
        }
    }

    // Método para eliminar un alumno
    public void EliminarAlumnos(JTextField paramCodigo) {
        setCodigo(Integer.parseInt(paramCodigo.getText()));

        CConexion objetoConexion = new CConexion();
        String consulta = "DELETE FROM `alumnos` WHERE 0";

        try {
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, getCodigo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el alumno");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }
    }

    void InsertarAlumno(JTextField txtcodigo, JTextField txtNombres, JTextField txtApellidos, JTextField txtEdad, JTextField txtTelefono, JTextField txtDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void SeleccionarAlumno(JTable tbTotalAlumnos, JTextField txtcodigo, JTextField txtNombres, JTextField txtApellidos, JTextField txtEdad, JTextField txtTelefono, JTextField txtDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    void EliminarAlumno(JTextField txtcodigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void ModificarAlumnos(JTextField txtNombres, JTextField txtApellidos, JTextField txtEdad, JTextField txtTelefono, JTextField txtDireccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

