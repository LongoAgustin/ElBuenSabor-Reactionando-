package com.tup.buensabor.controllers.IngredienteControllers;

import com.tup.buensabor.DTO.DTOIngrediente;
import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.services.IngredienteServices.IngredienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ingredientes")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl> {

    @PostMapping("admin/add")
    public ResponseEntity<?> addIngrediente(@RequestBody DTOIngrediente ingrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newIngrediente(ingrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listIngredientes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listIngredientes());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("admin/update/{id}")
    public ResponseEntity<?> updateIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateIngrediente(id, ingrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteIngrediente(id));
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
