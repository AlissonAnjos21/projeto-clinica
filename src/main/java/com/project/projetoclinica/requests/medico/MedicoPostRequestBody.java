package com.project.projetoclinica.requests.medico;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MedicoPostRequestBody {
    @NotEmpty(message = "O campo nome está vazio")
    private String nome;

    @NotEmpty(message = "O campo cpf está vazio")
    private String cpf;

    @NotEmpty(message = "O campo cnpj está vazio")
    private String cnpj;

    @NotEmpty(message = "O campo crm está vazio")
    private String crm;

    @NotEmpty(message = "O campo dataNascimento está vazio")
    private String dataNascimento;

    @NotEmpty(message = "O campo endereco está vazio")
    private String endereco;

    @NotEmpty(message = "O campo email está vazio")
    private String email;

    @NotEmpty(message = "O campo telefone está vazio")
    private String telefone;

    @NotEmpty(message = "O campo tipoContrato está vazio")
    private String tipoContrato;

    @NotEmpty(message = "O campo especialidade está vazio")
    private String especialidade;
}
