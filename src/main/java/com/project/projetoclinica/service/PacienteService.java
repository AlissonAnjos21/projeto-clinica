package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PacienteService {

    private static List<Paciente> pacientes;
    static {
        pacientes = new ArrayList<>(List.of(new Paciente(
                        1L,
                        "Pessoa1",
                        "###.###.###-##",
                        "emaildapessoa1@emails.com",
                        "01/01/2001",
                        "###########",
                        "###########",
                        "Programadora",
                        "Rua das Ruas",
                        "Familiar",
                        new ArrayList<>(List.of("camarão", "amendoim")),
                        new ArrayList<>(List.of("diabetes", "alzheimer", "osteoporose"))),
                new Paciente(
                        2L,
                        "Pessoa2",
                        "###.###.###-##",
                        "emaildapessoa2@emails.com",
                        "01/01/2001",
                        "###########",
                        "###########",
                        "Paleontóloga",
                        "Rua das Sem Saída",
                        "Familiar",
                        new ArrayList<>(List.of("água", "ovos")),
                        new ArrayList<>(List.of("câncer", "asma")))));


    }

    public List<Paciente> list() {
        return pacientes;
    }

    public Paciente findById(long id) {
        return pacientes.stream().filter(pacientes -> pacientes.getId().equals(id)).findFirst().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente não encontrado."));
    }

    public Paciente save(Paciente paciente) {
        paciente.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        pacientes.add(paciente);
        return paciente;
    }
}
