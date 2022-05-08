package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Consulta {
    private Long id;
    private Medico medico;
    private Paciente paciente;
    private String data;
    private String hora;
    private float valor;
    private String formaPagamento;
}
