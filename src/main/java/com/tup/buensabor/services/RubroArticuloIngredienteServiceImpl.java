package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloIngredienteServiceImpl extends BaseServiceImpl<RubroArticuloIngrediente, Long> implements RubroArticuloIngredienteService{

    @Autowired
    protected RubroArticuloIngredienteRepository rubroArticuloIngredienteRepository;

    public RubroArticuloIngredienteServiceImpl(BaseRepository<RubroArticuloIngrediente,Long> baseRepository, RubroArticuloIngredienteRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroArticuloIngredienteRepository = rubroArticuloIngredienteRepository;
    }
}
