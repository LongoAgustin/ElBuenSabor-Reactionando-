package com.tup.buensabor.controllers.ComprobanteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Comprobante.NotaCredito;
import com.tup.buensabor.services.ComprobanteServices.NotaCreditoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/notaCredito")
public class NotaCreditoController extends BaseControllerImpl<NotaCredito, NotaCreditoServiceImpl> {
}
