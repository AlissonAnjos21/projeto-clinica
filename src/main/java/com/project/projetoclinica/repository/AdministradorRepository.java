package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository {
    public List<Administrador> list();
    public Administrador findById();

}
