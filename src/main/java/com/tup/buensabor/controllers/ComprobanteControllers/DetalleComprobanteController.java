package com.tup.buensabor.controllers.ComprobanteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Comprobante.DetalleComprobante;
import com.tup.buensabor.services.ComprobanteServices.DetalleComprobanteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleComprobante")
public class DetalleComprobanteController extends BaseControllerImpl<DetalleComprobante, DetalleComprobanteServiceImpl> {
}
