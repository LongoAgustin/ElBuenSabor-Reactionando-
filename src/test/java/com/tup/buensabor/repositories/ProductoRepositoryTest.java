package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductoRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void testSearchString(){
        Producto producto1 = new Producto();
        producto1.setDenominacion("Hamburguesa de carne doble con queso cheddar");
        List<Producto> listaEnviada = new ArrayList<>();
        listaEnviada.add(producto1);
        entityManager.persist(producto1);
        entityManager.flush();

        assertEquals(listaEnviada, productoRepository.searchDenominacion("Hamburguesa de carne doble con queso cheddar"));
    }

}
