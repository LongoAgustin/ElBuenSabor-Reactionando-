package com.tup.buensabor;

import com.tup.buensabor.entities.Comprobante.DetalleComprobante;
import com.tup.buensabor.entities.Comprobante.Factura;
import com.tup.buensabor.entities.Comprobante.NotaCredito;
import com.tup.buensabor.entities.Ingrediente.*;
import com.tup.buensabor.entities.Pedido.DetallePedido;
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
			persona.setTelefono("123456");
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

			UnidadMedida unidadMedida1 = new UnidadMedida();

			unidadMedida1.setDenominacion("unidad");
			unidadMedida1.setAbreviatura("uni");
			unidadMedida1.setFechaHoraAlta(new Date());

			//Ingrediente

			Ingrediente ingrediente = new Ingrediente();

			ingrediente.setDenominacion("Orégano");
			ingrediente.setFechaHoraAlta(new Date());
			ingrediente.setFechaHoraBaja(null);
			ingrediente.setFechaHoraModificacion(null);
			ingrediente.setPrecioCompra(new BigDecimal(13215));
			ingrediente.setStockMinimo(new BigDecimal(2165));
			ingrediente.setStockActual(new BigDecimal(5900));
			ingrediente.setUnidadMedida(unidadMedida);
			ingrediente.setUrlImagen("https://plazavea.vteximg.com.br/arquivos/ids/419765-1000-1000/20146602.jpg?v=637375895601400000");
			ingrediente.setRubroIngrediente(rubroIngrediente2);

			Ingrediente ingrediente1 = new Ingrediente();

			ingrediente1.setDenominacion("Perejil");
			ingrediente1.setFechaHoraAlta(new Date());
			ingrediente1.setFechaHoraBaja(null);
			ingrediente1.setFechaHoraModificacion(null);
			ingrediente1.setPrecioCompra(new BigDecimal(1321));
			ingrediente1.setStockMinimo(new BigDecimal(2195));
			ingrediente1.setStockActual(new BigDecimal(590));
			ingrediente1.setUnidadMedida(unidadMedida);
			ingrediente1.setUrlImagen("https://a1.soysuper.com/ecd11b05499d59551b6cfd055513fc54.1500.0.0.0.wmark.eacfaba2.jpg");
			ingrediente1.setRubroIngrediente(rubroIngrediente2);

			Ingrediente ingrediente2 = new Ingrediente();

			ingrediente2.setDenominacion("Cebolla");
			ingrediente2.setFechaHoraAlta(new Date());
			ingrediente2.setFechaHoraBaja(null);
			ingrediente2.setFechaHoraModificacion(null);
			ingrediente2.setPrecioCompra(new BigDecimal(13215));
			ingrediente2.setStockMinimo(new BigDecimal(2165));
			ingrediente2.setStockActual(new BigDecimal(5900));
			ingrediente2.setUnidadMedida(unidadMedida);
			ingrediente2.setUrlImagen("https://tse1.mm.bing.net/th?id=OIP.3qpe49-14kITm2Hh5owIgwHaFJ&pid=Api&P=0&h=180");
			ingrediente2.setRubroIngrediente(rubroIngrediente1);


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
			cocina1.setTipoProducto(TipoProducto.COCINA);
			cocina1.setUrlImagen("https://th.bing.com/th/id/OIP.WlpuQvutgIf6oo8uY0_4JgHaE7?pid=ImgDet&rs=1");
			cocina1.setEstadoProducto(EstadoProducto.ALTA);

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
			insumo1.setTipoProducto(TipoProducto.BEBIDA);
			insumo1.setUrlImagen("https://i.ytimg.com/vi/CWJoEXswRP4/maxresdefault.jpg");
			insumo1.setEstadoProducto(EstadoProducto.ALTA);

			//DetallePedido

			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(3);
			detallePedido.setSubtotal(new BigDecimal(44894));
			detallePedido.setProducto(cocina1);

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(3);
			detallePedido1.setSubtotal(new BigDecimal(44894));
			detallePedido1.setProducto(cocina1);

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
			unidadMedidaRepository.save(unidadMedida1);
			rubroIngredienteRepository.save(rubroIngrediente1);
			rubroIngredienteRepository.save(rubroIngrediente2);
			ingredienteRepository.save(ingrediente);
			ingredienteRepository.save(ingrediente1);
			ingredienteRepository.save(ingrediente2);
			rubroProductoRepository.save(rubroProducto1);
			rubroProductoRepository.save(rubroProducto2);
			productoRepository.save(cocina1);
			productoRepository.save(insumo1);
			usuarioRepository.save(usuario);
			facturaRepository.save(factura1);
			notaCreditoRepository.save(notaCredito);
			compraIngredienteRepository.save(compraIngredientes1);

		};
	}

}
