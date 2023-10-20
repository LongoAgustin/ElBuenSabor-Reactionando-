package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.entities.RubroArticuloProducto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloProductoServiceImpl extends BaseServiceImpl<RubroArticuloProducto, Long> implements RubroArticuloProductoService{

    @Autowired
    protected RubroArticuloProductoRepository rubroArticuloProductoRepository;

    public RubroArticuloProductoServiceImpl(BaseRepository<RubroArticuloProducto,Long> baseRepository, RubroArticuloProductoRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroArticuloProductoRepository = rubroArticuloIngredienteRepository;
    }

    @Override
    public RubroArticuloProducto newRubroProducto(RubroArticuloProducto rubroArticuloProducto) throws Exception{
        try{
            List<RubroArticuloProducto> rubrosProductosEncontrados = rubroArticuloProductoRepository.verificarRubroProducto(rubroArticuloProducto.getDenominacion());
            if (rubrosProductosEncontrados.isEmpty()){
                rubroArticuloProductoRepository.save(rubroArticuloProducto);
                return rubroArticuloProducto;
            }else {
                throw new Exception("Este rubro ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
