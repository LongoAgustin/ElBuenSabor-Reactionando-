package com.tup.buensabor.controllers.ProductoControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Producto.ProductoCocina;
import com.tup.buensabor.services.ProductoServices.ProductoCocinaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productoCocina")
public class ProductoCocinaController extends BaseControllerImpl<ProductoCocina, ProductoCocinaServiceImpl> {
}
