package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
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
			domicilio.setNumero(232);
			domicilio.setCodigoPostal(5504);
			domicilio.setNumeroDpto(23);
			domicilio.setPisoDpto(2);

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

			//Producto

			Producto producto1=new Producto();
			producto1.setTiempoEstimadoCocina(30);
			producto1.setReceta("1. hervir 2. Condimentar 3. Servir");
			producto1.setDenominacion("Huevo Hervido");
			producto1.setTipo("Huevo");
			producto1.setPrecioCompra(80);
			producto1.setPrecioVenta(100);
			producto1.setStockActual(300);
			producto1.setStockMinimo(100);
			producto1.setUnidadMedida("ctdad");

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
			rubroArticuloProducto1.setDenominacion("burgas");
			rubroArticuloProducto1.setFechaAlta(new Date());

			//Articulo

			ArticuloProducto articulo1 = new ArticuloProducto ();

			articulo1.setCosto("50");
			articulo1.setDenominacion("burga con queso");
			articulo1.setDescripcion("ta buena");
			articulo1.setFechaAlta(new Date());
			articulo1.setPrecioVenta("2900");
			articulo1.setTiempoEstimadoCocina(30);
			articulo1.setUrlImagen("");

			articulo1.addRubroArticuloProducto(rubroArticuloProducto1);

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


			//saves compra ingred y detallecompraingred

			CompraIngredienteRepository.save(compraIngredientes1);
			DetalleCompraIngredienteRepository.save(detalleCompraIngrediente1);




			//Asociaciones
			rubro.addProducto(producto1);

			pedido1.setFactura(factura1);
			pedido1.addDetallePedido(detallePedido);

			detallePedido.setProducto(producto1);

			cliente.addPedido(pedido1);
			cliente.addDomicilio(domicilio);

			clienteRepository.save(cliente);
			rubroRepository.save(rubro);

			ArticuloProductoRepository.save(articulo1);
			RubroArticuloProductoReposotory.save(rubroArticuloProducto1);
		};
	}

}
