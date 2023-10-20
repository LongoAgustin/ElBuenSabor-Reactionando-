package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public RubroArticuloIngrediente updateRubroIngrediente(Long id, RubroArticuloIngrediente nuevosDatos) throws Exception {
        try{
            Optional<RubroArticuloIngrediente> rubroArticuloIngredienteOptional = rubroArticuloIngredienteRepository.findById(id);

            if(rubroArticuloIngredienteOptional.isPresent()){
                RubroArticuloIngrediente rubroArticuloIngrediente = rubroArticuloIngredienteOptional.get();

                // Verifica y actualiza campos opcionales
                if (nuevosDatos.getDenominacion() != null) {
                    rubroArticuloIngrediente.setDenominacion(nuevosDatos.getDenominacion());
                    rubroArticuloIngrediente.setFechaModificacion(new Date());
                }


                // Guarda los cambios en la base de datos
                rubroArticuloIngredienteRepository.save(rubroArticuloIngrediente);

                return rubroArticuloIngrediente;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
