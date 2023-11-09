package com.tup.buensabor.controllers;

import com.tup.buensabor.controllers.UsuarioControllers.UsuarioController;
import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.services.UsuarioServices.UsuarioServiceImpl;
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

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {
    @MockBean
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testSearchString() throws Exception {

        Usuario usuario = new Usuario();
        usuario.setPassword("reactionando.utn@gmail.com");
        usuario.setEmail("react_utn");

        when(usuarioService.iniciarSesion("reactionando.utn@gmail.com","react_utn")).thenReturn(usuario);

        mockMvc.perform(get("/api/v1/usuario/login")
                        .param("email", "reactionando.utn@gmail.com")
                        .param("password", "react_utn")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email", is("reactionando.utn@gmail.com")))
                .andExpect(jsonPath("$[0].password", is("react_utn")));
    }
}