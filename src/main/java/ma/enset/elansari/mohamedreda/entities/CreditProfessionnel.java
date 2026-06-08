package ma.enset.elansari.mohamedreda.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PROFESSIONNEL")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}