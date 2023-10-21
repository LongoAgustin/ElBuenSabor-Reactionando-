package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroProducto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService {

    @Autowired
    protected RubroProductoRepository rubroProductoRepository;

    public RubroProductoServiceImpl(BaseRepository<RubroProducto,Long> baseRepository, RubroProductoRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroProductoRepository = rubroArticuloIngredienteRepository;
    }
}
