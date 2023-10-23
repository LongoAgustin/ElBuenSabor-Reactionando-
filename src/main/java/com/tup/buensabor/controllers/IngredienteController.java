package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Ingrediente;
import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.services.IngredienteServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ingrediente")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl>{

    @PostMapping("/newIngrediente")
    public ResponseEntity<?> newIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newIngrediente(ingrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/updateIngrediente/{id}")
    public ResponseEntity<?> updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateIngrediente(id, ingrediente));
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
