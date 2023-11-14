package com.tup.buensabor.services.ComprobanteServices;

import com.tup.buensabor.entities.Comprobante.Comprobante;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.ComprobanteRepository;
import com.tup.buensabor.services.BaseServiceImpl;
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
