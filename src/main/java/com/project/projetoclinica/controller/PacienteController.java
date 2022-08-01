package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Paciente;
import com.project.projetoclinica.requests.paciente.PacientePostRequestBody;
import com.project.projetoclinica.requests.paciente.PacientePutRequestBody;
import com.project.projetoclinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listAll() {
        return ResponseEntity.ok(pacienteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable long id) {
        return ResponseEntity.ok(pacienteService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody PacientePostRequestBody pacientePostRequestBody) {
        return new ResponseEntity<>(pacienteService.save(pacientePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        pacienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PacientePutRequestBody pacientePutRequestBody) {
        pacienteService.replace(pacientePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
