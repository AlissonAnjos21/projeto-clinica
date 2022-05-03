package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Medico;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository {
    List<Medico> list();
    Medico findById();

}
