package com.project.projetoclinica.repository;

import com.project.projetoclinica.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    List<Administrador> findByUsuario(String usuario); // findBy(Nome do atributo)

}
