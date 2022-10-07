package com.project.projetoclinica.mapper;

import com.project.projetoclinica.domain.Paciente;
import com.project.projetoclinica.requests.paciente.PacientePostRequestBody;
import com.project.projetoclinica.requests.paciente.PacientePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PacienteMapper {
    public static final PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    public abstract Paciente toPaciente(PacientePostRequestBody pacientePostRequestBody);
    public abstract Paciente toPaciente(PacientePutRequestBody pacientePutRequestBody);

}
