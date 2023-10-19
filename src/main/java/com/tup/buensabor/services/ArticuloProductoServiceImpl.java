package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.repositories.ArticuloProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloProductoServiceImpl extends BaseServiceImpl<ArticuloProducto, Long> implements ArticuloProductoService{

    @Autowired
    protected ArticuloProductoRepository articuloProductoRepository;

    public ArticuloProductoServiceImpl(BaseRepository<ArticuloProducto, Long> baseRepository, ArticuloProductoRepository articuloProductoRepository) {
        super(baseRepository);
        this.articuloProductoRepository = articuloProductoRepository;
    }



}
