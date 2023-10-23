package com.tup.buensabor.services;

import com.tup.buensabor.entities.Ingrediente;
import com.tup.buensabor.entities.RubroIngrediente;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.awt.*;
import java.util.List;

public interface IngredienteService extends BaseService<Ingrediente, Long>{

    public Ingrediente newIngrediente(Ingrediente ingrediente) throws Exception;

    public Ingrediente updateIngrediente (Long id, Ingrediente nuevosDatos) throws Exception;

    public List<Ingrediente> stockBajo() throws Exception;
}
