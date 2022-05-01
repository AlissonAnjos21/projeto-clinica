package com.project.projetoclinica.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Consulta {
    private long id;
    private String medico;
    private String paciente;
    private String data;
    private String hora;
    private float valor;
    private String formaPagamento;
}
