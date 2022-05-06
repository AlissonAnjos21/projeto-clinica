package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Paciente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository {
    public List<Paciente> list();
    public Paciente findById();
}
