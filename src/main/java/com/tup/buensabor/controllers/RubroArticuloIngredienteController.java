package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.services.RubroArticuloIngredienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroArticuloIngrediente")
public class RubroArticuloIngredienteController extends BaseControllerImpl<RubroArticuloIngrediente, RubroArticuloIngredienteServiceImpl>{

    @PostMapping("/newRubroIngrediente")
    public ResponseEntity<?> newRubroIngrediente(@RequestBody RubroArticuloIngrediente rubroArticuloIngrediente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newRubroIngrediente(rubroArticuloIngrediente));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
