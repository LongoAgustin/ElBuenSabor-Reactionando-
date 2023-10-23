package com.tup.buensabor.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOProductoCocina {
    private String url;

    private String denominacion;

    private BigDecimal precio;

    private String categoriaRubro;

    private float tiempoEstimadoCocina;

    @OneToMany(cascade = CascadeType.ALL)
    List<DTOReceta> receta=new ArrayList<>();

    public void addReceta(DTOReceta receta){
        this.receta.add(receta);
    }


}
