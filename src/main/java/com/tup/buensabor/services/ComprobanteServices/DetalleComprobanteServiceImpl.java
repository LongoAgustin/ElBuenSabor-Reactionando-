package com.tup.buensabor.services.ComprobanteServices;

import com.tup.buensabor.entities.Comprobante.DetalleComprobante;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.DetalleComprobanteRepository;
import com.tup.buensabor.services.BaseServiceImpl;
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
