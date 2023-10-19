package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;

import java.util.List;

public interface ArticuloIngredienteService extends BaseService<ArticuloIngrediente, Long>{


    public ArticuloIngrediente newIngrediente(ArticuloIngrediente articuloIngrediente) throws Exception;

    public List<ArticuloIngrediente> verificarFechaBajaIngrediente() throws Exception;

    public List<ArticuloIngrediente> stockBajo() throws Exception;
}
