package com.tup.buensabor.services.CarritoService;

import com.tup.buensabor.DTO.DTOCarritoCompra;
import com.tup.buensabor.DTO.DTODetalleCarritoCompra;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public abstract class CarritoServiceImpl implements CarritoService{

    @Autowired
    protected ProductoRepository productoRepository;


    public DTOCarritoCompra getCarritoCompra(Long id, Integer cantidad) throws Exception {
        try {
            DTOCarritoCompra carritoCompra=new DTOCarritoCompra();
            Optional<Producto> productoOptional = productoRepository.findById(id);
            if (productoOptional.isEmpty()){
                throw new Exception("El Producto No Existe");
            } else {
                DTODetalleCarritoCompra detalleCarritoCompra = new DTODetalleCarritoCompra();
                Producto producto = productoOptional.get();
                detalleCarritoCompra.setDenominacion(producto.getDenominacion());
                detalleCarritoCompra.setPrecioVenta(producto.getPrecioVenta());
                detalleCarritoCompra.setUrlImagen(producto.getUrlImagen());
                detalleCarritoCompra.setCantidad(cantidad);
                BigDecimal precioUnitario = producto.getPrecioVenta();
                BigDecimal subtotal=(precioUnitario.multiply(new BigDecimal(cantidad)));
                detalleCarritoCompra.setSubtotal(subtotal);
                carritoCompra.addCarrito(detalleCarritoCompra);
                carritoCompra.calcularMontoTotal();
            }
            return carritoCompra;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    
    
}
