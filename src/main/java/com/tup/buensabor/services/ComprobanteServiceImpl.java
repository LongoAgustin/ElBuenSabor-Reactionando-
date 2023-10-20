package com.tup.buensabor.services;

import com.tup.buensabor.entities.Comprobante;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends BaseServiceImpl<Comprobante,Long> implements ComprobanteService {

    @Autowired
    protected ComprobanteRepository comprobanteRepository;

    public ComprobanteServiceImpl(BaseRepository<Comprobante, Long> baseRepository, ComprobanteRepository comprobanteRepository){
        super(baseRepository);
        this.comprobanteRepository = comprobanteRepository;
    }

}
