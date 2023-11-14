package com.tup.buensabor.entities.Comprobante;

import com.tup.buensabor.enums.EstadoFactura;
import com.tup.buensabor.enums.FormaPago;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends Comprobante {

    //NOTNULL
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_factura")
    private EstadoFactura estadoFactura;

    //NOTNULL
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pago")
    private FormaPago formaPago;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;


    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_detalle_factura")
    private List<DetalleComprobante> detallesFactura = new ArrayList<>();

    public void addDetalleFactura(DetalleComprobante detalleComprobante){
        this.detallesFactura.add(detalleComprobante);
    }
    */

}
