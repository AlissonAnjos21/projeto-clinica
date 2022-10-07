package com.project.projetoclinica.requests.administrador;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdministradorPostRequestBody {
    @NotEmpty(message = "O campo usuario está vazio")
    private String usuario;

    @NotEmpty(message = "O campo senha está vazio")
    private String senha;
}
