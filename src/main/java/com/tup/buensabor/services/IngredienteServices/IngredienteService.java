package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.DTO.DTOIngrediente;
import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.services.BaseService;

import java.util.List;

public interface IngredienteService extends BaseService<Ingrediente, Long> {

    public DTOIngrediente newIngrediente(DTOIngrediente request) throws Exception;

    public Ingrediente updateIngrediente (Long id, Ingrediente nuevosDatos) throws Exception;

    public List<Ingrediente> stockBajo() throws Exception;

    public List<DTOIngrediente> listIngredientes() throws Exception;

    public String deleteIngrediente(Long id) throws Exception;
}
