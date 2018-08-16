package udea.facturacion.facturador.modelo;

public class DtoInv {

    private String  articulo;
    private Integer cantidad;

    public DtoInv(String articulo, Integer cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
