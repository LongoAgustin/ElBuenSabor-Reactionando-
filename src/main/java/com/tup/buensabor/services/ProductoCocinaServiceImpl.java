package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.enums.TipoProducto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoCocinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ProductoCocinaServiceImpl extends BaseServiceImpl<ProductoCocina,Long> implements ProductoCocinaService {

    @Autowired
    protected ProductoCocinaRepository productoCocinaRepository;

    public ProductoCocinaServiceImpl(BaseRepository<ProductoCocina, Long> baseRepository, ProductoCocinaRepository productoCocinaRepository) {
        super(baseRepository);
        this.productoCocinaRepository = productoCocinaRepository;
    }


}