package com.tup.buensabor.controllers.IngredienteControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Ingrediente.DetalleCompraIngrediente;
import com.tup.buensabor.services.IngredienteServices.DetalleCompraIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detalleCompraIngrediente")
public class DetalleCompraIngredienteController extends BaseControllerImpl<DetalleCompraIngrediente, DetalleCompraIngredienteServiceImpl> {
}
