package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.entities.Ingrediente.CompraIngredientes;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.IngredienteRepository.CompraIngredienteRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraIngredientesServiceImpl extends BaseServiceImpl<CompraIngredientes, Long> implements CompraIngredientesService {

    @Autowired
    protected CompraIngredienteRepository compraIngredienteRepository;

    public CompraIngredientesServiceImpl(BaseRepository<CompraIngredientes, Long> baseRepository, CompraIngredienteRepository compraIngredienteRepository){
        super(baseRepository);
        this.compraIngredienteRepository = compraIngredienteRepository;
    }

}
