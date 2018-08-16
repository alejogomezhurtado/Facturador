package udea.facturacion.facturador.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.facturacion.facturador.modelo.Solicitud;
import udea.facturacion.facturador.infraestructura.Publicador;

@RestController
public class SolicitudController {
    private Publicador publicador = new Publicador();

    @RequestMapping(method = RequestMethod.POST, value="/solicitud")
    public @ResponseBody ResponseEntity<Solicitud> nuevaSolicitud(@RequestBody Solicitud vehiculo){
        publicador.publicarMensaje("facturacion.generada", vehiculo.getMarca(), vehiculo.getIdSolicitud()+"-"+vehiculo.getModelo());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}