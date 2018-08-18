package udea.facturacion.facturador.controllers;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import udea.facturacion.facturador.infraestructura.Publicador;
import udea.facturacion.facturador.modelo.DtoCliente;
import udea.facturacion.facturador.modelo.DtoFactura;
import udea.facturacion.facturador.modelo.DtoInv;
import udea.facturacion.facturador.modelo.DtoSap;

public class Factura {
    private static final Logger logger = LogManager.getLogger(Factura.class);
    private static Publicador publicador = new Publicador();

    public static void crear(DtoFactura factura){
        logger.info("Ingresa Factura \n{"+factura.toString()+"}");
        DtoCliente cliente= new DtoCliente(factura.getIdCliente(), factura.getNombreCliente());
        DtoInv inventario= new DtoInv(factura.getArticulo(), factura.getCantidad());
        DtoSap sap= new DtoSap(factura.getNumeroFactura(), factura.getValorTotal(), factura.getIdCliente());

        publicador.publicarMensajeAsync("facturacion.generada", "inv", new Gson().toJson(inventario));
        logger.info("Factura Generada Enviando a Inventario");
        publicador.publicarMensajeAsync("facturacion.generada", "sap",  new Gson().toJson(sap));
        logger.info("Factura Generada Enviando a Sap");
        publicador.publicarMensajeAsync("facturacion.cliente.registrar", "",  new Gson().toJson(cliente));
        logger.info("Enviando nuevo Cliente");
    }
}
