package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.requests.medico.MedicoPostRequestBody;
import com.project.projetoclinica.requests.medico.MedicoPutRequestBody;
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
    public ResponseEntity<List<Medico>> listAll() {
        return ResponseEntity.ok(medicoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable long id) {
        return ResponseEntity.ok(medicoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody MedicoPostRequestBody medicoPostRequestBody) {
        return new ResponseEntity<>(medicoService.save(medicoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        medicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody MedicoPutRequestBody medicoPutRequestBody) {
        medicoService.replace(medicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
