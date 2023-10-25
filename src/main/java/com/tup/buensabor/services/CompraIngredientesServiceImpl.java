package com.tup.buensabor.services;

import com.tup.buensabor.entities.CompraIngredientes;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.CompraIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraIngredientesServiceImpl extends BaseServiceImpl<CompraIngredientes, Long> implements CompraIngredientesService{

    @Autowired
    protected CompraIngredienteRepository compraIngredienteRepository;

    public CompraIngredientesServiceImpl(BaseRepository<CompraIngredientes, Long> baseRepository, CompraIngredienteRepository compraIngredienteRepository){
        super(baseRepository);
        this.compraIngredienteRepository = compraIngredienteRepository;
    }

}
