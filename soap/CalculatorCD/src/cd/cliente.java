import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            interfaz calculator = (interfaz) registry.lookup("CalculatorService");

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("Seleccione la operación:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Salir");

                int opcion = scanner.nextInt();
                double resultado = 0;
                
                System.out.println("Ingrese el primer número:");
                double x = scanner.nextDouble();

                System.out.println("Ingrese el segundo número:");
                double y = scanner.nextDouble();

                

                switch (opcion) {
                    case 1:
                        resultado = calculator.add(x, y);
                        break;
                    case 2:
                        resultado = calculator.subtract(x, y);
                        break;
                    case 3:
                        resultado = calculator.multiply(x, y);
                        break;
                    case 4:
                        resultado = calculator.divide(x, y);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }

                if (opcion >= 1 && opcion <= 4) {
                    System.out.println("Resultado: " + resultado);
                }
            }

            System.out.println("Cliente desconectado.");

        } catch (Exception e) {
            System.err.println("Excepción en el cliente:");
            e.printStackTrace();
        }
    }
}
