package com.tup.buensabor.services.IngredienteServices;

import com.tup.buensabor.DTO.DTOIngrediente;
import com.tup.buensabor.entities.Ingrediente.Ingrediente;
import com.tup.buensabor.entities.Ingrediente.RubroIngrediente;
import com.tup.buensabor.entities.Ingrediente.UnidadMedida;
import com.tup.buensabor.entities.Producto.RubroProducto;
import com.tup.buensabor.repositories.IngredienteRepository.IngredienteRepository;
import com.tup.buensabor.repositories.IngredienteRepository.RubroIngredienteRepository;
import com.tup.buensabor.repositories.IngredienteRepository.UnidadMedidaRepository;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImpl extends BaseServiceImpl<Ingrediente, Long> implements IngredienteService {

    @Autowired
    protected IngredienteRepository ingredienteRepository;

    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    RubroIngredienteRepository rubroIngredienteRepository;

    public IngredienteServiceImpl(BaseRepository<Ingrediente,Long> baseRepository, IngredienteRepository ingredienteRepository) {
        super(baseRepository);
        this.ingredienteRepository = ingredienteRepository;
    }



    @Override
    public DTOIngrediente newIngrediente(DTOIngrediente request) throws Exception {
        try{
            List<Ingrediente> ingredientesEncontrados = ingredienteRepository.verificarIngrediente(request.getDenominacion());
            if (ingredientesEncontrados.isEmpty()){
                
                Ingrediente ingrediente = new Ingrediente();
                
                ingrediente.setDenominacion(request.getDenominacion());
                ingrediente.setFechaHoraAlta(new Date());
                ingrediente.setPrecioCompra(request.getPrecio());
                ingrediente.setStockActual(request.getStockActual());
                ingrediente.setStockMinimo(request.getStockMinimo());
                ingrediente.setUrlImagen(request.getUrlImagen());

                if(request.getUnidadMedida() != null){
                    List<UnidadMedida> unidadMedida = unidadMedidaRepository.findByDenominaion(request.getUnidadMedida().getDenominacion());
                    ingrediente.setUnidadMedida(unidadMedida.get(0));
                }
                
                if(request.getRubroIngrediente() != null){
                    List<RubroIngrediente> rubOptional = rubroIngredienteRepository.verificarRubroIngrediente(request.getRubroIngrediente().getDenominacion());
                    ingrediente.setRubroIngrediente(rubOptional.get(0));
                }

                ingredienteRepository.save(ingrediente);

                return request;

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

    @Override
    public List<DTOIngrediente> listIngredientes() throws Exception {
        try{
            List<Ingrediente> listaIngredientes = ingredienteRepository.findAll();

            if (!listaIngredientes.isEmpty()) {
                
            List<DTOIngrediente> dtoIngredientesList = new ArrayList<>();

            listaIngredientes.forEach(ingrediente -> {

                if (ingrediente.getFechaHoraBaja() == null) {
                    
                    DTOIngrediente dtoIngrediente = new DTOIngrediente();
                    dtoIngrediente.setDenominacion(ingrediente.getDenominacion());
                    dtoIngrediente.setId(ingrediente.getId());
                    dtoIngrediente.setPrecio(ingrediente.getPrecioCompra());
                    dtoIngrediente.setRubroIngrediente(ingrediente.getRubroIngrediente());
                    dtoIngrediente.setStockActual(ingrediente.getStockActual());
                    dtoIngrediente.setStockMinimo(ingrediente.getStockMinimo());
                    dtoIngrediente.setUrlImagen(ingrediente.getUrlImagen());
                    dtoIngrediente.setUnidadMedida(ingrediente.getUnidadMedida());

                    dtoIngredientesList.add(dtoIngrediente);
                }

            });

                return dtoIngredientesList;

            } else {

                throw new Error("No hay productos que mostrar");

            }

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String deleteIngrediente(Long id) throws Exception {
        try{
            Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

            if (ingredienteOptional.isPresent()) {
                Ingrediente ingrediente = ingredienteOptional.get();
                ingrediente.setFechaHoraBaja(new Date());

                ingredienteRepository.save(ingrediente);

                return "Ingrediente eliminado";

            } else {
                throw new Error("Este producto no existe");
            }

        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
