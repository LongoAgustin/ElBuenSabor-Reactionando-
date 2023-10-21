package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetalleComprobante;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetalleComprobanteServiceImpl extends BaseServiceImpl<DetalleComprobante,Long> implements DetalleComprobanteService {

    @Autowired
    protected DetalleComprobanteRepository detalleComprobanteRepository;

    public DetalleComprobanteServiceImpl(BaseRepository<DetalleComprobante, Long> baseRepository, DetalleComprobanteRepository detalleComprobanteRepository) {
        super(baseRepository);
        this.detalleComprobanteRepository = detalleComprobanteRepository;
    }
}
