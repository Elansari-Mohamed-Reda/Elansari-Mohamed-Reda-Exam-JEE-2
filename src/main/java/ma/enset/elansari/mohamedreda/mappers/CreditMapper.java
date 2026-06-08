package ma.enset.elansari.mohamedreda.mappers;

import ma.enset.elansari.mohamedreda.dtos.*;
import ma.enset.elansari.mohamedreda.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(source = "client.id", target = "clientId")
    CreditDTO toDTO(Credit credit);

    @Mapping(source = "clientId", target = "client.id")
    CreditPersonnel toPersonnelEntity(CreditPersonnelDTO dto);

    @Mapping(source = "clientId", target = "client.id")
    CreditImmobilier toImmobilierEntity(CreditImmobilierDTO dto);

    @Mapping(source = "clientId", target = "client.id")
    CreditProfessionnel toProfessionnelEntity(CreditProfessionnelDTO dto);
}
