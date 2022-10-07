package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByNome(String nome);
    List<Paciente> findByCpf(String cpf);

}
