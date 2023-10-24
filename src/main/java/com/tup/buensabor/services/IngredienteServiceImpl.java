package com.tup.buensabor.services;

import com.tup.buensabor.entities.Ingrediente;
import com.tup.buensabor.entities.RubroIngrediente;
import com.tup.buensabor.repositories.IngredienteRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImpl extends BaseServiceImpl<Ingrediente, Long> implements IngredienteService {

    @Autowired
    protected IngredienteRepository ingredienteRepository;

    public IngredienteServiceImpl(BaseRepository<Ingrediente,Long> baseRepository, IngredienteRepository ingredienteRepository) {
        super(baseRepository);
        this.ingredienteRepository = ingredienteRepository;
    }



    @Override
    public Ingrediente newIngrediente(Ingrediente ingrediente) throws Exception {
        try{
            List<Ingrediente> ingredientesEncontrados = ingredienteRepository.verificarIngrediente(ingrediente.getDenominacion());
            if (ingredientesEncontrados.isEmpty()){
                ingredienteRepository.save(ingrediente);
                return ingrediente;
            }else {
                throw new Exception("Este ingrediente ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Ingrediente updateIngrediente(Long id, Ingrediente nuevosDatos) throws Exception {
        try{
            Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

            if(ingredienteOptional.isPresent()){
                Ingrediente ingrediente = ingredienteOptional.get();

                // Verifica y actualiza campos opcionales
                if (nuevosDatos.getDenominacion() != null) {
                    ingrediente.setDenominacion(nuevosDatos.getDenominacion());
                    ingrediente.setFechaHoraModificacion(new Date());
                }


                // Guarda los cambios en la base de datos
                ingredienteRepository.save(ingrediente);

                return ingrediente;
            }else {
                throw new Exception("Ese ingrediente no esta disponible");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Ingrediente> stockBajo() throws Exception {
        try{
            List<Ingrediente> ingredientesEncontrados = ingredienteRepository.stockBajo();
            return ingredientesEncontrados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
