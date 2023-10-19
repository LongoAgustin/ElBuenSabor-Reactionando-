package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.services.ArticuloProductoServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloProducto")
public class ArticuloProductoController extends BaseControllerImpl<ArticuloProducto, ArticuloProductoServiceImpl>{


    @PostMapping("/newProducto")
    public ResponseEntity<?> newProducto(@RequestBody ArticuloProducto articuloProducto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newProducto(articuloProducto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
