package com.tup.buensabor.controllers;

import com.tup.buensabor.services.CarritoService.CarritoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carrito")
public class CarritoController {

    @Autowired
    protected CarritoServiceImpl service;
    @PostMapping("/carrito")
    public ResponseEntity<?> getCarritoCompra(@RequestParam Long id,@RequestParam Integer cantidad){
        try {
          return ResponseEntity.status(HttpStatus.OK).body(service.getCarritoCompra(id,cantidad));
        }catch (Exception e){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }
}
