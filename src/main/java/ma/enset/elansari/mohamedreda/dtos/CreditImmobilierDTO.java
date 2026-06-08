package ma.enset.elansari.mohamedreda.dtos;

import lombok.*;
import ma.enset.elansari.mohamedreda.entities.TypeBien;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}