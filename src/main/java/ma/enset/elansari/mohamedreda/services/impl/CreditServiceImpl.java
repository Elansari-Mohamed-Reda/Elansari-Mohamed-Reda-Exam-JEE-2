package ma.enset.elansari.mohamedreda.services.impl;

import ma.enset.elansari.mohamedreda.dtos.*;
import ma.enset.elansari.mohamedreda.entities.*;
import ma.enset.elansari.mohamedreda.mappers.CreditMapper;
import ma.enset.elansari.mohamedreda.repositories.ClientRepository;
import ma.enset.elansari.mohamedreda.repositories.CreditRepository;
import ma.enset.elansari.mohamedreda.services.CreditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(CreditRepository creditRepository, ClientRepository clientRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CreditDTO getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        return creditMapper.toDTO(credit);
    }

    @Override
    public CreditDTO createCredit(CreditDTO creditDTO) {
        Credit credit;
        if (creditDTO instanceof CreditPersonnelDTO) {
            credit = creditMapper.toPersonnelEntity((CreditPersonnelDTO) creditDTO);
        } else if (creditDTO instanceof CreditImmobilierDTO) {
            credit = creditMapper.toImmobilierEntity((CreditImmobilierDTO) creditDTO);
        } else if (creditDTO instanceof CreditProfessionnelDTO) {
            credit = creditMapper.toProfessionnelEntity((CreditProfessionnelDTO) creditDTO);
        } else {
            throw new IllegalArgumentException("Unknown credit type");
        }

        if (creditDTO.getClientId() != null) {
            Client client = clientRepository.findById(creditDTO.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            credit.setClient(client);
        }

        Credit savedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(savedCredit);
    }

    @Override
    public CreditDTO updateCredit(Long id, CreditDTO creditDTO) {
        Credit existingCredit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        existingCredit.setDateDemande(creditDTO.getDateDemande());
        existingCredit.setStatut(creditDTO.getStatut());
        existingCredit.setDateAcception(creditDTO.getDateAcception());
        existingCredit.setMontant(creditDTO.getMontant());
        existingCredit.setDuree(creditDTO.getDuree());
        existingCredit.setTauxInteret(creditDTO.getTauxInteret());

        if (creditDTO.getClientId() != null) {
            Client client = clientRepository.findById(creditDTO.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            existingCredit.setClient(client);
        }

        Credit updatedCredit = creditRepository.save(existingCredit);
        return creditMapper.toDTO(updatedCredit);
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}
