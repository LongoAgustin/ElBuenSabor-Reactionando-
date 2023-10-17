package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.services.RubroArticuloIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroArticuloIngrediente")
public class RubroArticuloIngredienteController extends BaseControllerImpl<RubroArticuloIngrediente, RubroArticuloIngredienteServiceImpl>{
}
