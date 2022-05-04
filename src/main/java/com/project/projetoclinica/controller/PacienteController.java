package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Paciente;
import com.project.projetoclinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> list() {
        return ResponseEntity.ok(pacienteService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

}
