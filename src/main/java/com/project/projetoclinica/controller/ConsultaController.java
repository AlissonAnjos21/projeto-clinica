package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> list() {
        return ResponseEntity.ok(consultaService.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findById(@PathVariable long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

}
