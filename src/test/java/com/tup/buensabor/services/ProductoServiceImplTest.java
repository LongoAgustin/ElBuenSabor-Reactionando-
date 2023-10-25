package com.tup.buensabor.services;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.repositories.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductoServiceImplTest {
    @MockBean
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoServiceImpl productoService;

    @Test
    void testSearchString() throws Exception {
        Producto producto1 = new Producto();
        producto1.setDenominacion("Hamburgesa de carne con queso cheddar");

        List<Producto> listaEnviada = new ArrayList<>();
        listaEnviada.add(producto1);

        when(productoRepository.searchDenominacion("Hamburgesa de carne con queso cheddar")).thenReturn(listaEnviada);
        assertEquals(listaEnviada, productoService.searchDenominacion("Hamburgesa de carne con queso cheddar"));


    }
}