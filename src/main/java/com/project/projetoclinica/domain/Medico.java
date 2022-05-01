package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Medico {
    private long id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String crm;
    private String dataNascimento;
    private String endereco;
    private String email;
    private String numeroTelefone;
    private String tipoContrato;
    private String especialidade;
}
