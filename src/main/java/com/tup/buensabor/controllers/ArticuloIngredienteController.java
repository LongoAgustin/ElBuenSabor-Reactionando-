package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.services.ArticuloIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloIngrediente")
public class ArticuloIngredienteController extends BaseControllerImpl<ArticuloIngrediente, ArticuloIngredienteServiceImpl>{
}
