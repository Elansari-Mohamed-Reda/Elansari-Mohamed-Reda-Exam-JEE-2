package ma.enset.elansari.mohamedreda.services;

import ma.enset.elansari.mohamedreda.dtos.*;

import java.util.List;

public interface CreditService {
    List<CreditDTO> getAllCredits();
    CreditDTO getCreditById(Long id);
    CreditDTO createCredit(CreditDTO creditDTO);
    CreditDTO updateCredit(Long id, CreditDTO creditDTO);
    void deleteCredit(Long id);
}
