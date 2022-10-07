package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.exception.BadRequestException;
import com.project.projetoclinica.mapper.MedicoMapper;
import com.project.projetoclinica.repository.MedicoRepository;
import com.project.projetoclinica.requests.medico.MedicoPostRequestBody;
import com.project.projetoclinica.requests.medico.MedicoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public List<Medico> listAll() {
        return medicoRepository.findAll();
    }

    public List<Medico> findByNome(String nome) {
        return medicoRepository.findByNome(nome);
    }

    public Medico findByIdOrThrowBadRequestException(long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Médico não encontrado."));
    }

    public List<Medico> findByCpf(String cpf) {
        return medicoRepository.findByCpf(cpf);
    }

    @Transactional
    public Medico save(MedicoPostRequestBody medicoPostRequestBody) {
        /*
            Medico medico = Medico.builder()
                    .nome(medicoPostRequestBody.getNome())
                    .cpf(medicoPostRequestBody.getCpf())
                    .cnpj(medicoPostRequestBody.getCnpj())
                    .crm(medicoPostRequestBody.getCrm())
                    .dataNascimento(medicoPostRequestBody.getDataNascimento())
                    .endereco(medicoPostRequestBody.getEndereco())
                    .email(medicoPostRequestBody.getEmail())
                    .telefone(medicoPostRequestBody.getTelefone())
                    .tipoContrato(medicoPostRequestBody.getTipoContrato())
                    .especialidade(medicoPostRequestBody.getEspecialidade())
                    .build();
            // Antes de usar o Mapper
         */

        return medicoRepository.save(MedicoMapper.INSTANCE.toMedico(medicoPostRequestBody));
    }

    public void delete(long id) {
        medicoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(MedicoPutRequestBody medicoPutRequestBody) {
        Medico savedMedico = findByIdOrThrowBadRequestException(medicoPutRequestBody.getId());
        Medico medico = MedicoMapper.INSTANCE.toMedico(medicoPutRequestBody);
        medico.setId(savedMedico.getId());

        /*
            Medico medico = Medico.builder()
                    .id(savedMedico.getId())
                    .nome(medicoPutRequestBody.getNome())
                    .cpf(medicoPutRequestBody.getCpf())
                    .cnpj(medicoPutRequestBody.getCnpj())
                    .crm(medicoPutRequestBody.getCrm())
                    .dataNascimento(medicoPutRequestBody.getDataNascimento())
                    .endereco(medicoPutRequestBody.getEndereco())
                    .email(medicoPutRequestBody.getEmail())
                    .telefone(medicoPutRequestBody.getTelefone())
                    .tipoContrato(medicoPutRequestBody.getTipoContrato())
                    .especialidade(medicoPutRequestBody.getEspecialidade())
                    .build();
            // Antes de usar o Mapper
         */

        medicoRepository.save(medico);
    }

}
