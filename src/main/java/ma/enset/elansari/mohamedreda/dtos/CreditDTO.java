package ma.enset.elansari.mohamedreda.dtos;

import lombok.*;
import ma.enset.elansari.mohamedreda.entities.StatutCredit;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcception;
    private Double montant;
    private Integer duree;
    private Double tauxInteret;
    private Long clientId;
    private String typeCredit;
}