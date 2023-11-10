package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.entities.Ingrediente.DetalleCompraIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.IngredienteRepository.DetalleCompraIngredienteRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraIngredienteServiceImpl extends BaseServiceImpl<DetalleCompraIngrediente, Long> implements DetalleCompraIngredienteService {

    @Autowired
    protected DetalleCompraIngredienteRepository detalleCompraIngredienteRepository;

    public DetalleCompraIngredienteServiceImpl(BaseRepository<DetalleCompraIngrediente,Long> baseRepository, DetalleCompraIngredienteRepository detalleCompraIngredienteRepository) {
        super(baseRepository);
        this.detalleCompraIngredienteRepository = detalleCompraIngredienteRepository;
    }
}
