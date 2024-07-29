import java.util.InputMismatchException;
import java.util.Scanner;

public class EJERCICIO1POOMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EJERCICIO1POOSistemaDeVentas sistema = new EJERCICIO1POOSistemaDeVentas();
            
            sistema.configurarIniciales("Platea", 100, 200.0, "Balcon1", 50, 150.0, "Balcon2", 30, 100.0);
            
            boolean continuar = true;
            
            while (continuar) {
                mostrarMenu();
                int opcion = leerOpcion(scanner);
                
                if (opcion == -1) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                    continue;
                }
                
                continuar = ejecutarOpcion(opcion, scanner, sistema);
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Ventas ---");
        System.out.println("1. Comprar boletos");
        System.out.println("2. Consultar disponibilidad total");
        System.out.println("3. Consultar disponibilidad individual");
        System.out.println("4. Generar reporte de caja");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción (1-5): ");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); // Limpiar el buffer
            return -1; // Indicar entrada no válida
        } finally {
            scanner.nextLine(); // Consumir el salto de línea
        }
    }

    private static boolean ejecutarOpcion(int opcion, Scanner scanner, EJERCICIO1POOSistemaDeVentas sistema) {
        boolean continuar = true;

        switch (opcion) {
            case 1:
                // Comprar boletos
                System.out.println("\n--- Comprar Boletos ---");
                System.out.print("Ingrese su nombre (solo letras y espacios): ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su email (ejemplo: nombre@dominio.com): ");
                String email = scanner.nextLine();
                System.out.print("Cantidad de boletos que desea comprar (número entero positivo): ");
                int cantidadBoletos = leerEntero(scanner, true);
                System.out.print("Presupuesto disponible (número decimal positivo): ");
                double presupuesto = leerDouble(scanner, true);
                sistema.agregarComprador(nombre, email, cantidadBoletos, presupuesto);
                System.out.print("Nombre de la localidad (platea, balcon1, balcon2): ");
                String localidad = scanner.nextLine().toLowerCase();
                sistema.comprarBoletos(localidad);
                break;
                
            case 2:
                // Consultar disponibilidad total
                System.out.println("\n--- Disponibilidad Total ---");
                sistema.consultarDisponibilidadTotal();
                break;
                
            case 3:
                // Consultar disponibilidad individual
                System.out.println("\n--- Consultar Disponibilidad Individual ---");
                System.out.print("Nombre de la localidad (platea, balcon1, balcon2): ");
                String nombreLocalidad = scanner.nextLine().toLowerCase();
                sistema.consultarDisponibilidadIndividual(nombreLocalidad);
                break;
                
            case 4:
                // Generar reporte de caja
                System.out.println("\n--- Reporte de Caja ---");
                System.out.println(sistema.generarReporteCaja());
                break;
                
            case 5:
                // Salir
                System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                continuar = false;
                break;
                
            default:
                // Opción no válida
                System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 5.");
                break;
        }

        return continuar;
    }

    private static int leerEntero(Scanner scanner, boolean positivo) {
        while (true) {
            try {
                int valor = scanner.nextInt();
                if (positivo && valor < 1) {
                    System.out.println("El valor debe ser un número entero positivo. Intente de nuevo.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer
            } finally {
                scanner.nextLine(); // Consumir el salto de línea
            }
        }
    }

    private static double leerDouble(Scanner scanner, boolean positivo) {
        while (true) {
            try {
                double valor = scanner.nextDouble();
                if (positivo && valor < 0) {
                    System.out.println("El valor debe ser un número decimal positivo o cero. Intente de nuevo.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
                scanner.next(); // Limpiar el buffer
            } finally {
                scanner.nextLine(); // Consumir el salto de línea
            }
        }
    }
}
