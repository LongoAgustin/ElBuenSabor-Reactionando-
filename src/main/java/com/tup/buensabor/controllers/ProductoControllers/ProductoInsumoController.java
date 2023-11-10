package com.tup.buensabor.controllers.ProductoControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Producto.ProductoInsumo;
import com.tup.buensabor.services.ProductoServices.ProductoInsumoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productoInsumo")
public class ProductoInsumoController extends BaseControllerImpl<ProductoInsumo, ProductoInsumoServiceImpl> {
}
