package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.services.ProductoInsumoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productoInsumo")
public class ProductoInsumoController extends BaseControllerImpl<ProductoInsumo, ProductoInsumoServiceImpl>{
}
