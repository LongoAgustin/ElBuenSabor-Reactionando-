package com.tup.buensabor.services;

import com.tup.buensabor.entities.Domicilio;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    protected DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio,Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
