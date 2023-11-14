package com.tup.buensabor.services.PedidoServices;

import com.tup.buensabor.DTO.DTOPedidoABM;
import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.enums.*;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.FacturaRepository;
import com.tup.buensabor.repositories.PedidoRepository.PedidoRepository;
import com.tup.buensabor.repositories.ProductoRepository.ProductoRepository;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    protected PedidoRepository pedidoRepository;

    @Autowired
    protected FacturaRepository facturaRepository;

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected ProductoRepository productoRepository;



    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> searchXUsuario(Long usuarioid) throws Exception {
        try {
            Optional<Usuario> user = usuarioRepository.findById(usuarioid);
            if (user.isEmpty()) {
                throw new Exception("No Existe el Usuario");
            } else {
                List<Pedido> pedidos = user.get().getPedidoList();
                return pedidos;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<DTOPedidos> getlistaPedidos() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            List<DTOPedidos> pedidosDTO = new ArrayList<>();
            for (Pedido pedido : pedidos) {
                DTOPedidos pedidoDTO = new DTOPedidos(pedido.getId(), pedido.getFechaHoraAlta(), pedido.getTipoEnvio(), pedido.getEstado());
                pedidosDTO.add(pedidoDTO);

            }
            return pedidosDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public List<DTOPedidos> listaXEstados(String estadoPedido) throws Exception {
        try {

            List<Pedido> pedidos = pedidoRepository.findByEstado(estadoPedido);

            if (!pedidos.isEmpty()) {

                List<DTOPedidos> pedidosDTO = new ArrayList<>();

                for (Pedido pedido : pedidos) {
                    DTOPedidos pedidoDTO = new DTOPedidos(pedido.getId(), pedido.getFechaHoraAlta(), pedido.getTipoEnvio(), pedido.getEstado());
                    pedidosDTO.add(pedidoDTO);
                }

                return pedidosDTO;

            } else throw new Exception("No hay pedidos con este estado");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Factura pagarPedido(Long idPedido) throws Exception {
        try {
            Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);

            if (pedidoOptional.isPresent()) {
                Pedido pedido = pedidoOptional.get();
                pedido.setEstado(EstadoPedido.PAGADO);

                Factura factura = new Factura();
                factura.setEstadoFactura(EstadoFactura.EMITIDO);
                factura.setFormaPago(FormaPago.EFECTIVO);

                pedido.addComprobante(factura);

                facturaRepository.save(factura);
                pedidoRepository.save(pedido);

                return factura;
            } else {
                throw new Exception("No existe el pedido ingresado");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Pedido searchxID(Long pedidoID) throws Exception {
        try {
            Optional<Pedido> pedidoid = pedidoRepository.findById(pedidoID);
            if (pedidoid.isEmpty()) {
                throw new Exception("No Existe el Pedido");
            } else {
                Pedido pedidos = pedidoid.get();
                return pedidos;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

/*
    public Pedido aConfirmar(Long pedidoID) throws Exception {
        try {

            Optional<Pedido> pedidosaConf = pedidoRepository.findById(pedidoID);

            if (pedidosaConf.get().getEstado() == EstadoPedido.A_CONFIRMAR) {
                Pedido pedidoCamb = pedidosaConf.get();
                pedidoCamb.setEstado(EstadoPedido.PREPARACION);
                pedidoRepository.save(pedidoCamb);
                return pedidoCamb;
            }else if(pedidosaConf.get().getEstado() == EstadoPedido.PREPARACION) {
                Pedido pedidoCamb = pedidosaConf.get();
                pedidoCamb.setEstado(EstadoPedido.PREPARACION);
                pedidoRepository.save(pedidoCamb);
                return pedidoCamb;
            }else if(pedidosaConf.get().getEstado() == EstadoPedido.) {
                Pedido pedidoCamb = pedidosaConf.get();
                pedidoCamb.setEstado(EstadoPedido.PREPARACION);
                pedidoRepository.save(pedidoCamb);
                return pedidoCamb;
            }else{
                throw new Exception("No hay pedidos con este estado");
            }

        } catch (
                Exception e) {
            throw new Exception(e.getMessage());
        }
    }
*/

    public Pedido cambioEstado (Long pedidoID) throws Exception{
        try{

            Optional<Pedido> pedido = pedidoRepository.findById(pedidoID);
            List<DetallePedido> detallePedido = pedido.get().getDetallePedido();

            if (pedido.isEmpty()) {
                throw new Exception("No Existe el Pedido");
            } else {
                Pedido cambioestadoPedido = pedido.get();
                switch(pedido.get().getEstado()){
                    case A_CONFIRMAR:
                        for (DetallePedido detalle : detallePedido) {
                            if (detalle.getProducto().getTipoProducto().equals(TipoProducto.BEBIDA)) {
                                cambioestadoPedido.setEstado(EstadoPedido.PENDIENTE_PAGO);
                                cambioestadoPedido.setFechaHoraModificacion(new Date());
                            } else {
                                cambioestadoPedido.setEstado(EstadoPedido.PREPARACION);
                                cambioestadoPedido.setFechaHoraModificacion(new Date());
                            }
                        }
                    break;
                    case PREPARACION:
                        if (pedido.get().getTipoEnvio().equals(TipoEnvio.DELIVERY)){
                            cambioestadoPedido.setEstado(EstadoPedido.PENDIENTE_ENTREGA);
                            cambioestadoPedido.setFechaHoraModificacion(new Date());
                        } else {
                            cambioestadoPedido.setEstado(EstadoPedido.PENDIENTE_PAGO);
                            cambioestadoPedido.setFechaHoraModificacion(new Date());
                        }
                    break;
                    case PENDIENTE_ENTREGA:
                        cambioestadoPedido.setEstado(EstadoPedido.EN_CAMINO);
                        cambioestadoPedido.setFechaHoraModificacion(new Date());
                        break;
                    case EN_CAMINO, PAGADO:
                        cambioestadoPedido.setEstado(EstadoPedido.COMPLETADO);
                        cambioestadoPedido.setFechaHoraModificacion(new Date());
                        break;
                    case PENDIENTE_PAGO:
                        cambioestadoPedido.setEstado(EstadoPedido.PAGADO);
                        cambioestadoPedido.setFechaHoraModificacion(new Date());
                        break;
                    case CANCELADO:
                        cambioestadoPedido.setEstado(EstadoPedido.NOTA_CREDITO);
                        cambioestadoPedido.setFechaHoraModificacion(new Date());
                        break;
                }
                pedidoRepository.save(cambioestadoPedido);
                return cambioestadoPedido;
                }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pedido newPedido(DTOPedidoABM dtoPedidoABM) throws Exception {
        try {

                Pedido nuevoPedido = new Pedido();

                nuevoPedido.setEstado(EstadoPedido.A_CONFIRMAR);
                nuevoPedido.setFechaHoraAlta(new Date());
                nuevoPedido.setFormaPago(dtoPedidoABM.getFormaPago());
                nuevoPedido.setHoraEstimadaFinalizacion(dtoPedidoABM.getHoraEstimadaFinalizacion());
                nuevoPedido.setTipoEnvio(dtoPedidoABM.getTipoEnvio());
                nuevoPedido.setTotal(dtoPedidoABM.getTotal());

                List<DetallePedido> detallePedidoList = dtoPedidoABM.getDetallePedidoList();
                detallePedidoList.forEach(detallePedido -> {
                    Optional<Producto> producto = productoRepository.findById(detallePedido.getProducto().getId());
                    if (producto.isPresent()) {
                        DetallePedido nuevoDetallePedido = new DetallePedido();
                        nuevoDetallePedido.setCantidad(detallePedido.getCantidad());
                        nuevoDetallePedido.setSubtotal(detallePedido.getSubtotal());
                        nuevoDetallePedido.setProducto(producto.get());
                        nuevoPedido.addDetallePedido(nuevoDetallePedido);
                    }
                });
                pedidoRepository.save(nuevoPedido);
                return nuevoPedido;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
