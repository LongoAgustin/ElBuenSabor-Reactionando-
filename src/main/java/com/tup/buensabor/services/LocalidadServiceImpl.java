package com.tup.buensabor.services;

import com.tup.buensabor.entities.Localidad;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{

    @Autowired
    protected LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad,Long> baseRepository, LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }
}
