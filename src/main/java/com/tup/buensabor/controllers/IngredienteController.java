package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Ingrediente;
import com.tup.buensabor.services.IngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ingrediente")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl>{
}
