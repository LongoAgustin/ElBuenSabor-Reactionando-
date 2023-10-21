package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroProducto;
import com.tup.buensabor.services.RubroProductoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroProducto")
public class RubroProductoController extends BaseControllerImpl<RubroProducto, RubroProductoServiceImpl>{
}
