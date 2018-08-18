package udea.facturacion.facturador.infraestructura;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import udea.facturacion.facturador.controllers.Factura;
import udea.facturacion.facturador.modelo.DtoFactura;


@Component
public class Consumidor implements MessageListener {
    @Override
    public void onMessage(Message message) {
        Gson gson = new Gson();
        DtoFactura factura= gson.fromJson(new String(message.getBody()), DtoFactura.class);
        Factura.crear(factura);
    }
}