package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Paciente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    private String telefone;
    private String telefoneFamiliar;
    private String ocupacao;
    private String endereco;
    private String planoSaude;
    private ArrayList<String> alergias;
    private ArrayList<String> doencas;
}
