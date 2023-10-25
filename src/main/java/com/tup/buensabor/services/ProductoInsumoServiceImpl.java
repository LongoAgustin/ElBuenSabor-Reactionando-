package com.tup.buensabor.services;

import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductoInsumoServiceImpl extends BaseServiceImpl<ProductoInsumo,Long> implements ProductoInsumoService {

    @Autowired
    protected ProductoInsumoRepository productoInsumoRepository;

    public ProductoInsumoServiceImpl(BaseRepository<ProductoInsumo, Long> baseRepository, ProductoInsumoRepository productoInsumoRepository) {
        super(baseRepository);
        this.productoInsumoRepository = productoInsumoRepository;
    }
}
