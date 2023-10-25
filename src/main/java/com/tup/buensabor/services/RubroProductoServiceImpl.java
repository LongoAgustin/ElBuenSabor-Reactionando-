package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroProducto;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService {

    @Autowired
    protected RubroProductoRepository rubroProductoRepository;

    public RubroProductoServiceImpl(BaseRepository<RubroProducto,Long> baseRepository, RubroProductoRepository rubroArticuloIngredienteRepository) {
        super(baseRepository);
        this.rubroProductoRepository = rubroArticuloIngredienteRepository;
    }

    @Override
    public RubroProducto newRubroProducto(RubroProducto rubroProducto) throws Exception {
        try{
            List<RubroProducto> rubrosProductosEncontrados = rubroProductoRepository.verificarRubroProducto(rubroProducto.getDenominacion());
            if (rubrosProductosEncontrados.isEmpty()){
                rubroProductoRepository.save(rubroProducto);
                return rubroProducto;
            }else {
                throw new Exception("Este rubro ya existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public RubroProducto updateRubroProducto(Long id, RubroProducto nuevosDatos) throws Exception {
        try{
            Optional<RubroProducto> rubroProductoOptional = rubroProductoRepository.findById(id);

            if(rubroProductoOptional.isPresent()){
                RubroProducto rubroProducto = rubroProductoOptional.get();

                // Verifica y actualiza campos opcionales
                if (nuevosDatos.getDenominacion() != null) {
                    rubroProducto.setDenominacion(nuevosDatos.getDenominacion());
                    rubroProducto.setFechaHoraModificacion(new Date());
                }


                // Guarda los cambios en la base de datos
                rubroProductoRepository.save(rubroProducto);

                return rubroProducto;
            }else {
                throw new Exception("Ese Rubro no esta disponible");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
