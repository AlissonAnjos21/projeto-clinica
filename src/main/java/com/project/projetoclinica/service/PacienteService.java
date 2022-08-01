package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Paciente;
import com.project.projetoclinica.repository.PacienteRepository;
import com.project.projetoclinica.requests.paciente.PacientePostRequestBody;
import com.project.projetoclinica.requests.paciente.PacientePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public List<Paciente> listAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findByIdOrThrowBadRequestException(long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente não encontrado."));
    }

    public Paciente save(PacientePostRequestBody pacientePostRequestBody) {
        Paciente paciente = Paciente.builder()
                .nome(pacientePostRequestBody.getNome())
                .cpf(pacientePostRequestBody.getCpf())
                .email(pacientePostRequestBody.getEmail())
                .dataNascimento(pacientePostRequestBody.getDataNascimento())
                .telefone(pacientePostRequestBody.getTelefone())
                .telefoneFamiliar(pacientePostRequestBody.getTelefoneFamiliar())
                .ocupacao(pacientePostRequestBody.getOcupacao())
                .endereco(pacientePostRequestBody.getEndereco())
                .planoSaude(pacientePostRequestBody.getPlanoSaude())
                .alergias(pacientePostRequestBody.getAlergias())
                .doencas(pacientePostRequestBody.getDoencas())
                .build();

        return pacienteRepository.save(paciente);
    }

    public void delete(long id) {
        pacienteRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(PacientePutRequestBody pacientePutRequestBody) {
        Paciente savedPaciente = findByIdOrThrowBadRequestException(pacientePutRequestBody.getId());
        Paciente paciente = Paciente.builder()
                .id(savedPaciente.getId())
                .nome(pacientePutRequestBody.getNome())
                .cpf(pacientePutRequestBody.getCpf())
                .email(pacientePutRequestBody.getEmail())
                .dataNascimento(pacientePutRequestBody.getDataNascimento())
                .telefone(pacientePutRequestBody.getTelefone())
                .telefoneFamiliar(pacientePutRequestBody.getTelefoneFamiliar())
                .ocupacao(pacientePutRequestBody.getOcupacao())
                .endereco(pacientePutRequestBody.getEndereco())
                .planoSaude(pacientePutRequestBody.getPlanoSaude())
                .alergias(pacientePutRequestBody.getAlergias())
                .doencas(pacientePutRequestBody.getDoencas())
                .build();

        pacienteRepository.save(paciente);
    }

}
