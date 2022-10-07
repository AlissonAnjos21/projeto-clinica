package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByIdPaciente(long id);
    List<Consulta> findByIdMedico(long id);
    List<Consulta> findByData(String data);
}
