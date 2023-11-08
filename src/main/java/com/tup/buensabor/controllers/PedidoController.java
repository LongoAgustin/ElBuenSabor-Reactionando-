package com.tup.buensabor.controllers;

import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.services.PedidoService;
import com.tup.buensabor.services.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tup.buensabor.services.PedidoServiceImpl.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/searchXUsuario")
    public ResponseEntity<?> searchXUsuario(@RequestParam Long usuarioid) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchXUsuario(usuarioid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/getAllPedidos")
    public ResponseEntity<?> getAllPedidos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getlistaPedidos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/getAllStatues")
    public ResponseEntity<?> getAllStatues(@RequestParam String estadoPedido) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listaXEstados(estadoPedido));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/pagarPedido")
    public ResponseEntity<?> pagarPedido(@RequestParam Long idPedido){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.pagarPedido(idPedido));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/searchPedidoID")
    public ResponseEntity<?> searchPedidoID(@RequestParam Long pedidoID) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchxID(pedidoID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/updatePedido")
    public ResponseEntity<?> updatePedido(@RequestParam Long pedidoID) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.aConfirmar(pedidoID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


}
