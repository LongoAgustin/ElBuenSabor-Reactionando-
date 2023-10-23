package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.factory.ProductoFactory;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.request.ProductoRequest;
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
    public List<Producto> obtenerProductos() throws Exception {
        try {
            List<Producto> listaProductos = productoRepository.findAll();

            if (listaProductos.isEmpty()) {
                throw new Exception("No hay productos");
            }

            return listaProductos;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto agregarProducto(ProductoRequest productoRequest) throws Exception {
        try {
            List<Producto> productoExistente = productoRepository.buscarProducto(productoRequest.getDenominacion());

            if (productoExistente.isEmpty()) {

                ProductoFactory productoFactory = new ProductoFactory();
                Producto nuevoProducto = productoFactory.crearProducto(productoRequest);

                nuevoProducto.setDenominacion(productoRequest.getDenominacion());
                nuevoProducto.setDescripcion(productoRequest.getDescripcion());
                nuevoProducto.setPrecioVenta(productoRequest.getPrecio());

                if (nuevoProducto instanceof ProductoCocina) {

                    ProductoCocina productoCocina = (ProductoCocina) nuevoProducto;
                    productoCocina.setTiempoEstimadoCocina(productoRequest.getTiempoEstimadoCocina());
                    //setear rubro

                    productoRepository.save(productoCocina);

                    return productoCocina;

                } else if (nuevoProducto instanceof ProductoInsumo) {

                    ProductoInsumo productoInsumo = (ProductoInsumo) nuevoProducto;

                    productoInsumo.setLote(productoRequest.getLote());
                    productoInsumo.setMarca(productoRequest.getMarca());

                    productoRepository.save(productoInsumo);

                    return productoInsumo;

                } else {

                    throw new Exception("Error");

                }

            } else {

                throw new Exception("Este producto ya existe");

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
