package com.project.projetoclinica.requests.paciente;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Data
public class PacientePutRequestBody {
    private Long id;

    @NotEmpty(message = "O campo nome está vazio")
    private String nome;

    @NotEmpty(message = "O campo cpf está vazio")
    private String cpf;

    @NotEmpty(message = "O campo email está vazio")
    private String email;

    @NotEmpty(message = "O campo dataNascimento está vazio")
    private String dataNascimento;

    @NotEmpty(message = "O campo telefone está vazio")
    private String telefone;

    private String telefoneFamiliar;
    private String ocupacao;

    @NotEmpty(message = "O campo endereco está vazio")
    private String endereco;

    private String planoSaude;
    private ArrayList<String> alergias;
    private ArrayList<String> doencas;
}
