package ma.enset.elansari.mohamedreda.mappers;

import ma.enset.elansari.mohamedreda.dtos.RemboursementDTO;
import ma.enset.elansari.mohamedreda.entities.Remboursement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RemboursementMapper {
    @Mapping(source = "credit.id", target = "creditId")
    RemboursementDTO toDTO(Remboursement remboursement);

    @Mapping(target = "credit", ignore = true)
    Remboursement toEntity(RemboursementDTO remboursementDTO);
}
