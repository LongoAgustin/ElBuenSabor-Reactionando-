package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetalleComprobante;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleComprobante, Long> implements DetalleFacturaService{

    @Autowired
    protected DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleComprobante,Long> baseRepository, DetalleFacturaRepository detalleFacturaRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }
}
