package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Comprobante;
import com.tup.buensabor.services.ComprobanteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/comprobante")
public class ComprobanteController extends BaseControllerImpl<Comprobante, ComprobanteServiceImpl>{

}
