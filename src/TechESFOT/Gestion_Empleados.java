package TechESFOT;

import java.util.ArrayList;
import java.util.List;

public class Gestion_Empleados {

   private List<Empleado> empleados;

   public Gestion_Empleados() {
       this.empleados = new ArrayList<Empleado>();
   }

   public void registrarEmpleado (Empleado empleado ) throws EmpleadosValidacion{
         if (empleado == null) {
              throw new EmpleadosValidacion("El empleado no puede ser tener su campo vacío.");
         }
         for (Empleado emp : empleados) {
              if (emp.getCodigo().equals(empleado.getCodigo())) {
                throw new EmpleadosValidacion("El código del empleado ya existe: " + empleado.getCodigo());
              }
         }
         empleados.add(empleado);
          System.out.println("Empleado registrado exitosamente:");
   }

   public void mostrarEmpleados() throws EmpleadosValidacion{
       if (empleados.isEmpty()) {
           throw new EmpleadosValidacion("No hay empleados registrados.");

       }
         for (Empleado emp : empleados) {
              emp.mostrarInfo();
              System.out.println("Salario Calculado: " + emp.calcularSalario());
              System.out.println("-----------------------");
         }

   }

   public Empleado obtenerEmpleadoConMayorSalario() throws EmpleadosValidacion {
       if (empleados.isEmpty()) {
           throw new EmpleadosValidacion("No hay empleados registrados.");
       }
       Empleado empleadoMayorSalario = empleados.get(0);
       for (Empleado emp : empleados) {
           if (emp.calcularSalario() > empleadoMayorSalario.calcularSalario()) {
               empleadoMayorSalario = emp;
           }
       }
       return empleadoMayorSalario;
   }

   public double calcularPromedioSalarios() throws EmpleadosValidacion {
       if (empleados.isEmpty()) {
           throw new EmpleadosValidacion("No hay empleados registrados.");
       }
       double sumaSalarios = 0.0;
       for (Empleado emp : empleados) {
           sumaSalarios += emp.calcularSalario();
       }
       return sumaSalarios / empleados.size();
   }

   public void mostrarEmpleadoConMayorSalario() throws EmpleadosValidacion {
       Empleado emp = obtenerEmpleadoConMayorSalario();
       System.out.println("Empleado con Mayor Salario:");
       emp.mostrarInfo();
       System.out.println("Salario Calculado: " + emp.calcularSalario());
   }


   public double salarioPromedioTotal() throws EmpleadosValidacion {
       System.out.println("Salario Promedio de Todos los Empleados:");
         return calcularPromedioSalarios();
   }



}
