package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.entities.ArticuloProducto;
import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.repositories.ArticuloProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import jakarta.transaction.Transactional;
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


    @Override
    public ArticuloProducto newProducto(ArticuloProducto articuloProducto) throws Exception {
        try{
            List<ArticuloProducto> productosEncontrados = articuloProductoRepository.verificarProducto(articuloProducto.getDenominacion());
            if (productosEncontrados.isEmpty()){
                articuloProductoRepository.save(articuloProducto);
                return articuloProducto;
            }else {
                throw new Exception("Este producto ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
