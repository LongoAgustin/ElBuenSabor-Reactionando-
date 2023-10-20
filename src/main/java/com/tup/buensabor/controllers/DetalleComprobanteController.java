package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetalleComprobante;
import com.tup.buensabor.services.DetalleComprobanteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleComprobante")
public class DetalleComprobanteController extends BaseControllerImpl<DetalleComprobante, DetalleComprobanteServiceImpl> {
}
