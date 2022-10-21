package com.project.projetoclinica.controller;


import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.requests.consulta.ConsultaPostRequestBody;
import com.project.projetoclinica.requests.consulta.ConsultaPutRequestBody;
import com.project.projetoclinica.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> listAll() {
        return ResponseEntity.ok(consultaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findById(@PathVariable long id) {
        return ResponseEntity.ok(consultaService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Consulta>> findByDataIdPacienteAndIdMedico(@RequestParam(required = false) String data, @RequestParam(required = false) Long idPaciente, @RequestParam(required = false) Long idMedico) {
        if(data != null) {
            return ResponseEntity.ok(consultaService.findByData(data));
        }else if(idPaciente != null) {
            return ResponseEntity.ok(consultaService.findByIdPaciente(idPaciente ));
        }else{
            return ResponseEntity.ok(consultaService.findByIdMedico(idMedico));
        }
    }

//    @GetMapping("/find")
//    public ResponseEntity<List<Consulta>> findByIdPaciente(@RequestParam long idPaciente) {
//        return ResponseEntity.ok(consultaService.findByIdPaciente(idPaciente ));
//    }
//
//    @GetMapping("/find")
//    public ResponseEntity<List<Consulta>> findByIdMedico(@RequestParam long idMedico) {
//        return ResponseEntity.ok(consultaService.findByIdMedico(idMedico));
//    }

    @PostMapping
    public ResponseEntity<Consulta> save(@RequestBody @Valid ConsultaPostRequestBody consultaPostRequestBody) {
        return new ResponseEntity<>(consultaService.save(consultaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        consultaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid ConsultaPutRequestBody consultaPutRequestBody) {
        consultaService.replace(consultaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
