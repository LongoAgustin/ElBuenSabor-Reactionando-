package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.services.ProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{

    @GetMapping("/searchDenominacion")
    public ResponseEntity<?> searchDenominacion(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchDenominacion(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }

    @GetMapping("/searchCategoria")
    public ResponseEntity<?> searchCategoria(@RequestParam String cate){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchCategoria(cate));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }
}
