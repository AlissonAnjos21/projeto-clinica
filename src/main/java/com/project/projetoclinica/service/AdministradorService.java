package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Administrador;
import com.project.projetoclinica.exception.BadRequestException;
import com.project.projetoclinica.mapper.AdministradorMapper;
import com.project.projetoclinica.repository.AdministradorRepository;
import com.project.projetoclinica.requests.administrador.AdministradorPostRequestBody;
import com.project.projetoclinica.requests.administrador.AdministradorPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public List<Administrador> listAll() {
        return administradorRepository.findAll();
    }

    public List<Administrador> findByUsuario(String usuario) {
        return administradorRepository.findByUsuario(usuario);
    }

    public Administrador findByIdOrThrowBadRequestException(long id) {
        return administradorRepository.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Administrador não encontrado."));
    }

    @Transactional
    public Administrador save(AdministradorPostRequestBody administradorPostRequestBody) {
        /*
            Administrador administrador = Administrador.builder()
                    .usuario(administradorPostRequestBody.getUsuario())
                    .senha(administradorPostRequestBody.getSenha())
                    .build();
            // Antes de usar o Mapper
         */
        return administradorRepository.save(AdministradorMapper.INSTANCE.toAdministrador(administradorPostRequestBody));

    }

    public void delete(long id) {
        administradorRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AdministradorPutRequestBody administradorPutRequestBody) {
        Administrador savedAdministrador = findByIdOrThrowBadRequestException(administradorPutRequestBody.getId());  // Se certifica de que esse administrador realmente existe, caso contrário lança uma exceção
        Administrador administrador = AdministradorMapper.INSTANCE.toAdministrador(administradorPutRequestBody);
        administrador.setId(savedAdministrador.getId());
        /*
            Administrador administrador = Administrador.builder()
                    .id(savedAdministrador.getId())
                    .usuario(administradorPutRequestBody.getUsuario())
                    .senha(administradorPutRequestBody.getSenha())
                    .build();
            // Antes de usar o Mapper
         */

        administradorRepository.save(administrador);
    }
}
