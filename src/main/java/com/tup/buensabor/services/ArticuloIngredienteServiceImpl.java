package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloIngrediente;
import com.tup.buensabor.repositories.ArticuloIngredienteRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloIngredienteServiceImpl extends BaseServiceImpl<ArticuloIngrediente, Long> implements ArticuloIngredienteService{

    @Autowired
    protected ArticuloIngredienteRepository articuloIngredienteRepository;

    public ArticuloIngredienteServiceImpl(BaseRepository<ArticuloIngrediente,Long> baseRepository, ArticuloIngredienteRepository articuloIngredienteRepository) {
        super(baseRepository);
        this.articuloIngredienteRepository = articuloIngredienteRepository;
    }



    @Override
    public ArticuloIngrediente newIngrediente(ArticuloIngrediente articuloIngrediente) throws Exception {
        try{
            List<ArticuloIngrediente> ingredientesEncontrados = articuloIngredienteRepository.verificarIngrediente(articuloIngrediente.getDenominacion());
            if (ingredientesEncontrados.isEmpty()){
                articuloIngredienteRepository.save(articuloIngrediente);
                return articuloIngrediente;
            }else {
                throw new Exception("Este ingrediente ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloIngrediente> verificarFechaBajaIngrediente() throws Exception {
        try{
            List<ArticuloIngrediente> ingredientesEncontrados = articuloIngredienteRepository.verificarFechaBajaIngrediente();
            if (ingredientesEncontrados.isEmpty()){
                throw new Exception("No hay ingredientes disponibles");
            }else {
                return ingredientesEncontrados;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloIngrediente> stockBajo() throws Exception {
        try{
            List<ArticuloIngrediente> ingredientesEncontrados = articuloIngredienteRepository.stockBajo();
            return ingredientesEncontrados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
