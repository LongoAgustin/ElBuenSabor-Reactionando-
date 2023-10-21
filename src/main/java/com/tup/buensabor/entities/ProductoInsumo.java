package com.tup.buensabor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoInsumo extends Producto{
    @Column(name = "marca")
    public String marca;
    @Column(name = "lote")
    public int lote;

}
