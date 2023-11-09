package com.tup.buensabor;

import com.tup.buensabor.entities.Comprobante.DetalleComprobante;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.entities.Comprobante.NotaCredito;
import com.tup.buensabor.entities.Ingrediente.*;
import com.tup.buensabor.entities.Pedido.DetallePedido;
import com.tup.buensabor.entities.Pedido.Pedido;
import com.tup.buensabor.entities.Producto.DetalleProductoCocina;
import com.tup.buensabor.entities.Producto.ProductoCocina;
import com.tup.buensabor.entities.Producto.ProductoInsumo;
import com.tup.buensabor.entities.Producto.RubroProducto;
import com.tup.buensabor.entities.Usuario.Domicilio;
import com.tup.buensabor.entities.Usuario.Localidad;
import com.tup.buensabor.entities.Usuario.Persona;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.enums.*;
import com.tup.buensabor.repositories.ComprobanteRepository.FacturaRepository;
import com.tup.buensabor.repositories.ComprobanteRepository.NotaCreditoRepository;
import com.tup.buensabor.repositories.IngredienteRepository.CompraIngredienteRepository;
import com.tup.buensabor.repositories.IngredienteRepository.IngredienteRepository;
import com.tup.buensabor.repositories.IngredienteRepository.RubroIngredienteRepository;
import com.tup.buensabor.repositories.IngredienteRepository.UnidadMedidaRepository;
import com.tup.buensabor.repositories.PedidoRepository.PedidoRepository;
import com.tup.buensabor.repositories.ProductoRepository.ProductoRepository;
import com.tup.buensabor.repositories.ProductoRepository.RubroProductoRepository;
import com.tup.buensabor.repositories.UsuarioRepository.DomicilioRepository;
import com.tup.buensabor.repositories.UsuarioRepository.LocalidadRepository;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;
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
	ProductoRepository productoRepository;
	@Autowired
	IngredienteRepository ingredienteRepository;
	@Autowired
	RubroIngredienteRepository rubroIngredienteRepository;
	@Autowired
	RubroProductoRepository rubroProductoRepository;
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

			//Persona

			Persona persona = new Persona();
			persona.setNombre("Agustin");
			persona.setApellido("Sula");
			persona.setTelefono(Long.valueOf(216346689));
			persona.setFechaHoraAlta(new Date());

			//User

			Usuario usuario = new Usuario();
			usuario.setEmail("agustinsula@gmail.com");
			usuario.setRol(Rol.CLIENTE);
			usuario.setFechaHoraAlta(LocalDateTime.now());
			usuario.setPassword("asdfasdf");
			usuario.setFirst_login(LocalDateTime.now());


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
			domicilio.setFechaHoraBaja(new Date());
			domicilio.setFechaHoraAlta(new Date());
			domicilio.setFechaHoraModificacion(new Date());
			domicilio.setLocalidad(localidad);

			//RubroIngrediente

			RubroIngrediente rubroIngrediente1 = new RubroIngrediente();
			rubroIngrediente1.setDenominacion("verdura");
			rubroIngrediente1.setFechaHoraAlta(new Date());
			rubroIngrediente1.setFechaHoraBaja(new Date());
			rubroIngrediente1.setFechaHoraModificacion(new Date());

			RubroIngrediente rubroIngrediente2 = new RubroIngrediente();
			rubroIngrediente2.setDenominacion("condimento");
			rubroIngrediente2.setFechaHoraAlta(new Date());
			rubroIngrediente2.setFechaHoraBaja(new Date());
			rubroIngrediente2.setFechaHoraModificacion(new Date());

			//RubroProducto

			RubroProducto rubroProducto1 = new RubroProducto();
			rubroProducto1.setDenominacion("Hamburguesa");
			rubroProducto1.setFechaHoraAlta(new Date());

			RubroProducto rubroProducto2 = new RubroProducto();
			rubroProducto2.setDenominacion("Gaseosa");
			rubroProducto2.setFechaHoraAlta(new Date());

			//UnidadMedida

			UnidadMedida unidadMedida = new UnidadMedida();

			unidadMedida.setDenominacion("gramos");
			unidadMedida.setAbreviatura("g");
			unidadMedida.setFechaHoraAlta(new Date());

			//Ingrediente

			Ingrediente ingrediente = new Ingrediente();

			ingrediente.setDenominacion("Orégano");
			ingrediente.setFechaHoraAlta(new Date());
			ingrediente.setFechaHoraBaja(new Date());
			ingrediente.setFechaHoraModificacion(new Date());
			ingrediente.setPrecioCompra(new BigDecimal(13215));
			ingrediente.setStockMinimo(new BigDecimal(2165));
			ingrediente.setStockActual(new BigDecimal(5900));
			ingrediente.setUnidadMedida(unidadMedida);
			ingrediente.setUrlImagen("");
			ingrediente.setRubroIngrediente(rubroIngrediente1);

			//DetalleProductoCocina

			DetalleProductoCocina detalleProductoCocina = new DetalleProductoCocina();

			detalleProductoCocina.setCantidad(new BigDecimal(4584));
			detalleProductoCocina.setIngrediente(ingrediente);

			//ProductoCocina

			ProductoCocina cocina1 = new ProductoCocina();

			cocina1.setCosto(new BigDecimal(1245));
			cocina1.setDenominacion("Hamburguesa con queso");
			cocina1.setDescripcion("ta buena MMM");
			cocina1.setFechaAlta(new Date());
			cocina1.setPrecioVenta(new BigDecimal(1321));
			cocina1.setTiempoEstimadoCocina(85);
			cocina1.setUrlImagen("");
			cocina1.setRubroProducto(rubroProducto1);
			cocina1.addDetalleProductoCocina(detalleProductoCocina);

			//ProductoInsumo

			ProductoInsumo insumo1 = new ProductoInsumo();
			insumo1.setCosto(new BigDecimal(1245));
			insumo1.setDenominacion("coca cola");
			insumo1.setDescripcion("ta buena MMM que bien");
			insumo1.setFechaAlta(new Date());
			insumo1.setPrecioVenta(new BigDecimal(1321));
			insumo1.setUrlImagen("");
			insumo1.setRubroProducto(rubroProducto2);
			insumo1.setLote(23);
			insumo1.setMarca("cocacolastic");

			//DetallePedido

			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(3);
			detallePedido.setSubtotal(new BigDecimal(44894));
			detallePedido.setSubtotalCosto(new BigDecimal(8445));
			detallePedido.setProducto(cocina1);

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(3);
			detallePedido1.setSubtotal(new BigDecimal(44894));
			detallePedido1.setSubtotalCosto(new BigDecimal(8445));
			detallePedido1.setProducto(cocina1);

			//Pedido

			Pedido pedido1 = new Pedido();
			pedido1.setEstado(EstadoPedido.A_CONFIRMAR);
			pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido1.setTotal(new BigDecimal(49844));
			pedido1.setTotalCosto(new BigDecimal(498446));
			pedido1.setFechaHoraAlta(new Date());
			pedido1.setFormaPago(FormaPago.MERCADO_PAGO);
			pedido1.setHoraEstimadaFinalizacion(new Date());
			pedido1.setFechaHoraPedido(new Date());
			pedido1.addDetallePedido(detallePedido);
			pedido1.setDomicilioEntrega(domicilio);

			Pedido pedido2 = new Pedido();
			pedido2.setEstado(EstadoPedido.PREPARACION);
			pedido2.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido2.setTotal(new BigDecimal(45944));
			pedido2.setTotalCosto(new BigDecimal(478446));
			pedido2.setFechaHoraAlta(new Date());
			pedido2.setFormaPago(FormaPago.EFECTIVO);
			pedido2.setHoraEstimadaFinalizacion(new Date());
			pedido2.setFechaHoraPedido(new Date());
			pedido2.addDetallePedido(detallePedido1);
			pedido2.setDomicilioEntrega(domicilio);

			//agregar pedido al Usuario
			usuario.addPedidoList(pedido1);
			usuario.addPedidoList(pedido2);

			//DetalleFactura

			DetalleComprobante detalleComprobante1 = new DetalleComprobante();
			detalleComprobante1.setSubtotal(new BigDecimal(564));
			detalleComprobante1.setCantidad(8);
			detalleComprobante1.setProducto(cocina1);

			//Factura

			Factura factura1 = new Factura();
			factura1.setFechaEmisionComprobante(new Date());
			factura1.setMpPaymentId(4848948L);
			factura1.setMpMerchantOrderId(498456L);
			factura1.setMpPreferenceId("fasdfas");
			factura1.setFormaPago(FormaPago.MERCADO_PAGO);
			factura1.setMontoTotal(48942);
			factura1.setEstadoFactura(EstadoFactura.EMITIDO);
			factura1.addDetalleComprobante(detalleComprobante1);

			//DetalleCompraIngrediente

			DetalleCompraIngrediente detalleCompraIngrediente1 =new DetalleCompraIngrediente();

			detalleCompraIngrediente1.setCantidadComprada(90);
			detalleCompraIngrediente1.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente1.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente1.setIngrediente(ingrediente);

			DetalleCompraIngrediente detalleCompraIngrediente2 =new DetalleCompraIngrediente();

			detalleCompraIngrediente2.setCantidadComprada(90);
			detalleCompraIngrediente2.setPrecioCompra(new BigDecimal(48));
			detalleCompraIngrediente2.setSubTotalCompra(new BigDecimal(4549));
			detalleCompraIngrediente2.setIngrediente(ingrediente);

			//CompraIngredientes

			CompraIngredientes compraIngredientes1 =new CompraIngredientes();

			compraIngredientes1.setCostoTotalCompra(new BigDecimal(564));
			compraIngredientes1.setFechaHoraCompraIngredientes(new Date());
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente1);
			compraIngredientes1.addDetalleCompraIngrediente(detalleCompraIngrediente2);

			//NotaCreditoDetalle

			DetalleComprobante detalleNotaCredito = new DetalleComprobante();
			detalleNotaCredito.setCantidad(8);
			detalleNotaCredito.setProducto(cocina1);

			//NotaCredito

			NotaCredito notaCredito = new NotaCredito();
			notaCredito.setFechaEmisionComprobante(new Date());
			notaCredito.setMontoTotal(54);
			notaCredito.addDetalleComprobante(detalleNotaCredito);

			//GUARDAR
			localidadRepository.save(localidad);
			domicilioRepository.save(domicilio);
			unidadMedidaRepository.save(unidadMedida);
			rubroIngredienteRepository.save(rubroIngrediente1);
			rubroIngredienteRepository.save(rubroIngrediente2);
			ingredienteRepository.save(ingrediente);
			rubroProductoRepository.save(rubroProducto1);
			rubroProductoRepository.save(rubroProducto2);
			productoRepository.save(cocina1);
			productoRepository.save(insumo1);
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);
			usuarioRepository.save(usuario);
			facturaRepository.save(factura1);
			notaCreditoRepository.save(notaCredito);
			compraIngredienteRepository.save(compraIngredientes1);
		};
	}

}
