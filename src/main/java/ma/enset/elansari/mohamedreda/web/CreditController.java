package ma.enset.elansari.mohamedreda.web;

import ma.enset.elansari.mohamedreda.dtos.*;
import ma.enset.elansari.mohamedreda.services.CreditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@CrossOrigin("*")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public ResponseEntity<List<CreditDTO>> getAllCredits() {
        return ResponseEntity.ok(creditService.getAllCredits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        return ResponseEntity.ok(creditService.getCreditById(id));
    }

    @PostMapping
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO creditDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditService.createCredit(creditDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditDTO> updateCredit(@PathVariable Long id, @RequestBody CreditDTO creditDTO) {
        return ResponseEntity.ok(creditService.updateCredit(id, creditDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return ResponseEntity.noContent().build();
    }
}
