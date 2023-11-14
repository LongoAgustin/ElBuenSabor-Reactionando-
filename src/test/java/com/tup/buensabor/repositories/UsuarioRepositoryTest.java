package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Usuario.Usuario;
import com.tup.buensabor.repositories.UsuarioRepository.UsuarioRepository;
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

        Usuario usuario = new Usuario();
        usuario.setEmail("reactionando.utn@gmail.com");
        usuario.setPassword("react_utn");

        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        entityManager.persist(usuario);
        entityManager.flush();

        assertEquals(listaEnviada, usuarioRepository.iniciarSesion("reactionando.utn@gmail.com","react_utn"));
    }



}