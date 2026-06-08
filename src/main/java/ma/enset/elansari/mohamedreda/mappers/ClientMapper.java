package ma.enset.elansari.mohamedreda.mappers;

import ma.enset.elansari.mohamedreda.dtos.ClientDTO;
import ma.enset.elansari.mohamedreda.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
}
