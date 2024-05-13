package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EstudianteService extends Remote {
    void agregarEstudiante(Estudiante estudiante) throws RemoteException;
    void eliminarEstudiante(int id) throws RemoteException;
    void actualizarEstudiante(Estudiante estudiante) throws RemoteException;
    Estudiante buscarEstudiante(int id) throws RemoteException;
}