package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RubroIngredienteServiceImpl extends BaseServiceImpl<RubroIngrediente, Long> implements RubroIngredienteService {

    @Autowired
    protected RubroIngredienteRepository rubroIngredienteRepository;

    public RubroIngredienteServiceImpl(BaseRepository<RubroIngrediente,Long> baseRepository, RubroIngredienteRepository rubroIngredienteRepository) {
        super(baseRepository);
        this.rubroIngredienteRepository = rubroIngredienteRepository;
    }

    @Override
    public RubroIngrediente newRubroIngrediente(RubroIngrediente rubroIngrediente) throws Exception {
        try{
            List<RubroIngrediente> rubrosIngredientesEncontrados = rubroIngredienteRepository.verificarRubroIngrediente(rubroIngrediente.getDenominacion());
            if (rubrosIngredientesEncontrados.isEmpty()){
                rubroIngredienteRepository.save(rubroIngrediente);
                return rubroIngrediente;
            }else {
                throw new Exception("Este rubro ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public RubroIngrediente updateRubroIngrediente(Long id, RubroIngrediente nuevosDatos) throws Exception {
        try{
            Optional<RubroIngrediente> rubroIngredienteOptional = rubroIngredienteRepository.findById(id);

            if(rubroIngredienteOptional.isPresent()){
                RubroIngrediente rubroIngrediente = rubroIngredienteOptional.get();

                // Verifica y actualiza campos opcionales
                if (nuevosDatos.getDenominacion() != null) {
                    rubroIngrediente.setDenominacion(nuevosDatos.getDenominacion());
                    rubroIngrediente.setFechaHoraModificacion(new Date());
                }


                // Guarda los cambios en la base de datos
                rubroIngredienteRepository.save(rubroIngrediente);

                return rubroIngrediente;
            }else {
                throw new Exception("Ese ingrediente no esta disponible");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
