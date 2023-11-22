package com.tup.buensabor.controllers.PedidoControllers;

import com.tup.buensabor.DTO.DTOPedidoABM;
import com.tup.buensabor.DTO.DTOPedidoRequest;
import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.services.PedidoServices.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
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


    @PutMapping("/admin/updatePedido")
    public ResponseEntity<?> updatePedido(@RequestParam Long pedidoID) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.cambioEstado(pedidoID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> newPedido(@RequestBody DTOPedidoABM dtoPedidoABM){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.newPedido(dtoPedidoABM));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

