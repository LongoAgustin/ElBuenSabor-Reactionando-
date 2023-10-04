package com.tup.buensabor;

import com.tup.buensabor.entities.Domicilio;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.Persona;
import com.tup.buensabor.entities.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


			Domicilio domicilio=new Domicilio();
			domicilio.setCalle("Olascoaga");
			domicilio.setNumero(232);
			domicilio.setCodigoPostal(5504);
			domicilio.setNumeroDpto(23);
			domicilio.setPisoDpto(2);

			Persona persona=new Persona();
			persona.setNombre("Agustin");
			persona.setApellido("Sulan");
			persona.setEmail("agustinsula@gmail.com");
			persona.setTelefono("2627867986");

			Usuario user=new Usuario();
			user.setUsername("AguSul12");
			user.setAuth0Id("1f89JF81FSA2415G5UUES");


			Pedido pedido1=new Pedido();
			pedido1.setEstado("En Preparacion");
			pedido1.setTipoEnvio("Aero");
			pedido1.setTotal(23322);


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


			Factura factura1=new Factura();
			factura1.setTotal(2323);
			factura1.setDescuento(0);
			factura1.setNumero(2735);
			factura1.setFormaPago("Mercado Pago");


			DetallePedido detallePedido = new DetallePedido();
			detallePedido.setCantidad(3);
			detallePedido.setSubTotal(80);



			Rubro rubro = new Rubro();
			rubro.setDenominacion("Carnes");



			//Asociaciones
			rubro.addProducto(producto1);

			pedido1.setFactura(factura1);
			pedido1.addDetallePedido(detallePedido);

			detallePedido.setProducto(producto1);

			cliente.addPedido(pedido1);
			cliente.addDomicilio(domicilio);

			clienteRepository.save(cliente);
			rubroRepository.save(rubro);

		};
	}

}
