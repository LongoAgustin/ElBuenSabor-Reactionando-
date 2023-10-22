package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "producto_cocina")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoCocina extends Producto {

    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_detalleProductoCocina")
    private List<DetalleProductoCocina> detalleProductoCocinas = new ArrayList<>();

    public void addDetalleProductoCocina(DetalleProductoCocina detalleProductoCocina){
        this.detalleProductoCocinas.add(detalleProductoCocina);
    }
    public void setTiempoEstimadoCocina(Integer time){
        tiempoEstimadoCocina=time;
    }

}
