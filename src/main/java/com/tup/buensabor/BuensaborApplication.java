package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.*;
import com.tup.buensabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ArticuloProductoRepository articuloProductoRepository;
	@Autowired
	ArticuloIngredienteRepository articuloIngredienteRepository;
	@Autowired
	RubroArticuloIngredienteRepository rubroArticuloIngredienteRepository;
	@Autowired
	RubroArticuloProductoRepository rubroArticuloProductoRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	NotaCreditoRepository notaCreditoRepository;
	@Autowired
	CompraIngredienteRepository compraIngredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(BuensaborApplication.class, args);
		System.out.println("Programa en Ejecucion");
	}

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("------------------------Estoy Funcionando------------------------");

			//User

			Usuario usuario = new Usuario();
			usuario.setNombre("Agustin Sulan");
			usuario.setEmail("agustinsula@gmail.com");
			usuario.setAuth0Id("1f89JF81FSA2415G5UUES");
			usuario.setRol(Rol.CLIENTE);
			usuario.setFechaAlta(LocalDateTime.now());
			usuario.setPassword("asdfasdf");

			//Localidad

			Localidad localidad = new Localidad();

			localidad.setDenominacion("Guaymallén");

			//Domicilio

			Domicilio domicilio=new Domicilio();
			domicilio.setCalle("Olascoaga");
			domicilio.setCodigoPostal(5504);
			domicilio.setNumero(232);
			domicilio.setNumeroDpto(23);
			domicilio.setPisoDpto(2);
			domicilio.setFechaBaja(new Date());
			domicilio.setFechaAlta(new Date());
			domicilio.setFechaModificacion(new Date());
			domicilio.setUsuario(usuario);
			domicilio.setLocalidad(localidad);

			//RubroIngrediente

			RubroArticuloIngrediente rubroArticuloIngrediente1 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente1.setDenominacion("verdura");
			rubroArticuloIngrediente1.setFechaAlta(new Date());
			rubroArticuloIngrediente1.setFechaBaja(new Date());
			rubroArticuloIngrediente1.setFechaModificacion(new Date());

			RubroArticuloIngrediente rubroArticuloIngrediente2 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente2.setDenominacion("condimento");
			rubroArticuloIngrediente2.setFechaAlta(new Date());
			rubroArticuloIngrediente2.setFechaBaja(new Date());
			rubroArticuloIngrediente2.setFechaModificacion(new Date());

			//RubroArticuloProducto

			RubroArticuloProducto rubroArticuloProducto1 = new RubroArticuloProducto ();
			rubroArticuloProducto1.setDenominacion("Hamburguesas");
			rubroArticuloProducto1.setFechaHoraAlta(new Date());

			//UnidadMedida

			UnidadMedida unidadMedida = new UnidadMedida();

			unidadMedida.setDenominacion("gramos");
			unidadMedida.setAbreviatura("g");
			unidadMedida.setFechaAlta(new Date());

			//ArticuloIngrediente

			ArticuloIngrediente articuloIngrediente = new ArticuloIngrediente();

			articuloIngrediente.setDenominacion("Orégano");
			articuloIngrediente.setFechaAlta(new Date());
			articuloIngrediente.setFechaBaja(new Date());
			articuloIngrediente.setFechaModificacion(new Date());
			articuloIngrediente.setPrecioCompra(new BigDecimal(13215));
			articuloIngrediente.setStockMinimo(new BigDecimal(2165));
			articuloIngrediente.setStockActual(new BigDecimal(584));
			articuloIngrediente.setUnidadMedida(unidadMedida);
			articuloIngrediente.setUrlImagen("");
			articuloIngrediente.setRubroArticuloIngrediente(rubroArticuloIngrediente1);

			//DetalleArticuloManufacturado

			DetalleArticuloManufacturado detalleArticuloManufacturado = new DetalleArticuloManufacturado();

			detalleArticuloManufacturado.setCantidad(new BigDecimal(4584));
			detalleArticuloManufacturado.setArticuloIngrediente(articuloIngrediente);


			//ArticuloProducto

			ArticuloProducto articulo1 = new ArticuloProducto ();

			articulo1.setCosto(new BigDecimal(1245));
			articulo1.setDenominacion("Hamburguesa con queso");
			articulo1.setDescripcion("ta buena");
			articulo1.setFechaAlta(new Date());
			articulo1.setPrecioVenta(new BigDecimal(1321));
			articulo1.setTiempoEstimadoCocina(30);
			articulo1.setTipoProducto(TipoProducto.COCINA);
			articulo1.setUrlImagen("");
			articulo1.setRubroarticuloproducto(rubroArticuloProducto1);
			articulo1.addDetalleArticuloManufacturado(detalleArticuloManufacturado);

			//DetallePedido

			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(3);
			detallePedido.setSubtotal(new BigDecimal(44894));
			detallePedido.setSubtotalCosto(new BigDecimal(8445));
			detallePedido.setArticuloProducto(articulo1);

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(3);
			detallePedido1.setSubtotal(new BigDecimal(44894));
			detallePedido1.setSubtotalCosto(new BigDecimal(8445));
			detallePedido1.setArticuloProducto(articulo1);


			//PedidoEstadoPedido

			PedidoEstadoPedido pedidoEstadoPedido1 = new PedidoEstadoPedido();
			pedidoEstadoPedido1.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido1.setFechaHoraCambioEstado(new Date());

			PedidoEstadoPedido pedidoEstadoPedido2 = new PedidoEstadoPedido();
			pedidoEstadoPedido2.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido2.setFechaHoraCambioEstado(new Date());

			//Pedido

			Pedido pedido1 = new Pedido();
			pedido1.setEstado(EstadoPedido.COMPLETADO);
			pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido1.setTotal(new BigDecimal(49844));
			pedido1.setTotalCosto(new BigDecimal(498446));
			pedido1.setFechaAlta(new Date());
			pedido1.setFormaPago(FormaPago.MERCADO_PAGO);
			pedido1.setHoraEstimadaFinalizacion(new Date());
			pedido1.setFechaPedido(new Date());
			pedido1.addDetallePedido(detallePedido);
			pedido1.addDetallePedido(detallePedido1);
			pedido1.setUsuario(usuario);
			pedido1.setDomicilioEntrega(domicilio);
			pedido1.addEstadoPedido(pedidoEstadoPedido1);
			pedido1.addEstadoPedido(pedidoEstadoPedido2);

			//DetalleFactura

			DetalleFactura detalleFactura1 = new DetalleFactura();
			detalleFactura1.setSubtotal(new BigDecimal(564));
			detalleFactura1.setCantidad(8);
			detalleFactura1.setArticuloProducto(articulo1);

			//Factura

			Factura factura1 = new Factura();
			factura1.setFechaFacturacion(new Date());
			factura1.setMpPaymentId(4848948L);
			factura1.setMpMerchantOrderId(498456L);
			factura1.setMpPreferenceId("fasdfas");
			factura1.setFormaPago(FormaPago.MERCADO_PAGO);
			factura1.setTotalVenta(new BigDecimal(489421));
			factura1.setEstadoFactura(EstadoFactura.EMITIDO);
			factura1.addDetalleFactura(detalleFactura1);
			factura1.setPedido(pedido1);

			//DetalleCompraIngrediente

			DetalleCompraIngrediente detalleCompraIngrediente1 =new DetalleCompraIngrediente();

			detalleCompraIngrediente1.setCantidadComprada(90);
			detalleCompraIngrediente1.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente1.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente1.setArticuloIngrediente(articuloIngrediente);

			DetalleCompraIngrediente detalleCompraIngrediente2 =new DetalleCompraIngrediente();

			detalleCompraIngrediente2.setCantidadComprada(90);
			detalleCompraIngrediente2.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente2.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente2.setArticuloIngrediente(articuloIngrediente);

			//CompraIngredientes

			CompraIngredientes compraIngredientes1 =new CompraIngredientes();

			compraIngredientes1.setCostoTotalCompra(new BigDecimal(564));
			compraIngredientes1.setFechaHoraCompraIngredientes(new Date());
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente1);
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente2);

			//NotaCreditoDetalle

			DetalleNotaCredito detalleNotaCredito = new DetalleNotaCredito();
			detalleNotaCredito.setCantidad(8);
			detalleNotaCredito.setArticuloProducto(articulo1);

			//NotaCredito

			NotaCredito notaCredito = new NotaCredito();
			notaCredito.setFechaHoraEmision(new Date());
			notaCredito.setFactura(factura1);
			notaCredito.setTotalImporteCredito(new BigDecimal(54));
			notaCredito.addDetalleNotaCredito(detalleNotaCredito);

			//GUARDAR
			localidadRepository.save(localidad);
			usuarioRepository.save(usuario);
			domicilioRepository.save(domicilio);
			unidadMedidaRepository.save(unidadMedida);
			rubroArticuloIngredienteRepository.save(rubroArticuloIngrediente1);
			rubroArticuloIngredienteRepository.save(rubroArticuloIngrediente2);
			articuloIngredienteRepository.save(articuloIngrediente);
			rubroArticuloProductoRepository.save(rubroArticuloProducto1);
			articuloProductoRepository.save(articulo1);
			pedidoRepository.save(pedido1);
			facturaRepository.save(factura1);
			notaCreditoRepository.save(notaCredito);
			compraIngredienteRepository.save(compraIngredientes1);
		};
	}

}
