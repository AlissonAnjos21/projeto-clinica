package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Administrador;
import com.project.projetoclinica.service.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> list() {
        return ResponseEntity.ok(administradorService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> findById(@PathVariable long id) {
        return ResponseEntity.ok(administradorService.findById(id));
    }
}
