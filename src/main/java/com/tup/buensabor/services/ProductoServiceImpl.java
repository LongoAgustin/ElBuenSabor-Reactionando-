package com.tup.buensabor.services;

import com.tup.buensabor.DTO.DTOProductoCocina;
import com.tup.buensabor.DTO.DTOProductoPagPrincipal;
import com.tup.buensabor.DTO.DTOReceta;
import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.TipoProducto;
import com.tup.buensabor.repositories.ProductoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    protected ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    //HISTORIA 9
    public List<Producto> searchDenominacion(String filtro) throws Exception{
        try {
            List<Producto> productos=productoRepository.searchDenominacion(filtro);
            if(productos.isEmpty()){
                throw new Exception("No se encontro el Producto...");
            }else {
                return productos;
            }
        }catch (Exception e){throw new Exception(e.getMessage());}
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
            Optional<Producto> productoOptional = productoRepository.findById(id);
            if (productoOptional.isEmpty()){
                throw new Exception("No Existe El Producto Buscado");
            } else {

                if (productoOptional.get().getTipoProducto().equals(TipoProducto.COCINA)){
                    ProductoCocina producto= (ProductoCocina) productoOptional.get();
                    DTOProductoCocina dtoProductoCocina = new DTOProductoCocina();
                    dtoProductoCocina.setDenominacion(producto.getDenominacion());
                    dtoProductoCocina.setUrl(producto.getUrlImagen());
                    dtoProductoCocina.setPrecio(producto.getPrecioVenta());
                    dtoProductoCocina.setTiempoEstimadoCocina(producto.getTiempoEstimadoCocina());

                    dtoProductoCocina.setCategoriaRubro(producto.getRubroproducto().getDenominacion());
                    List<DetalleProductoCocina> detalleProductoCocina=producto.getDetalleProductoCocina();
                    for (DetalleProductoCocina detalleProductoCocina1:detalleProductoCocina){
                        DTOReceta receta=new DTOReceta();
                        receta.setCantidad(detalleProductoCocina1.getCantidad());
                        Ingrediente ingrediente=detalleProductoCocina1.getIngrediente();
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

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //HISTORIA 10

    public List<DTOProductoPagPrincipal> getProdPagPrincipal() throws Exception{
        try{
            List<Producto> productos=productoRepository.findAll();
            List<DTOProductoPagPrincipal> listdtoProductoPagPrincipal=new ArrayList<>();
            for (Producto producto:productos){
                DTOProductoPagPrincipal dtoProductoPagPrincipal=new DTOProductoPagPrincipal();
                dtoProductoPagPrincipal.setDenominacion(producto.getDenominacion());
                dtoProductoPagPrincipal.setPrecio(producto.getPrecioVenta());
                dtoProductoPagPrincipal.setCategoria(producto.getRubroproducto().getDenominacion());
                dtoProductoPagPrincipal.setUrl(producto.getUrlImagen());
                if (producto.getTipoProducto().equals(TipoProducto.COCINA)){
                    ProductoCocina productoCocina=(ProductoCocina) producto;
                    List<DetalleProductoCocina> detalleProductoCocina=productoCocina.getDetalleProductoCocina();
                    for(DetalleProductoCocina detalleProductoCocina1:detalleProductoCocina){
                        int valor=detalleProductoCocina1.getCantidad().compareTo(detalleProductoCocina1.getIngrediente().getStockActual());
                            if(valor>0){
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
                listdtoProductoPagPrincipal.add(dtoProductoPagPrincipal);
            }
            return listdtoProductoPagPrincipal;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
