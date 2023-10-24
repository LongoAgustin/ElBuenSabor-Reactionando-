package com.tup.buensabor.services;

import com.tup.buensabor.entities.Usuario;
import com.tup.buensabor.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServiceImplTest {
    @MockBean
    private UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioServiceImpl usuarioService;
    @Test
    void testSearchString() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setEmail("reactionando.utn@gmail.com");
        usuario1.setPassword("react_utn");

        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario1);

        when(usuarioRepository.iniciarSesion("reactionando.utn@gmail.com","react_utn")).thenReturn(listaEnviada);
        assertEquals(listaEnviada, usuarioService.iniciarSesion("reactionando.utn@gmail.com","react_utn"));


    }
}