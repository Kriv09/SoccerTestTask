package com.example.socertesttask.Controllers;

import com.example.socertesttask.Models.SoccerTransfer;
import com.example.socertesttask.Models.Requests.SoccerTransferRequest;
import com.example.socertesttask.Services.SoccerTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transfer")
public class SoccerTransferController {

    private final SoccerTransferService soccerTransferService;

    public SoccerTransferController(SoccerTransferService soccerTransferService) {
        this.soccerTransferService = soccerTransferService;
    }

    @PostMapping
    public ResponseEntity<SoccerTransfer> createTransfer(@RequestBody SoccerTransferRequest transferRequest) {
        SoccerTransfer transfer = soccerTransferService.createTransfer(transferRequest);
        return ResponseEntity.ok(transfer);
    }

    @GetMapping
    public ResponseEntity<List<SoccerTransfer>> getAllTransfers() {
        List<SoccerTransfer> transfers = soccerTransferService.getAllTransfers();
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoccerTransfer> getTransferById(@PathVariable Long id) {
        Optional<SoccerTransfer> transfer = soccerTransferService.getTransferById(id);
        return transfer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
