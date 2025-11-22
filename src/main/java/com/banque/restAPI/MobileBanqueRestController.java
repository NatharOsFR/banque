package com.banque.restAPI;

import com.banque.dataTransferObjects.OperationDto;
import com.banque.dataTransferObjects.ProduitBancaireDto;
import com.banque.dataTransferObjects.VirementDto;
import com.banque.service.MobileBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileBanqueRestController {

    @Autowired
    private MobileBanqueService mobileService;

    @GetMapping("/produits/{id}/operations/last5")
    public ResponseEntity<?> getLastFive(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mobileService.getLastFiveOperations(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/produits/{id}")
    public ProduitBancaireDto getProduit(@PathVariable Long id) {
        return mobileService.getProduitDetails(id);
    }

    @PostMapping("/virement")
    public ResponseEntity<String> faireVirement(@RequestBody VirementDto request) {
        mobileService.faireVirement(request);
        return ResponseEntity.ok("Virement OK");
    }
}

