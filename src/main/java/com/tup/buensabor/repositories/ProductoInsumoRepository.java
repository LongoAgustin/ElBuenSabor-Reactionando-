package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ProductoCocina;
import com.tup.buensabor.entities.ProductoInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductoInsumoRepository extends BaseRepository<ProductoInsumo, Long>{

}
