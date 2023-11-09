package com.tup.buensabor.services.UsuarioServices;

import com.tup.buensabor.entities.Usuario.Domicilio;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.UsuarioRepository.DomicilioRepository;
import com.tup.buensabor.services.BaseServiceImpl;
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
