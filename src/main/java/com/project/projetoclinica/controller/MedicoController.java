package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.requests.medico.MedicoPostRequestBody;
import com.project.projetoclinica.requests.medico.MedicoPutRequestBody;
import com.project.projetoclinica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/medicos")
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

    @GetMapping("/find")
    public ResponseEntity<List<Medico>> findByNomeAndCpf(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf) {

        if(nome !=null){
            return ResponseEntity.ok(medicoService.findByNome(nome));
        }else{
            return ResponseEntity.ok(medicoService.findByCpf(cpf));
        }

    }

//    @GetMapping("/find")
//    public ResponseEntity<Medico> findByCpf(@RequestParam String cpf) {
//        return ResponseEntity.ok(medicoService.findByCpf(cpf));
//    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody @Valid MedicoPostRequestBody medicoPostRequestBody) {
        return new ResponseEntity<>(medicoService.save(medicoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        medicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid MedicoPutRequestBody medicoPutRequestBody) {
        medicoService.replace(medicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
