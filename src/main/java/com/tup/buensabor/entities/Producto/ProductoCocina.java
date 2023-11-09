package com.tup.buensabor.entities.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DiscriminatorValue("Cocina")

public class ProductoCocina extends Producto {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCTOCOCINA - INGREDIENTE")
    private List<DetalleProductoCocina> detalleProductoCocina = new ArrayList<>();

    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    public void addDetalleProductoCocina(DetalleProductoCocina detalleProductoCocina){
        this.detalleProductoCocina.add(detalleProductoCocina);
    }
}
