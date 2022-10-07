package com.project.projetoclinica.mapper;

import com.project.projetoclinica.domain.Administrador;
import com.project.projetoclinica.requests.administrador.AdministradorPostRequestBody;
import com.project.projetoclinica.requests.administrador.AdministradorPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AdministradorMapper {
    public static final AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);

    public abstract Administrador toAdministrador(AdministradorPostRequestBody administradorPostRequestBody);
    public abstract Administrador toAdministrador(AdministradorPutRequestBody administradorPutRequestBody);

}
