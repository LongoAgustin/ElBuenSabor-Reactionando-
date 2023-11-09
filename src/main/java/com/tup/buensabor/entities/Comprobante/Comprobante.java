package com.tup.buensabor.entities.Comprobante;

import com.tup.buensabor.entities.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "comprobante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comprobante extends Base {

    //NOTNULL
    @Column(name = "monto_total", nullable = false)
    private float montoTotal;

    //NotNull
    @Column(name = "fecha_emision_comprobante", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmisionComprobante;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleComprobante> detalleComprobantes = new ArrayList<>();


    public void addDetalleComprobante(DetalleComprobante detalleComprobante){
        this.detalleComprobantes.add(detalleComprobante);
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFechaEmisionComprobante(Date fechaEmisionComprobante) {
        this.fechaEmisionComprobante = fechaEmisionComprobante;
    }

}
