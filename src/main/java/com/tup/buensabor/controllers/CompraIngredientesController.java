package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.CompraIngredientes;
import com.tup.buensabor.services.CompraIngredientesServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/compraIngredientes")
public class CompraIngredientesController extends BaseControllerImpl<CompraIngredientes, CompraIngredientesServiceImpl>{
}
