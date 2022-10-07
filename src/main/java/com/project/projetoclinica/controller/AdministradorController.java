package com.project.projetoclinica.controller;

import com.project.projetoclinica.domain.Administrador;
import com.project.projetoclinica.requests.administrador.AdministradorPostRequestBody;
import com.project.projetoclinica.requests.administrador.AdministradorPutRequestBody;
import com.project.projetoclinica.service.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> listAll() {
        return ResponseEntity.ok(administradorService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> findById(@PathVariable long id) {
        return ResponseEntity.ok(administradorService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Administrador>> findByUsuario(@RequestParam String usuario) {
        return ResponseEntity.ok(administradorService.findByUsuario(usuario));
    }

    @PostMapping
    public ResponseEntity<Administrador> save(@RequestBody @Valid AdministradorPostRequestBody administradorPostRequestBody) {
        return new ResponseEntity<>(administradorService.save(administradorPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        administradorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid AdministradorPutRequestBody administradorPutRequestBody) {
        administradorService.replace(administradorPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
