package com.project.projetoclinica.service;

import com.project.projetoclinica.domain.Medico;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicoService {

    private List<Medico> medicos = List.of(new Medico(
            1L, "Raquel", "###.###.###-##", " XX.XXX.XXX/0001-XX", "CRM/BA 123456",
            "05/12/2003", "Rua Muito Ruim", "emaildaraquel@emails.com",
            "###########", "Público", "Infectologia"), new Medico(
                    2L, "Caio", "###.###.###-##", " XX.XXX.XXX/0001-XX", "CRM/BA 456789",
            "29/03/2004", "Rua Muito Boa", "emaildocaio@emails.com",
            "###########", "Privado", "Psiquiatria"
    ));

    public List<Medico> listar() {
        return medicos;
    }

    public Medico selecionarPorId(long id) {
        return medicos.stream().filter(medico -> medico.getId().equals(id)).findFirst().orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico não encontrado."));
    }

}
