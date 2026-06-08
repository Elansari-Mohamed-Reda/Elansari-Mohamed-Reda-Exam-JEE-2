package ma.enset.elansari.mohamedreda.services;

import ma.enset.elansari.mohamedreda.dtos.RemboursementDTO;

import java.util.List;

public interface RemboursementService {
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO getRemboursementById(Long id);
    RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO updateRemboursement(Long id, RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);
}
