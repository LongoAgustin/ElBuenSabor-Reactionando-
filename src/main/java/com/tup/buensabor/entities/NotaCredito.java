package com.tup.buensabor.entities;

import jakarta.annotation.Nullable;
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
@Table(name = "nota_credito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotaCredito extends Comprobante{

    @Column(name = "fecha_hora_vencimiento")
    @Temporal(TemporalType.TIME)
    private Date fechaHoraVencimiento;



    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_DetalleNotaCredito")
    private List<DetalleComprobante> detalleNotaCredito = new ArrayList<>();

    public void addDetalleNotaCredito (DetalleComprobante detalleNotaCredito){
        this.detalleNotaCredito.add(detalleNotaCredito);
    }
    */


}
