package com.tup.buensabor.services.ProductoServices;

import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.entities.Producto.*;
import com.tup.buensabor.enums.EstadoProducto;
import com.tup.buensabor.factory.ProductoFactory;
import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.DTO.DTOProductoPagPrincipal;
import com.tup.buensabor.DTO.DTOReceta;
import com.tup.buensabor.enums.TipoProducto;
import com.tup.buensabor.repositories.ProductoRepository.ProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.DTO.DTOProducto;
import com.tup.buensabor.repositories.IngredienteRepository.IngredienteRepository;
import com.tup.buensabor.repositories.ProductoRepository.RubroProductoRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
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
    public List<DTOProducto> obtenerProductos() throws Exception {
        try {
            List<Producto> listaProductos = productoRepository.findAll();

            if (listaProductos.isEmpty()) {
                throw new Exception("No hay productos");
            }
            else {
                List<DTOProducto> listaDTOProducto = new ArrayList<>();

                listaProductos.forEach(producto -> {

                    if (producto.getEstadoProducto().equals(EstadoProducto.ALTA)) {
                        DTOProducto dtoProducto = new DTOProducto();
                        dtoProducto.setId(producto.getId());
                        dtoProducto.setEstadoProducto(producto.getEstadoProducto());
                        dtoProducto.setTipoProducto(producto.getTipoProducto().toString());
                        dtoProducto.setRubroProducto(producto.getRubroProducto());
                        dtoProducto.setPrecio(producto.getPrecioVenta());
                        dtoProducto.setDenominacion(producto.getDenominacion());
                        dtoProducto.setDescripcion(producto.getDescripcion());
                        dtoProducto.setUrlImagen(producto.getUrlImagen());
                        if (producto instanceof ProductoCocina) {
                            dtoProducto.setTiempoEstimadoCocina(((ProductoCocina) producto).getTiempoEstimadoCocina());
                            dtoProducto.setDetalleProductoCocinaList(((ProductoCocina) producto).getDetalleProductoCocina());
                        } else if (producto instanceof ProductoInsumo) {
                            dtoProducto.setLote(((ProductoInsumo) producto).getLote());
                            dtoProducto.setMarca(((ProductoInsumo) producto).getMarca());
                        }

                        listaDTOProducto.add(dtoProducto);
                    }
                });

                return listaDTOProducto;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Producto> searchDenominacion(String filtro) throws Exception {
        try {
            List<Producto> productos = productoRepository.searchDenominacion(filtro);
            if (productos.isEmpty()) {
                throw new Exception("No se encontró el producto...");
            } else {
                return productos;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Producto> searchCategoria(String cate) throws Exception {
        try {
            List<Producto> productosCate = new ArrayList<>();
            List<Producto> productos = productoRepository.findAll();
            for (Producto producto : productos) {

                String categoria = producto.getRubroProducto().getDenominacion();

                if (Objects.equals(categoria, cate)) {
                    productosCate.add(producto);
                }
            }
            return productosCate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto agregarProducto(DTOProducto DTOProducto) throws Exception {
        try {

            //Verifico existencia de producto
            List<Producto> productoExistente = productoRepository.buscarProducto(DTOProducto.getDenominacion());

            if (productoExistente.isEmpty()) {

                //Patrón Factoría para crear un producto del tipo Cocina o Insumo
                ProductoFactory productoFactory = new ProductoFactory();
                Producto nuevoProducto = productoFactory.crearProducto(DTOProducto);

                //Seteo de cosas en común entre ambos tipos
                nuevoProducto.setDenominacion(DTOProducto.getDenominacion());
                nuevoProducto.setDescripcion(DTOProducto.getDescripcion());
                nuevoProducto.setPrecioVenta(DTOProducto.getPrecio());
                nuevoProducto.setUrlImagen(DTOProducto.getUrlImagen());

                nuevoProducto.setFechaAlta(new Date());
                nuevoProducto.setEstadoProducto(EstadoProducto.ALTA);

                //Seteo de rubro
                Optional<RubroProducto> rubroProducto = rubroProductoRepository.findById(DTOProducto.getRubroProducto().getId());

                if (rubroProducto.isPresent()) {
                    nuevoProducto.setRubroProducto(rubroProducto.get());
                } else {
                    throw new Exception("No existe este rubro");
                }

                //Seteos del tipo cocina
                if (nuevoProducto instanceof ProductoCocina) {

                    ProductoCocina productoCocina = (ProductoCocina) nuevoProducto;
                    productoCocina.setTiempoEstimadoCocina(DTOProducto.getTiempoEstimadoCocina());
                    productoCocina.setTipoProducto(TipoProducto.COCINA);

                    //Añadir detalle producto cocina con ingredientes existentes
                    List<DetalleProductoCocina> detalleProductoList = DTOProducto.getDetalleProductoCocinaList();
                    detalleProductoList.forEach(detalleProducto -> {
                        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(detalleProducto.getIngrediente().getId());

                        if (ingrediente.isPresent()) {
                            BigDecimal cantidad = detalleProducto.getCantidad();

                            DetalleProductoCocina nuevoDetalleProducto = new DetalleProductoCocina();

                            nuevoDetalleProducto.setCantidad(cantidad);
                            nuevoDetalleProducto.setIngrediente(ingrediente.get());

                            productoCocina.addDetalleProductoCocina(nuevoDetalleProducto);
                        }
                    });
                    productoRepository.save(productoCocina);
                    return productoCocina;

                    //Seteos del tipo insumo
                } else if (nuevoProducto instanceof ProductoInsumo) {

                    ProductoInsumo productoInsumo = (ProductoInsumo) nuevoProducto;

                    productoInsumo.setTipoProducto(TipoProducto.BEBIDA);
                    productoInsumo.setLote(DTOProducto.getLote());
                    productoInsumo.setMarca(DTOProducto.getMarca());

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

    public DTOProductoCocina getReceta(Long id) throws Exception {
        try {
            Optional<Producto> productoOptional = productoRepository.findById(id);
            if (productoOptional.isEmpty()) {
                throw new Exception("No Existe El Producto Buscado");
            } else {
                if (productoOptional.get().getTipoProducto().equals(TipoProducto.COCINA)) {   //PUEDE HABER UN ERROR
                    ProductoCocina producto = (ProductoCocina) productoOptional.get();       //OJO
                    DTOProductoCocina dtoProductoCocina = new DTOProductoCocina();
                    dtoProductoCocina.setDenominacion(producto.getDenominacion());
                    dtoProductoCocina.setUrl(producto.getUrlImagen());
                    dtoProductoCocina.setPrecio(producto.getPrecioVenta());
                    dtoProductoCocina.setTiempoEstimadoCocina(producto.getTiempoEstimadoCocina());

                    dtoProductoCocina.setCategoriaRubro(producto.getRubroProducto().getDenominacion());
                    List<DetalleProductoCocina> detalleProductoCocina = producto.getDetalleProductoCocina();

                    for (DetalleProductoCocina detalleProductoCocina1 : detalleProductoCocina) {
                        DTOReceta receta = new DTOReceta();
                        receta.setCantidad(detalleProductoCocina1.getCantidad());
                        Ingrediente ingrediente = detalleProductoCocina1.getIngrediente();
                        receta.setDenominacionIngrediente(ingrediente.getDenominacion());
                        receta.setUnidadMedidaDenominacion(ingrediente.getUnidadMedida().getDenominacion());
                        receta.setUnidadMedidaAbreviatura(ingrediente.getUnidadMedida().getAbreviatura());
                        dtoProductoCocina.addReceta(receta);
                    }

                    return dtoProductoCocina;

                } else {
                    throw new Exception("Este Producto No Es De Tipo \"Cocina\"");
                }
            }


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String bajaProducto(Long id) throws Exception {
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        try {
            if (optionalProducto.isPresent()){
                Producto producto = optionalProducto.get();
                producto.setEstadoProducto(EstadoProducto.BAJA);

                productoRepository.save(producto);

                return "El producto ha sido dado de baja";

            } else {
                throw new Exception("No existe este producto");
            }
        } catch ( Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto actualizarProducto(DTOProducto DTOProducto, Long id) throws Exception {

        //Verificación de existencia antes de modificar
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        try {
            if (optionalProducto.isPresent()) {

                Producto productoAModificar = optionalProducto.get();

                if (DTOProducto.getDenominacion() != null) {
                    productoAModificar.setDenominacion(DTOProducto.getDenominacion());
                }
                if (DTOProducto.getPrecio() != null) {
                    productoAModificar.setPrecioVenta(DTOProducto.getPrecio());
                }
                if (DTOProducto.getDescripcion() != null) {
                    productoAModificar.setDescripcion(DTOProducto.getDescripcion());
                }
                if (DTOProducto.getEstadoProducto() != null) {
                    if (DTOProducto.getEstadoProducto().equals(EstadoProducto.BAJA)) {
                        productoAModificar.setFechaBaja(new Date());
                        productoAModificar.setEstadoProducto(EstadoProducto.BAJA);
                    } else if (DTOProducto.getEstadoProducto().equals(EstadoProducto.ALTA)) {
                        productoAModificar.setFechaAlta(new Date());
                        productoAModificar.setEstadoProducto(EstadoProducto.ALTA);
                    }
                }
                if (DTOProducto.getRubroProducto() != null) {
                    Optional<RubroProducto> rubroProducto = rubroProductoRepository.findById(DTOProducto.getRubroProducto().getId());
                    productoAModificar.setRubroProducto(rubroProducto.get());
                }
                if (productoAModificar instanceof ProductoCocina) {
                    if (DTOProducto.getTiempoEstimadoCocina() != null) {
                        ((ProductoCocina) productoAModificar).setTiempoEstimadoCocina(DTOProducto.getTiempoEstimadoCocina());
                    }
                    if (!DTOProducto.getDetalleProductoCocinaList().isEmpty()) {

                        List<DetalleProductoCocina> detalleProductoCocinaList = DTOProducto.getDetalleProductoCocinaList();

                        detalleProductoCocinaList.forEach(detalleProducto -> {
                            Optional<Ingrediente> optIngrediente = ingredienteRepository.findById(detalleProducto.getIngrediente().getId());

                            if (optIngrediente.isPresent()) {
                                Ingrediente ingrediente = optIngrediente.get();
                                if (!((ProductoCocina) productoAModificar).getDetalleProductoCocina().contains(ingrediente)) {

                                    DetalleProductoCocina nuevoDetalleProducto = new DetalleProductoCocina();
                                    nuevoDetalleProducto.setCantidad(detalleProducto.getCantidad());
                                    nuevoDetalleProducto.setIngrediente(ingrediente);

                                    ((ProductoCocina) productoAModificar).addDetalleProductoCocina(nuevoDetalleProducto);
                                }
                            }
                        });

                    }
                } else if (productoAModificar instanceof ProductoInsumo) {
                    if (DTOProducto.getMarca() != null) {
                        ((ProductoInsumo) productoAModificar).setMarca(DTOProducto.getMarca());
                    }
                    if (DTOProducto.getLote() != null) {
                        ((ProductoInsumo) productoAModificar).setLote(DTOProducto.getLote());
                    }
                }

                productoAModificar.setFechaModificacion(new Date());
                productoRepository.save(productoAModificar);

                return productoAModificar;

            } else {
                throw new Exception("No existe el producto");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<DTOProductoPagPrincipal> getProdPagPrincipal() throws Exception {
        try {
            List<Producto> productos = productoRepository.findAll();
            List<DTOProductoPagPrincipal> listDTOProductoPagPrincipal = new ArrayList<>();
            for (Producto producto : productos) {
                DTOProductoPagPrincipal dtoProductoPagPrincipal = new DTOProductoPagPrincipal();
                dtoProductoPagPrincipal.setDenominacion(producto.getDenominacion());
                dtoProductoPagPrincipal.setPrecio(producto.getPrecioVenta());
                dtoProductoPagPrincipal.setCategoria(producto.getRubroProducto().getDenominacion());
                dtoProductoPagPrincipal.setUrl(producto.getUrlImagen());
                if (producto.getTipoProducto().equals(TipoProducto.COCINA)) {
                    ProductoCocina productoCocina = (ProductoCocina) producto;
                    List<DetalleProductoCocina> detalleProductoCocina = productoCocina.getDetalleProductoCocina();
                    for (DetalleProductoCocina detalleProductoCocina1 : detalleProductoCocina) {
                        int valor = detalleProductoCocina1.getCantidad().compareTo(detalleProductoCocina1.getIngrediente().getStockActual());
                        if (valor > 0) {
                            dtoProductoPagPrincipal.setDisponibilidad(false);
                            break;
                        }
                        dtoProductoPagPrincipal.setDisponibilidad(true);
                    }
                } else {
                    ProductoInsumo productoInsumo = (ProductoInsumo) producto;
                    if (productoInsumo.getStock() > 0) {
                        dtoProductoPagPrincipal.setDisponibilidad(true);
                    } else {
                        dtoProductoPagPrincipal.setDisponibilidad(false);
                    }
                }
                listDTOProductoPagPrincipal.add(dtoProductoPagPrincipal);
            }
            return listDTOProductoPagPrincipal;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}