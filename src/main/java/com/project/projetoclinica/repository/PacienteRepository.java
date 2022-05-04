package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Paciente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository {
    List<Paciente> list();
    Paciente findById();
}
