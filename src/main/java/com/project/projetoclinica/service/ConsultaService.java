package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    private List<Consulta> consultas = List.of(new Consulta(
            1L,
            medicoService.findById(1L),
            pacienteService.findById(1L),
            "03/05/2022",
            "16:30:00",
            500,
            "Dinheiro"
    ), new Consulta(
            2L,
            medicoService.findById(2L),
            pacienteService.findById(2L),
            "04/05/2022",
            "17:00:00",
            1000,
            "Dinheiro"
    ));

    public List<Consulta> list() {
        return consultas;
    }

    public Consulta findById(long id) {
        return consultas.stream().filter(consultas -> consultas.getId().equals(id)).findFirst().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Consulta não encontrada."));
    }

}
