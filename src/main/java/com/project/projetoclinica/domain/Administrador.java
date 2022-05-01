package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Administrador {
    private Long id;
    private String usuario;
    private String senha;
}
