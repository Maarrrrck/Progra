import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representa un ticket de compra.
 */
public class EJERCICIO1POOTicket {
    private String numero;
    private Date fecha;
    private EJERCICIO1POOComprador comprador;
    private EJERCICIO1POOLocalidad localidad;

    /**
     * Constructor para crear un ticket.
     * @param fecha Fecha en que se emite el ticket.
     * @param comprador Comprador del ticket.
     * @param localidad Localidad donde se compraron los boletos.
     * @param correlativo Número correlativo del ticket.
     */
    public EJERCICIO1POOTicket(Date fecha, EJERCICIO1POOComprador comprador, EJERCICIO1POOLocalidad localidad, int correlativo) {
        this.fecha = fecha;
        this.comprador = comprador;
        this.localidad = localidad;
        this.numero = generarNumero(fecha, correlativo);
    }

    /**
     * Genera el número del ticket basado en la fecha y el correlativo.
     * @param fecha Fecha de emisión del ticket.
     * @param correlativo Número correlativo del ticket.
     * @return Número del ticket.
     */
    private String generarNumero(Date fecha, int correlativo) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        return sdf.format(fecha) + correlativo;
    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EJERCICIO1POOComprador getComprador() {
        return comprador;
    }

    public void setComprador(EJERCICIO1POOComprador comprador) {
        this.comprador = comprador;
    }

    public EJERCICIO1POOLocalidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(EJERCICIO1POOLocalidad localidad) {
        this.localidad = localidad;
    }
}
