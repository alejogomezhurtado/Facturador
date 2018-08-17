package udea.facturacion.facturador.controllers;

import com.google.gson.Gson;
import udea.facturacion.facturador.infraestructura.Publicador;
import udea.facturacion.facturador.modelo.DtoCliente;
import udea.facturacion.facturador.modelo.DtoFactura;
import udea.facturacion.facturador.modelo.DtoInv;
import udea.facturacion.facturador.modelo.DtoSap;

public class Factura {
    private static Publicador publicador = new Publicador();

    public static void crear(String message){

        Gson gson = new Gson();
        DtoFactura factura= gson.fromJson(message, DtoFactura.class);
        System.out.println(factura);
        DtoCliente cliente= new DtoCliente(factura.getIdCliente(), factura.getNombreCliente());
        DtoInv inventario= new DtoInv(factura.getArticulo(), factura.getCantidad());
        DtoSap sap= new DtoSap(factura.getNumeroFactura(), factura.getValorTotal(), factura.getIdCliente());

        publicador.publicarMensaje("facturacion.generada", "inv", new Gson().toJson(inventario));
        publicador.publicarMensaje("facturacion.generada", "sap",  new Gson().toJson(sap));
        publicador.publicarMensaje("facturacion.cliente.registrar", "",  new Gson().toJson(cliente));
    }
}
