package TechESFOT;

public class EmpleadoMedio extends Empleado{
    private int pagoPorHora;
    private double bonoMensual;

    public EmpleadoMedio(String codigo, String nombre, String apellido, String cargo, double sueldoBase, int pagoPorHora, double bonoMensual) throws EmpleadosValidacion {
        super(codigo, nombre, apellido, cargo, sueldoBase);

        if (pagoPorHora < 0) {
            throw new EmpleadosValidacion("El pago por hora no puede ser negativo");
        }
        if (bonoMensual < 0) {
            throw new EmpleadosValidacion("El bono mensual no puede ser negativo");
        }
        this.pagoPorHora = pagoPorHora;
        this.bonoMensual = bonoMensual;
    }

    public int getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(int pagoPorHora) throws EmpleadosValidacion {
        if (pagoPorHora < 0) {
            throw new EmpleadosValidacion("El pago por hora no puede ser negativo");
        }
        this.pagoPorHora = pagoPorHora;
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
        System.out.println("Empleado Medio Tiempo:");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cargo: " + cargo);
        System.out.println("Sueldo Base: $" + sueldoBase);
        System.out.println("Pago Por Hora: $" + pagoPorHora);
        System.out.println("Bono Mensual: $" + bonoMensual);
    }

    @Override
    public double calcularSalario() {
        double salario = sueldoBase + (pagoPorHora * 15) + bonoMensual;
        return salario;
    }
}
