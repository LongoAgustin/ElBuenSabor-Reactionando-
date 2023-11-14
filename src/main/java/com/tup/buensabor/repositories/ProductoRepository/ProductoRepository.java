package com.tup.buensabor.repositories.ProductoRepository;

import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {

    @Query(value = "SELECT p FROM Producto p WHERE p.denominacion = :denom_ingresada")
    List<Producto> buscarProducto(@Param("denom_ingresada") String denominacion);

    //HISTORIA 9

    @Query(value= "SELECT * FROM producto WHERE denominacion LIKE %:filtro%",
    nativeQuery = true
    )
    List<Producto> searchDenominacion(@Param("filtro") String filtro);

}
