package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
