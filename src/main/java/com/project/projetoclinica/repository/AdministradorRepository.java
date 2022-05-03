package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository {
    List<Administrador> list();
    Administrador findById();

}
