package com.mss.host.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, TransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionApproved(TransactionEvent transactionEvent) {
        System.out.println("Transaction approuvée : ID " + transactionEvent.getIdTransaction());
        kafkaTemplate.send("transaction-approuvee", transactionEvent);
    }

    public void sendTransactionRejected(TransactionEvent transactionEvent, String reason) {
        System.out.println("Transaction rejetée : ID " + transactionEvent.getIdTransaction() + " - Motif : " + reason);
        kafkaTemplate.send("transaction-rejetee-solde", transactionEvent);
    }
}
