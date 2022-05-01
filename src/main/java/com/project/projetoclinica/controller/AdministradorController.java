package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Administrador;
import com.project.projetoclinica.service.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping
    public List<Administrador> listar() {
        return administradorService.listarTudo();
    }
}
