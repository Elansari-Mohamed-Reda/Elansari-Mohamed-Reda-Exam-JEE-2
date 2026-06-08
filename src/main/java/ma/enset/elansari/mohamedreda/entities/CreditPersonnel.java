package ma.enset.elansari.mohamedreda.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PERSONNEL")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CreditPersonnel extends Credit {
    private String motif;
}