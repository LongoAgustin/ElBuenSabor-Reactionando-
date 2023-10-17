package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.DetalleCompraIngrediente;
import com.tup.buensabor.services.DetalleCompraIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleCompraIngrediente")
public class DetalleCompraIngredienteController extends BaseControllerImpl<DetalleCompraIngrediente, DetalleCompraIngredienteServiceImpl> {
}
