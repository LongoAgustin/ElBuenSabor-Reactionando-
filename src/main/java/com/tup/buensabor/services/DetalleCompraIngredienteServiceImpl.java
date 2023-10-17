package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetalleCompraIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleCompraIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DetalleCompraIngredienteServiceImpl extends BaseServiceImpl<DetalleCompraIngrediente, Long> implements DetalleCompraIngredienteService{

    @Autowired
    protected DetalleCompraIngredienteRepository detalleCompraIngredienteRepository;

    public DetalleCompraIngredienteServiceImpl(BaseRepository<DetalleCompraIngrediente,Long> baseRepository, DetalleCompraIngredienteRepository detalleCompraIngredienteRepository) {
        super(baseRepository);
        this.detalleCompraIngredienteRepository = detalleCompraIngredienteRepository;
    }
}
