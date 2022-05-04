package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteService {

    private List<Paciente> pacientes = List.of(new Paciente(
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
                    new String[]{"camarão", "amendoim"},
                    new String[]{"diabetes", "alzheimer", "osteoporose"}),
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
                    new String[]{"água", "ovos"},
                    new String[]{"câncer", "asma"}));

    public List<Paciente> list() {
        return pacientes;
    }

    public Paciente findById(long id) {
        return pacientes.stream().filter(pacientes -> pacientes.getId().equals(id)).findFirst().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente não encontrado."));
    }

}
