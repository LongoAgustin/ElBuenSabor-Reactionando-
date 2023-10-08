package com.tup.buensabor.entities;

import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends Base {

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPedido estado;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "total_costo", precision = 10, scale = 2)
    private BigDecimal totalCosto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @OneToMany()
    @JoinColumn(name = "fk_detalle_pedido")
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public void addDetallePedido(DetallePedido detallePedido){
        this.detallePedido.add(detallePedido);
    }

}
