package com.tup.buensabor.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nota_credito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotaCredito extends Base{

    @Column(name = "fechaHoraEmision")
    @Temporal(TemporalType.TIME)
    private Date fechaHoraEmision;

    @Column(name = "fechaHoraVencimiento")
    @Temporal(TemporalType.TIME)
    private Date fechaHoraVencimiento;

    @Column(name = "total_Importe_Credito")
    @Temporal(TemporalType.TIME)
    private Date totalImporteCredito;

    @Nullable
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_DetalleNotaCredito")
    private List<DetalleNotaCredito> detalleNotaCredito = new ArrayList<>();


}
