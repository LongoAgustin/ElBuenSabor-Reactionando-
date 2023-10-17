package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.repositories.ArticuloIngredienteRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloIngredienteServiceImpl extends BaseServiceImpl<ArticuloIngrediente, Long> implements ArticuloIngredienteService{

    @Autowired
    protected ArticuloIngredienteRepository articuloIngredienteRepository;

    public ArticuloIngredienteServiceImpl(BaseRepository<ArticuloIngrediente,Long> baseRepository, ArticuloIngredienteRepository articuloIngredienteRepository) {
        super(baseRepository);
        this.articuloIngredienteRepository = articuloIngredienteRepository;
    }
}
