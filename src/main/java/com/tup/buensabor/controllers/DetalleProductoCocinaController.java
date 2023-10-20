package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetalleProductoCocina;
import com.tup.buensabor.services.DetalleProductoCocinaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleProductoCocina")
public class DetalleProductoCocinaController extends  BaseControllerImpl<DetalleProductoCocina, DetalleProductoCocinaServiceImpl>{
}
