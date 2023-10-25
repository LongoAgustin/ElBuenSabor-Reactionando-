package com.tup.buensabor.repositories;

import com.tup.buensabor.DTO.DTOProductoPagPrincipal;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.entities.ProductoCocina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{

    //HISTORIA 9

    @Query(value= "SELECT * FROM producto WHERE denominacion LIKE %:filtro%",
    nativeQuery = true
    )
    List<Producto> searchDenominacion(@Param("filtro") String filtro);



}
