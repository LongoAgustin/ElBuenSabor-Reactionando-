package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroArticuloProducto;
import com.tup.buensabor.services.RubroArticuloProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroArticuloProducto")
public class RubroArticuloProductoController extends BaseControllerImpl<RubroArticuloProducto, RubroArticuloProductoServiceImpl>{

    @PostMapping("/newRubroProducto")
    public ResponseEntity<?> newRubroProducto(@RequestBody RubroArticuloProducto rubroArticuloProducto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newRubroProducto(rubroArticuloProducto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
