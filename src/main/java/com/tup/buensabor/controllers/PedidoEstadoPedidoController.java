package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.PedidoEstadoPedido;
import com.tup.buensabor.services.PedidoEstadoPedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidoEstadoPedido")
public class PedidoEstadoPedidoController extends BaseControllerImpl<PedidoEstadoPedido, PedidoEstadoPedidoServiceImpl>{
}
