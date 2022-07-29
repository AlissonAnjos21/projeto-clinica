package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
//@Entity
//@NoArgsConstructor
public class Consulta {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Medico medico;
    private Paciente paciente;
    private String data;
    private String hora;
    private float valor;
    private String formaPagamento;
}
