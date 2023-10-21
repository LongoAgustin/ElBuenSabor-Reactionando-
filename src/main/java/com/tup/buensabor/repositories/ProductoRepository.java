package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
}
