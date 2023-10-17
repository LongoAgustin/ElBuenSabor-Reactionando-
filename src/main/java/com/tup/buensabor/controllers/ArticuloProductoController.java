package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.services.ArticuloProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloProducto")
public class ArticuloProductoController extends BaseControllerImpl<ArticuloProducto, ArticuloProductoServiceImpl>{
}
