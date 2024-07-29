//si
/**
 * Representa una localidad en el teatro.
 */
public class EJERCICIO1POOLocalidad {
    private String nombre;
    private int capacidad;
    private double precio;
    private int boletosVendidos;

    /**
     * Constructor para crear una localidad.
     * @param nombre Nombre de la localidad.
     * @param capacidad Capacidad total de la localidad.
     * @param precio Precio del boleto en la localidad.
     */
    public EJERCICIO1POOLocalidad(String nombre, int capacidad, double precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.boletosVendidos = 0;
    }

    /**
     * Valida si hay suficiente espacio en la localidad para la cantidad deseada de boletos.
     * @param cantidadBoletos Cantidad de boletos a comprar.
     * @return True si hay espacio suficiente, false en caso contrario.
     */
    public boolean validarEspacio(int cantidadBoletos) {
        return (boletosVendidos + cantidadBoletos) <= capacidad;
    }

    /**
     * Valida si el presupuesto del comprador es suficiente para la cantidad deseada de boletos.
     * @param presupuesto Presupuesto del comprador.
     * @param cantidadBoletos Cantidad de boletos a comprar.
     * @return True si el presupuesto es suficiente, false en caso contrario.
     */
    public boolean validarPresupuesto(double presupuesto, int cantidadBoletos) {
        return presupuesto >= (cantidadBoletos * precio);
    }

    /**
     * Vende la cantidad de boletos solicitada si hay espacio suficiente.
     * @param cantidadBoletos Cantidad de boletos a vender.
     * @return Cantidad de boletos vendidos.
     */
    public int venderBoletos(int cantidadBoletos) {
        if (validarEspacio(cantidadBoletos)) {
            boletosVendidos += cantidadBoletos;
            return cantidadBoletos;
        } else {
            return 0;
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    public int getBoletosDisponibles() {
        return capacidad - boletosVendidos;
    }

    public static void main(String[] args) {
        EJERCICIO1POOLocalidad platea = new EJERCICIO1POOLocalidad("Platea", 100, 200.0);
        System.out.println("Boletos disponibles en " + platea.getNombre() + ": " + platea.getBoletosDisponibles());
        platea.venderBoletos(10);
        System.out.println("Boletos disponibles en " + platea.getNombre() + " después de la venta: " + platea.getBoletosDisponibles());
    }
}
