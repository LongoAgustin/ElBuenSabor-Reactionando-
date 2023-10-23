package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.request.ProductRequest;
import com.tup.buensabor.services.ProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{

    @GetMapping("/list")
    public ResponseEntity<?> obtenerProductos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.obtenerProductos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> agregarProducto(@RequestBody ProductRequest productRequest){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.agregarProducto(productRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
