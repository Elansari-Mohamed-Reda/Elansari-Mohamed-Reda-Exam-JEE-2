package ma.enset.elansari.mohamedreda.dtos;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}