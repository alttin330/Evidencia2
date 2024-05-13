package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            EstudianteService servicio = new EstudianteServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("EstudianteService", servicio);
            System.out.println("Servidor iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}