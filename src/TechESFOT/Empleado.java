package TechESFOT;

public abstract  class Empleado {
   //  De forma general todos los empleados tienen un código, nombre, apellido, cargo y sueldo base
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected String cargo;
    protected double sueldoBase;

    public Empleado(String codigo, String nombre, String apellido, String cargo, double sueldoBase) throws EmpleadosValidacion {



        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;


    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws EmpleadosValidacion {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new EmpleadosValidacion("El código no puede estar vacío");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws EmpleadosValidacion {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EmpleadosValidacion("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws EmpleadosValidacion {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new EmpleadosValidacion("El apellido no puede estar vacío");
        }
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws EmpleadosValidacion {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new EmpleadosValidacion("El cargo no puede estar vacío");
        }
        this.cargo = cargo;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) throws EmpleadosValidacion {
        if (sueldoBase < 0) {
            throw new EmpleadosValidacion("El sueldo base no puede ser negativo");
        }
        this.sueldoBase = sueldoBase;
    }

    public abstract void  mostrarInfo();

    public abstract double calcularSalario();


}
