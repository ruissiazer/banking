/* package com.example.smt.service;

import com.example.smt.dto.TransactionDto;
import com.example.smt.entity.Enum.EtatTransaction;
import com.example.smt.entity.Transaction;
import com.example.smt.kafka.TransactionProducer;
import com.example.smt.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    public TransactionService(TransactionRepository transactionRepository, TransactionProducer transactionProducer) {
        this.transactionRepository = transactionRepository;
        this.transactionProducer = transactionProducer;
    }

    @Transactional
    public Transaction createTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setNumCarte(transactionDto.getNumCarte());
        transaction.setMontant(transactionDto.getMontant());
        transaction.setDevise(transactionDto.getDevise());
        transaction.setTypeTransaction(transactionDto.getTypeTransaction());
        transaction.setEtat(EtatTransaction.PENDING);
        transaction.setHorodatage(LocalDateTime.now());

        Transaction savedTransaction = transactionRepository.save(transaction);

        // Publier l'événement
        transactionProducer.sendTransactionInitiée(transaction);
       // transactionProducer.sendMessage(transactionDto);

        return savedTransaction;
    }
} */
