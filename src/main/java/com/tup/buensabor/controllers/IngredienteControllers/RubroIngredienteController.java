package com.tup.buensabor.controllers.IngredienteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.services.IngredienteServices.RubroIngredienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroIngrediente")
public class RubroIngredienteController extends BaseControllerImpl<RubroIngrediente, RubroIngredienteServiceImpl> {

    @PostMapping("/newRubroIngrediente")
    public ResponseEntity<?> newRubroIngrediente(@RequestBody RubroIngrediente rubroIngrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newRubroIngrediente(rubroIngrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/updateRubroIngrediente/{id}")
    public ResponseEntity<?> updateRubroIngrediente(@PathVariable Long id, @RequestBody RubroIngrediente rubroIngrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateRubroIngrediente(id, rubroIngrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
