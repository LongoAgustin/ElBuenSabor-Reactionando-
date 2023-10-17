package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetalleNotaCredito;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleNotaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleNotaCreditoServiceImpl extends BaseServiceImpl<DetalleNotaCredito, Long> implements DetalleNotaCreditoService{

    @Autowired
    protected DetalleNotaCreditoRepository detalleNotaCreditoRepository;

    public DetalleNotaCreditoServiceImpl(BaseRepository<DetalleNotaCredito,Long> baseRepository, DetalleNotaCreditoRepository detalleNotaCreditoRepository) {
        super(baseRepository);
        this.detalleNotaCreditoRepository = detalleNotaCreditoRepository;
    }
}
