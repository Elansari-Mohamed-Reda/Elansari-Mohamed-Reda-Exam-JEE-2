package ma.enset.elansari.mohamedreda.services.impl;

import ma.enset.elansari.mohamedreda.dtos.RemboursementDTO;
import ma.enset.elansari.mohamedreda.entities.Credit;
import ma.enset.elansari.mohamedreda.entities.Remboursement;
import ma.enset.elansari.mohamedreda.mappers.RemboursementMapper;
import ma.enset.elansari.mohamedreda.repositories.CreditRepository;
import ma.enset.elansari.mohamedreda.repositories.RemboursementRepository;
import ma.enset.elansari.mohamedreda.services.RemboursementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RemboursementServiceImpl implements RemboursementService {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    public RemboursementServiceImpl(RemboursementRepository remboursementRepository, CreditRepository creditRepository, RemboursementMapper remboursementMapper) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        return remboursementMapper.toDTO(remboursement);
    }

    @Override
    public RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.toEntity(remboursementDTO);
        if (remboursementDTO.getCreditId() != null) {
            Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                    .orElseThrow(() -> new RuntimeException("Credit not found"));
            remboursement.setCredit(credit);
        }
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.toDTO(savedRemboursement);
    }

    @Override
    public RemboursementDTO updateRemboursement(Long id, RemboursementDTO remboursementDTO) {
        Remboursement existingRemboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        existingRemboursement.setDate(remboursementDTO.getDate());
        existingRemboursement.setMontant(remboursementDTO.getMontant());
        existingRemboursement.setType(remboursementDTO.getType());

        if (remboursementDTO.getCreditId() != null) {
            Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                    .orElseThrow(() -> new RuntimeException("Credit not found"));
            existingRemboursement.setCredit(credit);
        }

        Remboursement updatedRemboursement = remboursementRepository.save(existingRemboursement);
        return remboursementMapper.toDTO(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}
