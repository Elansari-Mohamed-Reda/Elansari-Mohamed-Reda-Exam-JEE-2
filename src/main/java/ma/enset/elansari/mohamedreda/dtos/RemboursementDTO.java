package ma.enset.elansari.mohamedreda.dtos;

import lombok.*;
import ma.enset.elansari.mohamedreda.entities.TypeRemboursement;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private TypeRemboursement type;
    private Long creditId;
}