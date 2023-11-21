package com.tup.buensabor.controllers.IngredienteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.services.IngredienteServices.IngredienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RequestMapping(path = "api/v1/ingredientes")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl> {

    @PostMapping("/admin/newIngrediente")
    public ResponseEntity<?> newIngrediente(@RequestBody Ingrediente ingrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newIngrediente(ingrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/admin/updateIngrediente/{id}")
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
