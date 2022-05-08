package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Consulta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository {
    List<Consulta> list();
    Consulta findById();

}
