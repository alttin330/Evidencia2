package rmi;

import java.util.List;

public interface EstudianteDAO {
    void agregarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(int id);
    void actualizarEstudiante(Estudiante estudiante);
    Estudiante buscarEstudiante(int id);
}