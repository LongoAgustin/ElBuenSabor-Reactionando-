package com.tup.buensabor.services.CarritoService;

import com.tup.buensabor.DTO.DTOCarritoCompra;
import com.tup.buensabor.DTO.DTODetalleCarritoCompra;

import java.util.List;


public interface CarritoService {

    //HISTORIA 11

    public DTOCarritoCompra getCarritoCompra(Long id, Integer cantidad) throws Exception;

}
