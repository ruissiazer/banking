package com.example.smt.mapper;

import com.example.smt.dto.TransactionDto;
import com.example.smt.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class TransactionMapper {
    // Convertir Transaction en TransactionDto
    public TransactionDto toDto(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setIdTransaction(transaction.getIdTransaction());
        dto.setNumCarte(transaction.getNumCarte());
        dto.setMontant(transaction.getMontant());
        dto.setDevise(transaction.getDevise());
        dto.setTypeTransaction(transaction.getTypeTransaction());
        return dto;
    }

    // Convertir TransactionDto en Transaction
    public Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setIdTransaction(dto.getIdTransaction()); // Peut être null si c'est une nouvelle transaction
        transaction.setNumCarte(dto.getNumCarte());
        transaction.setMontant(dto.getMontant());
        transaction.setDevise(dto.getDevise());
        transaction.setTypeTransaction(dto.getTypeTransaction());
        return transaction;
    }
}
