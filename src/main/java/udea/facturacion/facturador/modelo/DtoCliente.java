package udea.facturacion.facturador.modelo;

public class DtoCliente {

    private Integer idCliente;
    private String  nombreCliente;

    public DtoCliente(Integer idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "DtoCliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
