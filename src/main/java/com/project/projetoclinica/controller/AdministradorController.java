package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("administrador")
public class AdministradorController {

    @GetMapping("lista")
    public List<Administrador> lista() {
        return List.of(new Administrador(1, "Adm1", "123"));
    }
}
