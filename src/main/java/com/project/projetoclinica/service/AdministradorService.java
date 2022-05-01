package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdministradorService {
    private List<Administrador> administradores = List.of(new Administrador(1L, "Adm1", "123"), new Administrador(2L, "Adm2", "456"));

    public List<Administrador> listarTudo() {
        return administradores;
    }

    public Administrador selecionarPorId(long id) {
        return administradores.stream().filter(administrador -> administrador.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Administrador não encontrado."));
    }

}
