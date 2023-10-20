package com.tup.buensabor.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comprobante extends Base{

    //NOTNULL
    @Column(name = "monto_total", precision = 10, scale = 2, nullable = false)
    public float montoTotal;

    //NotNull
    @Column(name = "fecha_emision_comprobante", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime fechaEmisionComprobante;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleComprobante> detalleComprobantes = new ArrayList<>();


    public void addDetalleComprobante(DetalleComprobante detalleComprobante){
        this.detalleComprobantes.add(detalleComprobante);
    }

}
