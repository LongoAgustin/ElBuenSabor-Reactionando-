package com.tup.buensabor.entities;

import com.tup.buensabor.enums.EstadoFactura;
import com.tup.buensabor.enums.FormaPago;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends Base {


    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoFactura estadoFactura;

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;

    @OneToMany()
    @JoinColumn(name = "fk_detalle_factura")
    private DetalleFactura detalleFactura;

}
