package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.services.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    @MockBean
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testSearchString() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setPassword("reactionando.utn@gmail.com");
        usuario1.setEmail("react_utn");
        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario1);
        when(usuarioService.iniciarSesion("reactionando.utn@gmail.com","react_utn")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/usuario/login")
                        .param("filtro", "reactionando.utn@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email", is("reactionando.utn@gmail.com")))
                .andExpect(jsonPath("$[0].password", is("react_utn")));

    }
}