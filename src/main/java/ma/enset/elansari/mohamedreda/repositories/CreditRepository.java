package ma.enset.elansari.mohamedreda.repositories;

import ma.enset.elansari.mohamedreda.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}
