package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroIngredienteServiceImpl extends BaseServiceImpl<RubroIngrediente, Long> implements RubroIngredienteService {

    @Autowired
    protected RubroIngredienteRepository rubroIngredienteRepository;

    public RubroIngredienteServiceImpl(BaseRepository<RubroIngrediente,Long> baseRepository, RubroIngredienteRepository rubroIngredienteRepository) {
        super(baseRepository);
        this.rubroIngredienteRepository = rubroIngredienteRepository;
    }
}
