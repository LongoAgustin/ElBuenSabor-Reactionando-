package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ProductoCocina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductoCocinaRepository extends BaseRepository<ProductoCocina, Long>{

}
