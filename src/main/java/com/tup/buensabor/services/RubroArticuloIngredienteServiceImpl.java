package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RubroArticuloIngredienteServiceImpl extends BaseServiceImpl<RubroArticuloIngrediente, Long> implements RubroArticuloIngredienteService{

    @Autowired
    protected RubroArticuloIngredienteRepository rubroArticuloIngredienteRepository;

    public RubroArticuloIngredienteServiceImpl(BaseRepository<RubroArticuloIngrediente,Long> baseRepository, RubroArticuloIngredienteRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroArticuloIngredienteRepository = rubroArticuloIngredienteRepository;
    }

    @Override
    public RubroArticuloIngrediente newRubroIngrediente(RubroArticuloIngrediente rubroArticuloIngrediente) throws Exception{
        try{
            List<RubroArticuloIngrediente> rubrosIngredientesEncontrados = rubroArticuloIngredienteRepository.verificarRubroIngrediente(rubroArticuloIngrediente.getDenominacion());
            if (rubrosIngredientesEncontrados.isEmpty()){
                rubroArticuloIngredienteRepository.save(rubroArticuloIngrediente);
                return rubroArticuloIngrediente;
            }else {
                throw new Exception("Este rubro ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
