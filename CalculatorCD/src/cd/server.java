import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        try {
            interfazServer calculator = new interfazServer();
            Registry registry = LocateRegistry.createRegistry(1099); // Puerto por defecto para RMI
            registry.rebind("CalculatorService", calculator);
            System.out.println("Calculadora en servicio");
        } catch (Exception e) {
            System.err.println("CalculatorService exception:");
            e.printStackTrace();
        }
    }
}
