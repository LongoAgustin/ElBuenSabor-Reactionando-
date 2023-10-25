package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.services.DetallePedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallePedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{

}
