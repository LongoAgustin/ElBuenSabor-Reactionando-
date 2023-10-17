package com.tup.buensabor.services;

import com.tup.buensabor.entities.UnidadMedida;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{

    @Autowired
    protected UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida,Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
}
