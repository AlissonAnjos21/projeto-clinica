package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Consulta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    static MedicoService medicoService = new MedicoService();
    static PacienteService pacienteService = new PacienteService();

    private static List<Consulta> consultas;
    static {
        consultas = new ArrayList<>(List.of(new Consulta(
                1L,
                medicoService.findById(1),
                pacienteService.findById(1),
                "03/05/2022",
                "16:30:00",
                500,
                "Dinheiro"
        ), new Consulta(
                2L,
                medicoService.findById(2),
                pacienteService.findById(2),
                "04/05/2022",
                "17:00:00",
                1000,
                "Dinheiro"
        )));
    }

    public List<Consulta> list() {
        return consultas;
    }

    public Consulta findById(long id) {
        return consultas.stream().filter(consultas -> consultas.getId().equals(id)).findFirst().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Consulta não encontrada."));
    }

    public Consulta save(Consulta consulta) {
        consulta.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        consultas.add(consulta);
        return consulta;
    }

}
