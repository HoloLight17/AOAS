package ru.ithub.aoas.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import ru.ithub.aoas.domain.entity.Client;
import ru.ithub.aoas.payload.response.ClientDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientDto toDto(Client entity);
    List<ClientDto> toDto(List<Client> entities);

    Client toEntity(ClientDto dto);

    void update(ClientDto dto, @MappingTarget Client entity);
}
