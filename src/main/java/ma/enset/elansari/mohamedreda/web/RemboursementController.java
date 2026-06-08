package ma.enset.elansari.mohamedreda.web;

import ma.enset.elansari.mohamedreda.dtos.RemboursementDTO;
import ma.enset.elansari.mohamedreda.services.RemboursementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
@CrossOrigin("*")
public class RemboursementController {

    private final RemboursementService remboursementService;

    public RemboursementController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }

    @GetMapping
    public ResponseEntity<List<RemboursementDTO>> getAllRemboursements() {
        return ResponseEntity.ok(remboursementService.getAllRemboursements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementDTO> getRemboursementById(@PathVariable Long id) {
        return ResponseEntity.ok(remboursementService.getRemboursementById(id));
    }

    @PostMapping
    public ResponseEntity<RemboursementDTO> createRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(remboursementService.createRemboursement(remboursementDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemboursementDTO> updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO remboursementDTO) {
        return ResponseEntity.ok(remboursementService.updateRemboursement(id, remboursementDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
        return ResponseEntity.noContent().build();
    }
}
