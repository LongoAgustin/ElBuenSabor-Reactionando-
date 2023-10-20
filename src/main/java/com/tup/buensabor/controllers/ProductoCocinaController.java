package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Persona;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.services.ProductoCocinaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productoCocina")
public class ProductoCocinaController extends BaseControllerImpl<ProductoCocina, ProductoCocinaServiceImpl>{
}
