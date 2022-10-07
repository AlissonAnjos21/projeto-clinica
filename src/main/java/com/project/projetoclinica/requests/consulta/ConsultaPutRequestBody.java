package com.project.projetoclinica.requests.consulta;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ConsultaPutRequestBody {
    private Long id;
    @NotNull(message = "O campo idMedico está vazio")
    private Long idMedico;

    @NotNull(message = "O campo idPaciente está vazio")
    private Long idPaciente;

    @NotEmpty(message = "O campo data está vazio")
    private String data;

    @NotEmpty(message = "O campo hora está vazio")
    private String hora;

    @NotNull(message = "O campo valor está vazio")
    private float valor;

    @NotEmpty(message = "O campo formaPagamento está vazio")
    private String formaPagamento;
}
