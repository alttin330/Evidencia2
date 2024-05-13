package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class EstudianteServiceImpl extends UnicastRemoteObject implements EstudianteService {
    private EstudianteDAO estudianteDAO;

    public EstudianteServiceImpl() throws RemoteException {
        super();
        estudianteDAO = new EstudianteDAOImpl();
    }

    public void agregarEstudiante(Estudiante estudiante) throws RemoteException {
        estudianteDAO.agregarEstudiante(estudiante);
    }

    public void eliminarEstudiante(int id) throws RemoteException {
        estudianteDAO.eliminarEstudiante(id);
    }

    public void actualizarEstudiante(Estudiante estudiante) throws RemoteException {
        estudianteDAO.actualizarEstudiante(estudiante);
    }

    public Estudiante buscarEstudiante(int id) throws RemoteException {
        return estudianteDAO.buscarEstudiante(id);
    }

  
}