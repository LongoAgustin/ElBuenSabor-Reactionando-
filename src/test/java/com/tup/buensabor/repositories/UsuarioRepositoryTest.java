package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UsuarioRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testSearchString(){
        Usuario usuario1 = new Usuario();
        usuario1.setEmail("reactionando.utn@gmail.com");
        usuario1.setPassword("react_utn");
        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario1);
        entityManager.persist(usuario1);
        entityManager.flush();

        assertEquals(listaEnviada, usuarioRepository.verificarEmail("reactionando.utn@gmail.com"));
        assertEquals(listaEnviada, usuarioRepository.iniciarSesion("reactionando.utn@gmail.com","react_utn"));
    }



}