package TechESFOT;

public class EmpleadoCompleto extends Empleado{

    private int horasExtra;
    private double bonoMensual;

    public EmpleadoCompleto(String codigo, String nombre, String apellido, String cargo, double sueldoBase, int horasExtra, double bonoMensual) throws EmpleadosValidacion {
        super(codigo, nombre, apellido, cargo, sueldoBase);

        if (horasExtra < 0) {
            throw new EmpleadosValidacion("Las horas extras no pueden ser negativas");
        }
        if (bonoMensual < 0) {
            throw new EmpleadosValidacion("El bono mensual no puede ser negativo");
        }
        this.horasExtra = horasExtra;
        this.bonoMensual = bonoMensual;
    }

    public int getHorasExtra() {
        return horasExtra;
    }
//vvalidacion
    public void setHorasExtra(int horasExtra) throws EmpleadosValidacion {
        if (horasExtra < 0) {
            throw new EmpleadosValidacion("Las horas extras no pueden ser negativas");
        }
        this.horasExtra = horasExtra;
    }

    public double getBonoMensual() {
        return bonoMensual;
    }

    public void setBonoMensual(double bonoMensual) throws EmpleadosValidacion {
        if (bonoMensual < 0) {
            throw new EmpleadosValidacion("El bono mensual no puede ser negativo");
        }
        this.bonoMensual = bonoMensual;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado Completo:");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cargo: " + cargo);
        System.out.println("Sueldo Base: $" + sueldoBase);
        System.out.println("Horas Extra: " + horasExtra);
        System.out.println("Bono Mensual: $" + bonoMensual);
    }

    @Override
    public double calcularSalario() {
        double salario = sueldoBase + (horasExtra * 20) + bonoMensual;
        return salario;
    }

}
