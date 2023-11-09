package com.tup.buensabor.entities.Pedido;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.Comprobante.Comprobante;
import com.tup.buensabor.entities.Usuario.Domicilio;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "fecha_hora_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAlta;

    @Column(name = "fecha_hora_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraBaja;

    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;

    @Column(name = "fecha_hora_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPedido;

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
    @JoinColumn(name = "domicilio", referencedColumnName = "id")
    private Domicilio domicilioEntrega;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public void addDetallePedido(DetallePedido detallePedido) {
        this.detallePedido.add(detallePedido);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comprobante> comprobantes = new ArrayList<>();

    public void addComprobante(Comprobante comprobante) {
        this.comprobantes.add(comprobante);
    }



}
