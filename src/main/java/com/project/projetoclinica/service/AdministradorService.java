package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AdministradorService {
    private static List<Administrador> administradores;
    static {
        administradores = new ArrayList<>(List.of(new Administrador(
                        1L,
                        "Adm1",
                        "123"),
                new Administrador(
                        2L,
                        "Adm2",
                        "456")));
    }

    public List<Administrador> list() {
        return administradores;
    }

    public Administrador findById(long id) {
        return administradores.stream().filter(administrador -> administrador.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Administrador não encontrado."));
    }

    public Administrador save(Administrador administrador) {
        administrador.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        administradores.add(administrador);
        return administrador;

    }

    public void delete(long id) {
        administradores.remove(findById(id));
    }

    public void replace(Administrador administrador) {
        delete(administrador.getId());
        administradores.add(administrador);

    }
}
