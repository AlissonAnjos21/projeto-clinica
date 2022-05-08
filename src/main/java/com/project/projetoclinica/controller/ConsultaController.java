package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Consulta> save(@RequestBody Consulta consulta) {
        return new ResponseEntity<>(consultaService.save(consulta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        consultaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Consulta consulta) {
        consultaService.replace(consulta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
