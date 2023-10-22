package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.RubroProducto;
import com.tup.buensabor.enums.TipoProducto;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    protected ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    public List<Producto> searchDenominacion(String filtro) throws Exception{
        try {
            List<Producto> productos=productoRepository.searchDenominacion(filtro);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Producto> searchCategoria(String cate) throws Exception{
        try {
            List<Producto> productosCate=new ArrayList<>();
            List<Producto> productos=productoRepository.findAll();
            for (Producto producto:productos) {
                String categoria=producto.getRubroproducto().getDenominacion();
                if(Objects.equals(categoria, cate)){
                    productosCate.add(producto);
                }
            }
            return productosCate;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public DTOProductoCocina getReceta(Long id) throws Exception{
        try {



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
