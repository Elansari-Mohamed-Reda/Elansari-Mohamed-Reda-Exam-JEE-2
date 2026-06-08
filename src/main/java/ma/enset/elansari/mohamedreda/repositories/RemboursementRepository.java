package ma.enset.elansari.mohamedreda.repositories;

import ma.enset.elansari.mohamedreda.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}
