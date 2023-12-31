package com.tup.buensabor.controllers.ComprobanteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.services.ComprobanteServices.FacturaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
    @GetMapping("/search")
   public ResponseEntity<?> emitirFacturas(@RequestParam String estado, Long idPedido) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");

        }
    }


}
