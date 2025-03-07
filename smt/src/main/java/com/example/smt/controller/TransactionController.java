package com.example.smt.controller;

import com.example.smt.dto.TransactionDto;
import com.example.smt.entity.Transaction;
import com.example.smt.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction savedTransaction = transactionService.createTransaction(transactionDto);
        return ResponseEntity.ok(savedTransaction);
    }

    /* @GetMapping("/transactions/{id}")
    public ResponseEntity<TransactionStatusDto> getTransactionStatus(@PathVariable Long id) {
        TransactionStatusDto status = transactionService.getTransactionStatus(id);
        return ResponseEntity.ok(status);
}*/
}
