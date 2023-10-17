package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import com.tup.buensabor.services.DetalleArticuloManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleArticuloManufacturado")
public class DetalleArticuloManufacturadoController extends  BaseControllerImpl<DetalleArticuloManufacturado, DetalleArticuloManufacturadoServiceImpl>{
}
