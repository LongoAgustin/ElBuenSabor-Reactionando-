package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.services.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(PersonaController.class)
public class ProductoControllerTest {
    @MockBean
    private ProductoServiceImpl productoService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testSearchString() throws Exception {
        Producto producto1 = new Producto();
        producto1.setDenominacion("Hamburguesa de carne con queso cheddar");
        List<Producto> listaEnviada = new ArrayList<>();
        listaEnviada.add(producto1);
        when(productoService.searchDenominacion("Hamburguesa de carne con queso cheddar")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/producto/searchDenominacion")
                        .param("filtro", "Hamburguesa de carne con queso cheddar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].denominacion", is("Hamburguesa de carne con queso cheddar")));
    }

}
