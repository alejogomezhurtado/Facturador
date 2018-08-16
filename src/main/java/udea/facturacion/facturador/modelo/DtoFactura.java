package udea.facturacion.facturador.modelo;

public class DtoFactura {

    private Integer numeroFactura;
    private Integer valorTotal;
    private Integer idCliente;
    private String  nombreCliente;
    private String  articulo;
    private Integer cantidad;


    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "DtoFactura{" +
                "numeroFactura=" + numeroFactura +
                ", valorTotal=" + valorTotal +
                ", idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", articulo='" + articulo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
