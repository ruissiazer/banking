/* package com.example.smt.kafka;

import com.example.smt.dto.TransactionDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {
    private final KafkaTemplate<String, TransactionDto> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, TransactionDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionInitiée(TransactionDto transactionDto) {
        kafkaTemplate.send("transaction-initiee", transactionDto);
    }
   /* public void sendMessage(TransactionDto transactionDto) {

       Message<TransactionDto> message = MessageBuilder
               .withPayload(transactionDto)
               .setHeader(KafkaHeaders.TOPIC, "transaction-initiee")
               .build();

       kafkaTemplate.send(message);
   }
} */
/* package com.example.smt.kafka;

import com.example.smt.entity.Enum.EtatTransaction;
import com.example.smt.entity.Transaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, TransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionInitiée(Transaction transaction) {
        TransactionEvent event = new TransactionEvent();
        event.setIdTransaction(transaction.getIdTransaction());
        event.setNumCarte(transaction.getNumCarte());
        event.setMontant(transaction.getMontant());
        event.setDevise(transaction.getDevise());
        event.setEtat(transaction.getEtat().toString());
        event.setTypeTransaction(transaction.getTypeTransaction().toString());

        kafkaTemplate.send("transaction-initiee3", event);
    }
} */

