package com.example.smt.kafka;

import com.example.smt.entity.Enum.EtatTransaction;
import com.example.smt.entity.Transaction;
import com.example.smt.repository.TransactionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransactionConsumer {
    private final TransactionRepository transactionRepository;

    public TransactionConsumer(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @KafkaListener(topics = "transaction-approuvee", groupId = "smt-group")
    public void handleTransactionApproved(TransactionEvent transactionEvent) {
        System.out.println("✅ Transaction approuvée reçue : ID " + transactionEvent.getIdTransaction());

        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionEvent.getIdTransaction());
        if (transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();
            transaction.setEtat(EtatTransaction.APPROUVÉE);
            transactionRepository.save(transaction);
            System.out.println("✅ Transaction mise à jour en APPROUVÉE en base !");
        } else {
            System.err.println("⚠️ Transaction non trouvée en base pour l'ID : " + transactionEvent.getIdTransaction());
        }
    }

    @KafkaListener(topics = "transaction-rejetee-solde", groupId = "smt-group")
    public void handleTransactionRejected(TransactionEvent transactionEvent) {
        System.out.println("❌ Transaction rejetée reçue : ID " + transactionEvent.getIdTransaction());

        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionEvent.getIdTransaction());
        if (transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();
            transaction.setEtat(EtatTransaction.REJETÉE);
            transactionRepository.save(transaction);
            System.out.println("❌ Transaction mise à jour en REJETÉE en base !");
        } else {
            System.err.println("⚠️ Transaction non trouvée en base pour l'ID : " + transactionEvent.getIdTransaction());
        }
    }

    @KafkaListener(topics = "transaction-rejetee-risque", groupId = "smt-group")
    public void handleTransactionRejectedRisk(TransactionEvent transactionEvent) {
        System.out.println("🚨 Transaction rejetée pour risque reçue : ID " + transactionEvent.getIdTransaction());

        /* Optional<Transaction> transactionOpt = transactionRepository.findById(transactionEvent.getIdTransaction());
        if (transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();
            transaction.setEtat(EtatTransaction.REJETÉE_POUR_RISQUE);
            transactionRepository.save(transaction);
            System.out.println("🚨 Transaction mise à jour en REJETÉE POUR RISQUE en base !");
        } else {
            System.err.println("⚠️ Transaction non trouvée en base pour l'ID : " + transactionEvent.getIdTransaction());
        }*/
    }
}
