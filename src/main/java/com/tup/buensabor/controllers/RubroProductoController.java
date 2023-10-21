package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.entities.RubroProducto;
import com.tup.buensabor.services.RubroProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroProducto")
public class RubroProductoController extends BaseControllerImpl<RubroProducto, RubroProductoServiceImpl>{

    @PostMapping("/newRubroProducto")
    public ResponseEntity<?> newRubroProducto(@RequestBody RubroProducto rubroProducto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newRubroProducto(rubroProducto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/updateRubroProducto/{id}")
    public ResponseEntity<?> updateRubroProducto(@PathVariable Long id, @RequestBody RubroProducto rubroProducto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateRubroProducto(id, rubroProducto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
