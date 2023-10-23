package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.factory.ProductoFactory;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoCocinaRepository;
import com.tup.buensabor.repositories.ProductoInsumoRepository;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    protected ProductoRepository productoRepository;

    @Autowired
    protected ProductoCocinaRepository productoCocinaRepository;

    @Autowired
    protected ProductoInsumoRepository productoInsumoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository, ProductoInsumoRepository productoInsumoRepository, ProductoCocinaRepository productoCocinaRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
        this.productoInsumoRepository = productoInsumoRepository;
        this.productoCocinaRepository = productoCocinaRepository;
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
    public Producto agregarProducto(ProductRequest productRequest) throws Exception {
        try {
            List<Producto> productoExistente = productoRepository.buscarProducto(productRequest.getDenominacion());

            if (productoExistente.isEmpty()) {

                ProductoFactory productoFactory = new ProductoFactory();
                Producto nuevoProducto = productoFactory.crearProducto(productRequest);

                if (nuevoProducto instanceof ProductoCocina) {

                    nuevoProducto.setDenominacion(productRequest.getDenominacion());
                    nuevoProducto.setDescripcion(productRequest.getDescripcion());
                    nuevoProducto.setPrecioVenta(productRequest.getPrecio());
                    ((ProductoCocina) nuevoProducto).setTiempoEstimadoCocina(productRequest.getTiempoEstimadoCocina());
                    //setear rubro

                    productoRepository.save(nuevoProducto);

                    return nuevoProducto;

                } else if (nuevoProducto instanceof ProductoInsumo) {

                    nuevoProducto.setDenominacion(productRequest.getDenominacion());
                    nuevoProducto.setDescripcion(productRequest.getDescripcion());
                    nuevoProducto.setPrecioVenta(productRequest.getPrecio());
                    ((ProductoInsumo) nuevoProducto).setLote(productRequest.getLote());
                    ((ProductoInsumo) nuevoProducto).setMarca(productRequest.getMarca());

                    productoRepository.save(nuevoProducto);

                    return nuevoProducto;

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
