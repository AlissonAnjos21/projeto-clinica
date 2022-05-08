package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> list() {
        return ResponseEntity.ok(medicoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable long id) {
        return ResponseEntity.ok(medicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return new ResponseEntity<>(medicoService.save(medico), HttpStatus.CREATED);
    }

}
