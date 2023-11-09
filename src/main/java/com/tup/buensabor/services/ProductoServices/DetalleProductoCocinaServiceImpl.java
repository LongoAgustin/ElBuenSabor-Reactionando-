package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.entities.Producto.DetalleProductoCocina;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoRepository.DetalleProductoCocinaRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleProductoCocinaServiceImpl extends BaseServiceImpl<DetalleProductoCocina, Long> implements DetalleProductoCocinaService {

    @Autowired
    protected DetalleProductoCocinaRepository detalleProductoCocinaRepository;

    public DetalleProductoCocinaServiceImpl(BaseRepository<DetalleProductoCocina, Long> baseRepository, DetalleProductoCocinaRepository detalleProductoCocinaRepository){
        super(baseRepository);
        this.detalleProductoCocinaRepository = detalleProductoCocinaRepository;
    }
}