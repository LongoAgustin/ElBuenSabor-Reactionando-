package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloProducto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RubroArticuloProductoServiceImpl extends BaseServiceImpl<RubroArticuloProducto, Long> implements RubroArticuloProductoService{

    @Autowired
    protected RubroArticuloProductoRepository rubroArticuloProductoRepository;

    public RubroArticuloProductoServiceImpl(BaseRepository<RubroArticuloProducto,Long> baseRepository, RubroArticuloProductoRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroArticuloProductoRepository = rubroArticuloIngredienteRepository;
    }
}
