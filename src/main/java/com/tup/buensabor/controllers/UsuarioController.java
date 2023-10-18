package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.services.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.registrarUsuario(usuario));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
