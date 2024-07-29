import java.util.Date;

/**
 * Sistema de ventas para la gestión de boletos en el teatro.
 */
public class EJERCICIO1POOSistemaDeVentas {
    private EJERCICIO1POOLocalidad platea;
    private EJERCICIO1POOLocalidad balcon1;
    private EJERCICIO1POOLocalidad balcon2;
    private EJERCICIO1POOComprador compradorActual;
    private int correlativo;
    private double totalIngresos;

    /**
     * Constructor para inicializar el sistema de ventas.
     */
    public EJERCICIO1POOSistemaDeVentas() {
        this.correlativo = 0;
        this.totalIngresos = 0.0;
    }
    
    /**
     * Configura las localidades iniciales del teatro.
     * @param nombrePlatea Nombre de la localidad Platea.
     * @param capacidadPlatea Capacidad de la localidad Platea.
     * @param precioPlatea Precio del boleto en la localidad Platea.
     * @param nombreBalcon1 Nombre de la localidad Balcon1.
     * @param capacidadBalcon1 Capacidad de la localidad Balcon1.
     * @param precioBalcon1 Precio del boleto en la localidad Balcon1.
     * @param nombreBalcon2 Nombre de la localidad Balcon2.
     * @param capacidadBalcon2 Capacidad de la localidad Balcon2.
     * @param precioBalcon2 Precio del boleto en la localidad Balcon2.
     */
    public void configurarIniciales(String nombrePlatea, int capacidadPlatea, double precioPlatea,
                                    String nombreBalcon1, int capacidadBalcon1, double precioBalcon1,
                                    String nombreBalcon2, int capacidadBalcon2, double precioBalcon2) {
        this.platea = new EJERCICIO1POOLocalidad(nombrePlatea, capacidadPlatea, precioPlatea);
        this.balcon1 = new EJERCICIO1POOLocalidad(nombreBalcon1, capacidadBalcon1, precioBalcon1);
        this.balcon2 = new EJERCICIO1POOLocalidad(nombreBalcon2, capacidadBalcon2, precioBalcon2);
    }

    /**
     * Agrega un comprador al sistema.
     * @param nombre Nombre del comprador.
     * @param email Correo electrónico del comprador.
     * @param boletos Cantidad de boletos a comprar.
     * @param presupuesto Presupuesto del comprador.
     */
    public void agregarComprador(String nombre, String email, int boletos, double presupuesto) {
        this.compradorActual = new EJERCICIO1POOComprador(nombre, email, boletos, presupuesto);
    }

    /**
     * Realiza la compra de boletos para una localidad específica.
     * @param nombreLocalidad Nombre de la localidad donde se compran los boletos.
     */
    public void comprarBoletos(String nombreLocalidad) {
        EJERCICIO1POOLocalidad localidad = obtenerLocalidad(nombreLocalidad);
        if (localidad != null && localidad.validarEspacio(compradorActual.getCantidadBoletos())
                && localidad.validarPresupuesto(compradorActual.getPresupuesto(), compradorActual.getCantidadBoletos())) {
            int boletosComprados = localidad.venderBoletos(compradorActual.getCantidadBoletos());
            totalIngresos += boletosComprados * localidad.getPrecio();
            correlativo++;
            EJERCICIO1POOTicket ticket = new EJERCICIO1POOTicket(new Date(), compradorActual, localidad, correlativo);
            System.out.println("Ticket generado: " + ticket.getNumero());
        } else {
            System.out.println("Compra no válida");
        }
    }

    /**
     * Obtiene la localidad según su nombre.
     * @param nombreLocalidad Nombre de la localidad.
     * @return La localidad correspondiente o null si no se encuentra.
     */
    private EJERCICIO1POOLocalidad obtenerLocalidad(String nombreLocalidad) {
        return switch (nombreLocalidad.toLowerCase()) {
            case "platea" -> platea;
            case "balcon1" -> balcon1;
            case "balcon2" -> balcon2;
            default -> null;
        };
    }

    /**
     * Consulta la disponibilidad total de boletos en todas las localidades.
     */
    public void consultarDisponibilidadTotal() {
        System.out.println("Disponibilidad Total: " + 
            (platea.getBoletosDisponibles() + balcon1.getBoletosDisponibles() + balcon2.getBoletosDisponibles()));
    }

    /**
     * Consulta la disponibilidad de boletos para una localidad específica.
     * @param nombreLocalidad Nombre de la localidad.
     */
    public void consultarDisponibilidadIndividual(String nombreLocalidad) {
        EJERCICIO1POOLocalidad localidad = obtenerLocalidad(nombreLocalidad);
        if (localidad != null) {
            System.out.println("Disponibilidad de " + nombreLocalidad + ": " + localidad.getBoletosDisponibles());
        } else {
            System.out.println("Localidad no válida");
        }
    }

    /**
     * Genera un reporte de caja con los ingresos totales.
     * @return Reporte de ingresos totales.
     */
    public String generarReporteCaja() {
        return "Total Ingresos: $" + totalIngresos;
    }

    // Getters y Setters
    public EJERCICIO1POOLocalidad getPlatea() {
        return platea;
    }

    public void setPlatea(EJERCICIO1POOLocalidad platea) {
        this.platea = platea;
    }

    public EJERCICIO1POOLocalidad getBalcon1() {
        return balcon1;
    }

    public void setBalcon1(EJERCICIO1POOLocalidad balcon1) {
        this.balcon1 = balcon1;
    }

    public EJERCICIO1POOLocalidad getBalcon2() {
        return balcon2;
    }

    public void setBalcon2(EJERCICIO1POOLocalidad balcon2) {
        this.balcon2 = balcon2;
    }

    public EJERCICIO1POOComprador getCompradorActual() {
        return compradorActual;
    }

    public void setCompradorActual(EJERCICIO1POOComprador compradorActual) {
        this.compradorActual = compradorActual;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public static void main(String[] args) {
        EJERCICIO1POOSistemaDeVentas sistema = new EJERCICIO1POOSistemaDeVentas();
        sistema.configurarIniciales("Platea", 100, 200.0, "Balcon1", 50, 150.0, "Balcon2", 30, 100.0);
        sistema.agregarComprador("Juan Perez", "juan@example.com", 2, 500.0);
        sistema.comprarBoletos("platea");
        sistema.consultarDisponibilidadTotal();
    }
}
