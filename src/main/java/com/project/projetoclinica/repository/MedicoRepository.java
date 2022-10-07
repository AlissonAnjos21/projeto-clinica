package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByNome(String nome);
    List<Medico> findByCpf(String cpf);
}
