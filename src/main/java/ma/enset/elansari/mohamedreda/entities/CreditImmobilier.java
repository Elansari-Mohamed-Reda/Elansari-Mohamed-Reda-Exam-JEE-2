package ma.enset.elansari.mohamedreda.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("IMMOBILIER")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CreditImmobilier extends Credit {

    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
}