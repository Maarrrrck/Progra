

/**
 * Representa a un comprador en el sistema de ventas.
 */
public class EJERCICIO1POOComprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;

    /**
     * Constructor para crear un comprador.
     * @param nombre Nombre del comprador.
     * @param email Correo electrónico del comprador.
     * @param cantidadBoletos Cantidad de boletos a comprar.
     * @param presupuesto Presupuesto máximo del comprador.
     */
    public EJERCICIO1POOComprador(String nombre, String email, int cantidadBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    /**
     * Obtiene los detalles del comprador.
     * @return Detalles del comprador.
     */
    public String getDetalles() {
        return nombre + ", " + email + ", " + cantidadBoletos + " boletos, $" + presupuesto;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
