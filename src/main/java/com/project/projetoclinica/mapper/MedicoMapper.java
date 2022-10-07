package com.project.projetoclinica.mapper;

import com.project.projetoclinica.domain.Medico;
import com.project.projetoclinica.requests.medico.MedicoPostRequestBody;
import com.project.projetoclinica.requests.medico.MedicoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MedicoMapper {
    public static final MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    public abstract Medico toMedico(MedicoPostRequestBody medicoPostRequestBody);
    public abstract Medico toMedico(MedicoPutRequestBody medicoPutRequestBody);

}
