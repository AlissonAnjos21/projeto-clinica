package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    public List<Administrador> listarTudo() {
        return List.of(new Administrador(1, "Adm1", "123"), new Administrador(2, "Adm2", "456"));

    }
}
