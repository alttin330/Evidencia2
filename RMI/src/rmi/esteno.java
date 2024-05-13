package rmi;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class esteno {
    private static EstudianteService servicio;

    public static void main(String[] args) {
        try {
            servicio = (EstudianteService) Naming.lookup("rmi://localhost:1099/EstudianteService");
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después de la opción
                procesarOpcion(opcion, scanner);
            } while (opcion != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Actualizar estudiante");
        System.out.println("4. Buscar estudiante");
        System.out.println("5. Salir");
    }

    private static void procesarOpcion(int opcion, Scanner scanner) {
        try {
            switch (opcion) {
                case 1:
                    agregarEstudiante(scanner);
                    break;
                case 2:
                    eliminarEstudiante(scanner);
                    break;
                case 3:
                    actualizarEstudiante(scanner);
                    break;
                case 4:
                    buscarEstudiante(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void agregarEstudiante(Scanner scanner) throws Exception {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de la edad
        System.out.print("Ingrese el grado: ");
        String grado = scanner.nextLine();
        Estudiante estudiante = new Estudiante(-1, nombre, edad, grado);
        servicio.agregarEstudiante(estudiante);
        System.out.println("Estudiante agregado con éxito");
    }

    private static void eliminarEstudiante(Scanner scanner) throws Exception {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        servicio.eliminarEstudiante(id);
        System.out.println("Estudiante eliminado con éxito");
    }

    private static void actualizarEstudiante(Scanner scanner) throws Exception {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del ID
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de la edad
        System.out.print("Ingrese el grado: ");
        String grado = scanner.nextLine();
        Estudiante estudiante = new Estudiante(id, nombre, edad, grado);
        servicio.actualizarEstudiante(estudiante);
        System.out.println("Estudiante actualizado con éxito");
    }

    private static void buscarEstudiante(Scanner scanner) throws Exception {
        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        Estudiante estudiante = servicio.buscarEstudiante(id);
        if (estudiante != null) {
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Grado: " + estudiante.getGrado());
        } else {
            System.out.println("No se encontró el estudiante");
        }
    }
}