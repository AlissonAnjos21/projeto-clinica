package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.exception.BadRequestException;
import com.project.projetoclinica.mapper.ConsultaMapper;
import com.project.projetoclinica.repository.ConsultaRepository;
import com.project.projetoclinica.requests.consulta.ConsultaPostRequestBody;
import com.project.projetoclinica.requests.consulta.ConsultaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public List<Consulta> listAll() {
        return consultaRepository.findAll();
    }

    public Consulta findByIdOrThrowBadRequestException(long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Consulta não encontrada."));
    }

    public List<Consulta> findByIdPaciente(long id) {
        return  consultaRepository.findByIdPaciente(id);
    }

    public List<Consulta> findByIdMedico(long id) {
        return  consultaRepository.findByIdMedico(id);
    }

    public List<Consulta> findByData (String data) {
        return consultaRepository.findByData(data);
    }

    @Transactional
    public Consulta save(ConsultaPostRequestBody consultaPostRequestBody){
        /*
            Consulta consulta = Consulta.builder()
                    .idMedico(consultaPostRequestBody.getIdMedico())
                    .idPaciente(consultaPostRequestBody.getIdPaciente())
                    .data(consultaPostRequestBody.getData())
                    .hora(consultaPostRequestBody.getHora())
                    .valor(consultaPostRequestBody.getValor())
                    .formaPagamento(consultaPostRequestBody.getFormaPagamento())
                    .build();
            // Antes de usar o Mapper
         */

        return consultaRepository.save(ConsultaMapper.INSTANCE.toConsulta(consultaPostRequestBody));

    }

    public void delete(long id) {
        consultaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ConsultaPutRequestBody consultaPutRequestBody) {
        Consulta savedConsulta = findByIdOrThrowBadRequestException(consultaPutRequestBody.getId());
        Consulta consulta = ConsultaMapper.INSTANCE.toConsulta(consultaPutRequestBody);
        consulta.setId(savedConsulta.getId());

        /*
            Consulta consulta = Consulta.builder()
                    .id(savedConsulta.getId())
                    .idMedico(consultaPutRequestBody.getIdMedico())
                    .idPaciente(consultaPutRequestBody.getIdPaciente())
                    .data(consultaPutRequestBody.getData())
                    .hora(consultaPutRequestBody.getHora())
                    .valor(consultaPutRequestBody.getValor())
                    .formaPagamento(consultaPutRequestBody.getFormaPagamento())
                    .build();
            // Antes de usar o Mapper
         */

        consultaRepository.save(consulta);
    }

}
