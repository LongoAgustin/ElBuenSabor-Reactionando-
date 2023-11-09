package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.entities.Producto.ProductoCocina;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoRepository.ProductoCocinaRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductoCocinaServiceImpl extends BaseServiceImpl<ProductoCocina,Long> implements ProductoCocinaService {

    @Autowired
    protected ProductoCocinaRepository productoCocinaRepository;

    public ProductoCocinaServiceImpl(BaseRepository<ProductoCocina, Long> baseRepository, ProductoCocinaRepository productoCocinaRepository) {
        super(baseRepository);
        this.productoCocinaRepository = productoCocinaRepository;
    }


}