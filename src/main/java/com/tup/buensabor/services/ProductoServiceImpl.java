package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import com.tup.buensabor.enums.EstadoProducto;
import com.tup.buensabor.factory.ProductoFactory;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.request.ProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

                nuevoProducto.setFechaAlta(new Date());
                nuevoProducto.setEstadoProducto(EstadoProducto.ALTA);

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

    @Override
    public Producto actualizarProducto(ProductoRequest productoRequest, Long id) throws Exception {

        //Verificar existencia de producto antes de modificar
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        try {
            if (optionalProducto.isPresent()){

                Producto productoEncontrado = optionalProducto.get();

                if (productoRequest.getDenominacion() != null){
                    productoEncontrado.setDenominacion(productoRequest.getDenominacion());
                }
                if (productoRequest.getPrecio() != null){
                    productoEncontrado.setPrecioVenta(productoRequest.getPrecio());
                }
                if (productoRequest.getDescripcion() != null){
                    productoEncontrado.setDescripcion(productoRequest.getDescripcion());
                }
                if (productoRequest.getEstadoProducto() != null) {
                    if (productoRequest.getEstadoProducto().equals(EstadoProducto.BAJA)){
                        productoEncontrado.setFechaBaja(new Date());
                        productoEncontrado.setEstadoProducto(EstadoProducto.BAJA);
                    }else if (productoRequest.getEstadoProducto().equals(EstadoProducto.ALTA)){
                        productoEncontrado.setFechaAlta(new Date());
                        productoEncontrado.setEstadoProducto(EstadoProducto.ALTA);
                    }
                }
                if (productoEncontrado instanceof ProductoCocina){
                    if (productoRequest.getTiempoEstimadoCocina() != null){
                        ((ProductoCocina) productoEncontrado).setTiempoEstimadoCocina(productoRequest.getTiempoEstimadoCocina());
                    }
                }else if (productoEncontrado instanceof ProductoInsumo){
                    if (productoRequest.getMarca() != null){
                        ((ProductoInsumo) productoEncontrado).setMarca(productoRequest.getMarca());
                    }
                    if (productoRequest.getLote() != null){
                        ((ProductoInsumo) productoEncontrado).setLote(productoRequest.getLote());
                    }
                }

                productoEncontrado.setFechaModificacion(new Date());
                productoRepository.save(productoEncontrado);

                return productoEncontrado;

            } else {
                throw new Exception("No existe el producto");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
