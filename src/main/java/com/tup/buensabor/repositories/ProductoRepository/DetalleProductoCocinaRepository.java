package com.tup.buensabor.repositories.ProductoRepository;

import com.tup.buensabor.entities.Producto.DetalleProductoCocina;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoCocinaRepository extends BaseRepository<DetalleProductoCocina, Long> {
}
