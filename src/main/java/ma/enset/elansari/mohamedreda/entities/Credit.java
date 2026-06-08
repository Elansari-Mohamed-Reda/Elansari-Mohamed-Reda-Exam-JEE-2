package ma.enset.elansari.mohamedreda.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public abstract class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    private Date dateAcception;
    private Double montant;
    private Integer duree;
    private Double tauxInteret;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Remboursement> remboursements;
}