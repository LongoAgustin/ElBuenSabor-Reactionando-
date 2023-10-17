package com.tup.buensabor.services;

import com.tup.buensabor.entities.NotaCredito;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.NotaCreditoRepository;
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
