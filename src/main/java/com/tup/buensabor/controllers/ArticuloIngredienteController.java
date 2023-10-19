package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.services.ArticuloIngredienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articuloIngrediente")
public class ArticuloIngredienteController extends BaseControllerImpl<ArticuloIngrediente, ArticuloIngredienteServiceImpl>{

    @GetMapping("/verificarFechaBajaIngrediente")
    public ResponseEntity<?> verificarFechaBajaIngrediente() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.verificarFechaBajaIngrediente());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/newIngrediente")
    public ResponseEntity<?> newIngrediente(@RequestBody ArticuloIngrediente articuloIngrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newIngrediente(articuloIngrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/stockBajo")
    public ResponseEntity<?> stockBajo(String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.stockBajo());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
