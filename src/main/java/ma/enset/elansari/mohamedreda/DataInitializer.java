package ma.enset.elansari.mohamedreda;

import ma.enset.elansari.mohamedreda.entities.*;
import ma.enset.elansari.mohamedreda.repositories.*;
import ma.enset.elansari.mohamedreda.security.Role;
import ma.enset.elansari.mohamedreda.security.User;
import ma.enset.elansari.mohamedreda.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(ClientRepository clientRepository, CreditRepository creditRepository, RemboursementRepository remboursementRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.remboursementRepository = remboursementRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create users
        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .role(Role.ROLE_ADMIN)
                .build();
        userRepository.save(admin);

        User employe = User.builder()
                .username("employe")
                .password(passwordEncoder.encode("employe123"))
                .role(Role.ROLE_EMPLOYE)
                .build();
        userRepository.save(employe);

        User client = User.builder()
                .username("client")
                .password(passwordEncoder.encode("client123"))
                .role(Role.ROLE_CLIENT)
                .build();
        userRepository.save(client);

        // Create clients
        Client client1 = Client.builder()
                .nom("Ahmed El Mansouri")
                .email("ahmed@example.com")
                .build();
        clientRepository.save(client1);

        Client client2 = Client.builder()
                .nom("Fatima Benali")
                .email("fatima@example.com")
                .build();
        clientRepository.save(client2);

        // Create credits
        CreditPersonnel credit1 = CreditPersonnel.builder()
                .dateDemande(new Date())
                .statut(StatutCredit.EN_COURS)
                .montant(50000.0)
                .duree(24)
                .tauxInteret(5.5)
                .client(client1)
                .motif("Voiture")
                .build();
        creditRepository.save(credit1);

        CreditImmobilier credit2 = CreditImmobilier.builder()
                .dateDemande(new Date())
                .statut(StatutCredit.ACCEPTE)
                .dateAcception(new Date())
                .montant(500000.0)
                .duree(240)
                .tauxInteret(3.5)
                .client(client2)
                .typeBien(TypeBien.APPARTEMENT)
                .build();
        creditRepository.save(credit2);

        CreditProfessionnel credit3 = CreditProfessionnel.builder()
                .dateDemande(new Date())
                .statut(StatutCredit.REJETE)
                .montant(200000.0)
                .duree(60)
                .tauxInteret(6.0)
                .client(client1)
                .motif("Business")
                .raisonSociale("SARL XYZ")
                .build();
        creditRepository.save(credit3);

        // Create remboursements
        Remboursement remboursement1 = Remboursement.builder()
                .date(new Date())
                .montant(2200.0)
                .type(TypeRemboursement.MENSUALITE)
                .credit(credit1)
                .build();
        remboursementRepository.save(remboursement1);

        Remboursement remboursement2 = Remboursement.builder()
                .date(new Date())
                .montant(2500.0)
                .type(TypeRemboursement.MENSUALITE)
                .credit(credit2)
                .build();
        remboursementRepository.save(remboursement2);
    }
}
