package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.services.RubroIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroIngrediente")
public class RubroIngredienteController extends BaseControllerImpl<RubroIngrediente, RubroIngredienteServiceImpl>{
}
