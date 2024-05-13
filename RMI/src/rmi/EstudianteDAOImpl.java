package rmi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/estudiante";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    private Connection conexion;

    public EstudianteDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO estudiantes (nombre, edad, grado) VALUES (?, ?, ?)");
            stmt.setString(1, estudiante.getNombre());
            stmt.setInt(2, estudiante.getEdad());
            stmt.setString(3, estudiante.getGrado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEstudiante(int id) {
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM estudiantes WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE estudiantes SET nombre = ?, edad = ?, grado = ? WHERE id = ?");
            stmt.setString(1, estudiante.getNombre());
            stmt.setInt(2, estudiante.getEdad());
            stmt.setString(3, estudiante.getGrado());
            stmt.setInt(4, estudiante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Estudiante buscarEstudiante(int id) {
        Estudiante estudiante = null;
        try {
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM estudiantes WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                estudiante = new Estudiante(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("grado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

}