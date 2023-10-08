package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.repositories.DetalleArticuloManufacturadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuensaborApplication.class, args);
		System.out.println("Programa en Ejecucion");
	}

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("------------------------Estoy Funcionando------------------------");

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

			//Persona

			Persona persona=new Persona();
			persona.setNombre("Agustin");
			persona.setApellido("Sulan");
			persona.setEmail("agustinsula@gmail.com");
			persona.setTelefono("2627867986");

			//User

			Usuario user=new Usuario();
			user.setUsername("AguSul12");
			user.setAuth0Id("1f89JF81FSA2415G5UUES");

			//Pedido

			Pedido pedido1=new Pedido();
			pedido1.setEstado("En Preparacion");
			pedido1.setTipoEnvio("Aero");
			pedido1.setTotal(23322);

			//Factura

			Factura factura1=new Factura();
			factura1.setTotal(2323);
			factura1.setDescuento(0);
			factura1.setNumero(2735);
			factura1.setFormaPago("Mercado Pago");

			//DetallePedido

			DetallePedido detallePedido = new DetallePedido();
			detallePedido.setCantidad(3);
			detallePedido.setSubTotal(80);

			//PedidoEstadoPedido

			PedidoEstadoPedido pedidoEstadoPedido1 = new PedidoEstadoPedido();
			pedidoEstadoPedido1.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido1.setFechaHoraCambioEstado(new Date());

			PedidoEstadoPedido pedidoEstadoPedido2 = new PedidoEstadoPedido();
			pedidoEstadoPedido2.setEstadoPedido(EstadoPedido.COMPLETADO);
			pedidoEstadoPedido2.setFechaHoraCambioEstado(new Date());

			//RubroIngrediente

			RubroArticuloIngrediente rubroArticuloIngrediente1 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente1.setDenominacion("verdura");
			rubroArticuloIngrediente1.setFechaAlta(new Date());
			rubroArticuloIngrediente1.setFehaBaja(new Date());
			rubroArticuloIngrediente1.setFechaModificacion(new Date());

			RubroArticuloIngrediente rubroArticuloIngrediente2 = new RubroArticuloIngrediente();
			rubroArticuloIngrediente1.setDenominacion("condimento");
			rubroArticuloIngrediente1.setFechaAlta(new Date());
			rubroArticuloIngrediente1.setFehaBaja(new Date());
			rubroArticuloIngrediente1.setFechaModificacion(new Date());

			//RubroArticuloProducto

			RubroArticuloProducto rubroArticuloProducto1 = new RubroArticuloProducto ();
			rubroArticuloProducto1.setDenominacion("Hamburguesas");
			rubroArticuloProducto1.setFechaAlta(new Date());

			//DetalleArticuloManufacturado

			DetalleArticuloManufacturado detalleArticuloManufacturado = new DetalleArticuloManufacturado();
			detalleArticuloManufacturado.setCantidad(150);
			detalleArticuloManufacturado.setArticuloIngrediente(articuloIngrediente);

			Localidad localidad = new Localidad();
			localidad.setDenominacion("Guaymallén");

			//ArticuloProducto

			ArticuloProducto articulo1 = new ArticuloProducto ();

			articulo1.setCosto("50");
			articulo1.setDenominacion("Hamburguesa con queso");
			articulo1.setDescripcion("ta buena");
			articulo1.setFechaAlta(new Date());
			articulo1.setPrecioVenta("2900");
			articulo1.setTiempoEstimadoCocina(30);
			articulo1.setTipoProducto("Cocina");
			articulo1.setUrlImagen("");
			articulo1.setRubroArticuloProducto(rubroArticuloProducto1);
			articulo1.addDetalleArticuloManufacturado(detalleArticuloManufacturado); //VER

			//CompraIngredientes

			CompraIngredientes compraIngredientes1 =new CompraIngredientes();
			compraIngredientes1.setCostoTotalCompra(9600);
			compraIngredientes1.setFechaHoraCompraIngredientes(LocalDate.of(2023,4,10));
			compraIngredientes1.setDetalleCompraIngrediente(detalleCompraIngrediente1);

			//DetalleCompraIngrediente

			DetalleCompraIngrediente detalleCompraIngrediente1 =new DetalleCompraIngrediente();
			detalleCompraIngrediente1.setCantidadComprada(90);
			detalleCompraIngrediente1.setPrecioCompra(107);
			detalleCompraIngrediente1.setSubTotalCompra(9630);
			ArticuloIngrediente.setDetallecompraIngrediente(detalleCompraIngrediente1);

			//ArticuloIngrediente

			ArticuloIngrediente articuloIngrediente = new ArticuloIngrediente();
			articuloIngrediente.setDenominacion("Orégano");
			articuloIngrediente.setFechaAlta(new Date());
			articuloIngrediente.setFechaBaja(new Date());
			articuloIngrediente.setFechaModificacion(new Date());
			articuloIngrediente.setPrecioCompra(500);
			articuloIngrediente.setStockMinimo(150);
			articuloIngrediente.setStockActual(210);
			articuloIngrediente.setUnidadMedida(100);
			articuloIngrediente.setUrlImagen("");
			articuloIngrediente.setRubroArticuloIngrediente(rubroArticuloIngrediente1);



			//saves compra ingred y detallecompraingred

			CompraIngredienteRepository.save(compraIngredientes1);
			DetalleCompraIngredienteRepository.save(detalleCompraIngrediente1);

			//Asociaciones

			pedido1.setFactura(factura1);
			pedido1.addDetallePedido(detallePedido);

			detallePedido.setProducto(producto1);

			cliente.addPedido(pedido1);
			cliente.addDomicilio(domicilio);

			DetalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);

			clienteRepository.save(cliente);
			rubroRepository.save(rubro);

			ArticuloProductoRepository.save(articulo1);
			RubroArticuloProductoReposotory.save(rubroArticuloProducto1);
		};
	}

}
