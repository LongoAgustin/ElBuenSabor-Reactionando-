package com.tup.buensabor.services.PedidoServices;

import com.tup.buensabor.DTO.DTOPedidoABM;
import com.tup.buensabor.DTO.DTOPedidos;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.enums.EstadoFactura;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.FacturaRepository;
import com.tup.buensabor.repositories.PedidoRepository.PedidoRepository;
import com.tup.buensabor.repositories.ProductoRepository.ProductoRepository;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
                throw new Exception("No Existe el Usuario");
            } else {
                Pedido pedidos = pedidoid.get();
                return pedidos;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Pedido aConfirmar(Long pedidoID) throws Exception {
        try {

            Optional<Pedido> pedidosaConf = pedidoRepository.findById(pedidoID);

            if (pedidosaConf.get().getEstado() == EstadoPedido.A_CONFIRMAR) {
                Pedido pedidoCamb = pedidosaConf.get();
                pedidoCamb.setEstado(EstadoPedido.PREPARACION);
                pedidoRepository.save(pedidoCamb);
                return pedidoCamb;
            } /*else if (pedidosaConf.get().getEstado() == EstadoPedido.A_CONFIRMAR &&
                    pedidosaConf.get().getDetallePedido().get(0).getProducto().getRubroProducto(equals().)) {
                Pedido pedidoCamb = pedidosaConf.get();
                pedidoCamb.setEstado(EstadoPedido.PENDIENTE_PAGO);
                return pedidoCamb;
            }*/ else {
                throw new Exception("No hay pedidos con este estado");
            }

        } catch (
                Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pedido newPedido(DTOPedidoABM dtoPedidoABM) throws Exception {
        try {
            Optional<Pedido> pedidosEncontrados = pedidoRepository.findById(dtoPedidoABM.getId());

            if (pedidosEncontrados.isEmpty()) {

                Pedido nuevoPedido = newPedido(dtoPedidoABM);

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
                        //nuevoDetallePedido.setSubtotal(detallePedido.getSubtotal);
                        //nuevoDetallePedido.setSubtotalCosto(detallePedido.getSubtotalCosto);
                        nuevoDetallePedido.setProducto(producto.get());

                        nuevoPedido.addDetallePedido(nuevoDetallePedido);
                    }
                });

                pedidoRepository.save(nuevoPedido);
                return nuevoPedido;


            } else {
                throw new Exception("id no valido");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
