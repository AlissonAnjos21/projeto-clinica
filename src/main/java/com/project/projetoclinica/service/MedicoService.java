package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Medico;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MedicoService {

    private static List<Medico> medicos;
    static {
        medicos = new ArrayList<>(List.of(new Medico(
                        1L,
                        "Raquel",
                        "###.###.###-##",
                        "XX.XXX.XXX/0001-XX",
                        "CRM/BA 123456",
                        "05/12/2003",
                        "Rua Muito Ruim",
                        "emaildaraquel@emails.com",
                        "###########",
                        "Público",
                        "Psiquiatria"),
                new Medico(
                        2L,
                        "Caio",
                        "###.###.###-##",
                        "XX.XXX.XXX/0001-XX",
                        "CRM/BA 456789",
                        "29/03/2004",
                        "Rua Muito Boa",
                        "emaildocaio@emails.com",
                        "###########",
                        "Privado",
                        "Infectologia"
                )));
    }

    public List<Medico> list() {
        return medicos;
    }

    public Medico findById(long id) {
        return medicos.stream().filter(medico -> medico.getId().equals(id)).findFirst().orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico não encontrado."));
    }

    public Medico save(Medico medico) {
        medico.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        medicos.add(medico);
        return medico;
    }

}
