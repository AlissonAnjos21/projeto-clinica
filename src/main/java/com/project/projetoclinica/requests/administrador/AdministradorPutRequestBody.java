package com.project.projetoclinica.requests.administrador;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdministradorPutRequestBody {
    private Long id;
    @NotEmpty(message = "O campo usuario está vazio")
    private String usuario;
    @NotEmpty(message = "O campo senha está vazio")
    private String senha;
}
