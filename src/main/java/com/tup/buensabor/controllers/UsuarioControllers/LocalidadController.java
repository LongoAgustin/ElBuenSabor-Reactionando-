package com.tup.buensabor.controllers.UsuarioControllers;

import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Usuario.Localidad;
import com.tup.buensabor.services.UsuarioServices.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidad")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
