package TechESFOT;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestion_Empleados gestionEmpleados = new Gestion_Empleados();
        System.out.println("=== Bienvenido a Tech ESFOT ===\n");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Empleado Tiempo Completo");
            System.out.println("2. Registrar Empleado Medio Tiempo");
            System.out.println("3. Mostrar Todos los Empleados");
            System.out.println("4. Empleado con Mayor Salario");
            System.out.println("5. Promedio de Salarios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        registrarEmpleadoCompleto(sc, gestionEmpleados);
                        break;
                    case 2:
                        registrarEmpleadoMedio(sc, gestionEmpleados);
                        break;
                    case 3:
                        gestionEmpleados.mostrarEmpleados();
                        break;
                    case 4:
                        Empleado mayorSalario = gestionEmpleados.obtenerEmpleadoConMayorSalario();
                        System.out.println("\n--- Empleado con Mayor Salario ---");
                        mayorSalario.mostrarInfo();
                        System.out.println("Salario Total: $" + String.format("%.2f", mayorSalario.calcularSalario()));
                        break;
                    case 5:
                        double promedio = gestionEmpleados.calcularPromedioSalarios();
                        System.out.println("\n--- Promedio de Salarios ---");
                        System.out.println("Promedio: $" + String.format("%.2f", promedio));
                        break;
                    case 6:
                        salir = true;
                        System.out.println("\n¡Gracias por usar Tech ESFOT! ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("ERROR: Opción no válida. Intente de nuevo.");
                }
            } catch (EmpleadosValidacion e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }

    private static void registrarEmpleadoCompleto(Scanner sc, Gestion_Empleados gestionEmpleados) {
        try {
            System.out.println("\n--- Registrar Empleado Tiempo Completo ---");
            System.out.print("Ingrese código: ");
            String codigo = sc.nextLine();

            System.out.print("Ingrese nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Ingrese cargo: ");
            String cargo = sc.nextLine();

            System.out.print("Ingrese sueldo base: ");
            double sueldoBase = sc.nextDouble();
            if (sueldoBase < 0) {
                throw new EmpleadosValidacion("El sueldo base no puede ser negativo");
            }

            System.out.print("Ingrese horas extras: ");
            int horasExtra = sc.nextInt();
            if (horasExtra < 0) {
                throw new EmpleadosValidacion("Las horas extras no pueden ser negativas");
            }

            System.out.print("Ingrese bono mensual: ");
            double bonoMensual = sc.nextDouble();
            if (bonoMensual < 0) {
                throw new EmpleadosValidacion("El bono mensual no puede ser negativo");
            }
            sc.nextLine();

            gestionEmpleados.registrarEmpleado(new EmpleadoCompleto(codigo, nombre, apellido, cargo, sueldoBase, horasExtra, bonoMensual));
        } catch (EmpleadosValidacion e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void registrarEmpleadoMedio(Scanner sc, Gestion_Empleados gestionEmpleados) {
        try {
            System.out.println("\n--- Registrar Empleado Medio Tiempo ---");
            System.out.print("Ingrese código: ");
            String codigo = sc.nextLine();

            System.out.print("Ingrese nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Ingrese cargo: ");
            String cargo = sc.nextLine();

            System.out.print("Ingrese sueldo base: ");
            double sueldoBase = sc.nextDouble();
            if (sueldoBase < 0) {
                throw new EmpleadosValidacion("El sueldo base no puede ser negativo");
            }

            System.out.print("Ingrese pago por hora: ");
            int pagoPorHora = sc.nextInt();
            if (pagoPorHora < 0) {
                throw new EmpleadosValidacion("El pago por hora no puede ser negativo");
            }

            System.out.print("Ingrese bono mensual: ");
            double bonoMensual = sc.nextDouble();
            if (bonoMensual < 0) {
                throw new EmpleadosValidacion("El bono mensual no puede ser negativo");
            }
            sc.nextLine();

            gestionEmpleados.registrarEmpleado(new EmpleadoMedio(codigo, nombre, apellido, cargo, sueldoBase, pagoPorHora, bonoMensual));
        } catch (EmpleadosValidacion e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}