package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetalleNotaCredito;
import com.tup.buensabor.services.DetalleNotaCreditoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleNotaCredito")
public class DetalleNotaCreditoController extends BaseControllerImpl<DetalleNotaCredito, DetalleNotaCreditoServiceImpl>{
}