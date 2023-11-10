package com.tup.buensabor.services.ComprobanteServices;

import com.tup.buensabor.entities.Comprobante.NotaCredito;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.NotaCreditoRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito, Long> implements NotaCreditoService {

    @Autowired
    protected NotaCreditoRepository notaCreditoRepository;

    public NotaCreditoServiceImpl(BaseRepository<NotaCredito,Long> baseRepository, NotaCreditoRepository notaCreditoRepository) {
        super(baseRepository);
        this.notaCreditoRepository = notaCreditoRepository;
    }
}
