package com.project.projetoclinica.mapper;

import com.project.projetoclinica.domain.Consulta;
import com.project.projetoclinica.requests.consulta.ConsultaPostRequestBody;
import com.project.projetoclinica.requests.consulta.ConsultaPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ConsultaMapper {
    public static final ConsultaMapper INSTANCE = Mappers.getMapper(ConsultaMapper.class);

    public abstract Consulta toConsulta(ConsultaPostRequestBody consultaPostRequestBody);
    public abstract Consulta toConsulta(ConsultaPutRequestBody consultaPutRequestBody);

}
