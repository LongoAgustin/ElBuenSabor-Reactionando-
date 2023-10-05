package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Date;

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

			Persona persona=new Persona();
			persona.setId(Long.valueOf(1));
			persona.setNombre("Agustin");
			persona.setApellido("Sulan");
			persona.setEmail("agustinsula@gmail.com");
			persona.setTelefono("2627867986");

			Usuario user=new Usuario();
			user.setId(Long.valueOf(1));
			user.setUsername("AguSul12");
			user.setAuth0Id("1f89JF81FSA2415G5UUES");
			user.setRol(Rol.CLIENTE);
			user.setFechaAlta(Date.valueOf("15/2/2023"));
			user.setPersona(persona);

			Domicilio domicilio=new Domicilio();
			domicilio.setId(Long.valueOf(1));
			domicilio.setCalle("Olascoaga");
			domicilio.setNumero(232);
			domicilio.setCodigoPostal(5504);
			domicilio.setNumeroDpto(23);
			domicilio.setPisoDpto(2);
			domicilio.setUsuario(user);

			Pedido pedido1=new Pedido();
			pedido1.setId(Long.valueOf(1));
			pedido1.setFechaPedido(Date.valueOf("23/2/2023"));
			pedido1.setHoraEstimadaFinalizacion(Date.valueOf("24/2/2023"));
			pedido1.setTotalCosto(BigDecimal.valueOf(3999.99));
			pedido1.setTotal(BigDecimal.valueOf(5999.99));
			pedido1.setEstado(EstadoPedido.EN_CAMINO);
			pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
			pedido1.setFormaPago(FormaPago.MERCADO_PAGO);
			pedido1.setFechaAlta(Date.valueOf("23/2/2023"));
			pedido1.setFechaModificacion(Date.valueOf("24/2/2023"));
			pedido1.setDomicilioEntrega(domicilio);
			pedido1.setUsuario(user);
			//FALTA HACER PEDIDOESTADOPEDIDO
			//FALTA HACER DETALLEPEDIDO

			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setId(Long.valueOf(1));
			detalleFactura.setCantidad(30);
			detalleFactura.setSubtotal(BigDecimal.valueOf(252));
			//FALTA HACER ARTICULOPRODUCTO

			Factura factura1=new Factura();
			factura1.setId(Long.valueOf(1));
			factura1.setTotalVenta(BigDecimal.valueOf(5657.89));
			factura1.setFechaFacturacion(Date.valueOf("23/2/2023"));
			factura1.setMpMerchantOrderId(Long.valueOf(1));
			factura1.setMpPreferenceId("1");
			factura1.setMpPaymentId(Long.valueOf(1));
			factura1.setMpPaymentType("MercadoPago");
			factura1.setFormaPago(FormaPago.EFECTIVO);
			factura1.setEstadoFactura(EstadoFactura.EMITIDO);
			factura1.setPedido(pedido1);
			factura1.addDetalleFactura(detalleFactura);

			DetalleNotaCredito detalleNotaCredito = new DetalleNotaCredito();
			detalleFactura.setId(Long.valueOf(1));
			detalleNotaCredito.setCantidad(20);
			//FALTA HACER ARTICULOPRODUCTO


			NotaCredito notaCredito = new NotaCredito();
			detalleFactura.setId(Long.valueOf(1));
			notaCredito.setFechaHoraEmision(Date.valueOf("23/04/2023"));
			notaCredito.setFechaHoraVencimiento(Date.valueOf("23/05/2023"));
			notaCredito.setTotalImporteCredito(BigDecimal.valueOf(2520));
			notaCredito.addDetalleNotaCredito(detalleNotaCredito);



		};
	}

}
