package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoProducto;
import com.tup.buensabor.factory.ProductoFactory;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.IngredienteRepository;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.repositories.RubroProductoRepository;
import com.tup.buensabor.request.ProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    protected ProductoRepository productoRepository;

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Autowired
    RubroProductoRepository rubroProductoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository, IngredienteRepository ingredienteRepository, RubroProductoRepository rubroProductoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.rubroProductoRepository = rubroProductoRepository;
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

                //SETEAR RUBRO

                Optional<RubroProducto> rubroProducto = rubroProductoRepository.findById(productoRequest.getRubroProducto().getId());

                if (rubroProducto.isPresent()){
                    nuevoProducto.setRubroProducto(rubroProducto.get());
                } else {
                    throw new Exception("No existe este rubro");
                }

                //SI ES DEL TIPO COCINA

                if (nuevoProducto instanceof ProductoCocina) {

                    ProductoCocina productoCocina = (ProductoCocina) nuevoProducto;
                    productoCocina.setTiempoEstimadoCocina(productoRequest.getTiempoEstimadoCocina());

                    //AÑADIR DETALLESPRODUCTOCOCINA CON INGREDIENTE EXISTENTE

                    List<DetalleProductoCocina> detalleProductoList = productoRequest.getDetalleProductoCocinaList();
                    detalleProductoList.forEach(detalleProducto -> {

                        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(detalleProducto.getIngrediente().getId());

                        if (ingrediente.isPresent()){
                            BigDecimal cantidad = detalleProducto.getCantidad();

                            DetalleProductoCocina nuevoDetalleProducto = new DetalleProductoCocina();

                            nuevoDetalleProducto.setCantidad(cantidad);
                            nuevoDetalleProducto.setIngrediente(ingrediente.get());

                            productoCocina.addDetalleProductoCocina(nuevoDetalleProducto);
                        }
                    });
                    productoRepository.save(productoCocina);
                    return productoCocina;

                //SI ES DEL TIPO INSUMO

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

        //Verificación de existencia antes de modificar
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        try {
            if (optionalProducto.isPresent()){

                Producto productoAModificar = optionalProducto.get();

                if (productoRequest.getDenominacion() != null){
                    productoAModificar.setDenominacion(productoRequest.getDenominacion());
                }
                if (productoRequest.getPrecio() != null){
                    productoAModificar.setPrecioVenta(productoRequest.getPrecio());
                }
                if (productoRequest.getDescripcion() != null){
                    productoAModificar.setDescripcion(productoRequest.getDescripcion());
                }
                if (productoRequest.getEstadoProducto() != null) {
                    if (productoRequest.getEstadoProducto().equals(EstadoProducto.BAJA)){
                        productoAModificar.setFechaBaja(new Date());
                        productoAModificar.setEstadoProducto(EstadoProducto.BAJA);
                    }else if (productoRequest.getEstadoProducto().equals(EstadoProducto.ALTA)){
                        productoAModificar.setFechaAlta(new Date());
                        productoAModificar.setEstadoProducto(EstadoProducto.ALTA);
                    }
                }
                if (productoRequest.getRubroProducto() != null){
                    Optional<RubroProducto> rubroProducto = rubroProductoRepository.findById(productoRequest.getRubroProducto().getId());
                    productoAModificar.setRubroProducto(rubroProducto.get());
                }
                if (productoAModificar instanceof ProductoCocina){
                    if (productoRequest.getTiempoEstimadoCocina() != null){
                        ((ProductoCocina) productoAModificar).setTiempoEstimadoCocina(productoRequest.getTiempoEstimadoCocina());
                    }
                    if (!productoRequest.getDetalleProductoCocinaList().isEmpty()){

                        List<DetalleProductoCocina> detalleProductoCocinaList = productoRequest.getDetalleProductoCocinaList();

                        detalleProductoCocinaList.forEach(detalleProducto -> {
                            Optional<Ingrediente> optIngrediente = ingredienteRepository.findById(detalleProducto.getIngrediente().getId());

                            if (optIngrediente.isPresent()) {
                                Ingrediente ingrediente = optIngrediente.get();
                                if (!((ProductoCocina) productoAModificar).getDetalleProductoCocina().contains(ingrediente)){

                                    DetalleProductoCocina nuevoDetalleProducto = new DetalleProductoCocina();
                                    nuevoDetalleProducto.setCantidad(detalleProducto.getCantidad());
                                    nuevoDetalleProducto.setIngrediente(ingrediente);

                                    ((ProductoCocina) productoAModificar).addDetalleProductoCocina(nuevoDetalleProducto);
                                }
                            }
                        });

                    }
                }else if (productoAModificar instanceof ProductoInsumo){
                    if (productoRequest.getMarca() != null){
                        ((ProductoInsumo) productoAModificar).setMarca(productoRequest.getMarca());
                    }
                    if (productoRequest.getLote() != null){
                        ((ProductoInsumo) productoAModificar).setLote(productoRequest.getLote());
                    }
                }

                productoAModificar.setFechaModificacion(new Date());
                productoRepository.save(productoAModificar);

                return productoAModificar;

            } else {
                throw new Exception("No existe el producto");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
