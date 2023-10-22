package com.tup.buensabor.services;

import com.tup.buensabor.DTOs.DTOProducto;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    protected ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public DTOProducto obtenerProductos() throws Exception {
        try {
            List<Producto> listaProductos = productoRepository.buscarProductos();

            if (listaProductos.isEmpty()){
                throw new Exception("No hay productos");
            }

            DTOProducto dtoProducto = new DTOProducto();
            dtoProducto.setProductos(listaProductos);

            return dtoProducto;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
