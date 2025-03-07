/* package com.mss.host.kafka;

import com.mss.host.service.TransactionProcessingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {
    private final TransactionProcessingService transactionProcessingService;

    public TransactionConsumer(TransactionProcessingService transactionProcessingService) {
        this.transactionProcessingService = transactionProcessingService;
    }

    @KafkaListener(topics = "transaction-valide-risque", groupId = "host-group")
    public void consumeTransaction(TransactionEvent transactionEvent) {
        transactionProcessingService.processTransaction(transactionEvent);
    }
} */
package com.mss.host.kafka;

import com.mss.host.service.TransactionProcessingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {
    private final TransactionProcessingService transactionProcessingService;

    public TransactionConsumer(TransactionProcessingService transactionProcessingService) {
        this.transactionProcessingService = transactionProcessingService;
    }

    @KafkaListener(topics = "transaction-valide-risque", groupId = "host-group")
    public void consumeTransaction(TransactionEvent transactionEvent) {
        // Log de réception du message
        System.out.println("📥 Nouveau message reçu : " + transactionEvent);

        try {
            // Log avant traitement
            System.out.println("🔍 Début du traitement de la transaction : ID = "
                    + transactionEvent.getIdTransaction()
                    + ", Carte = " + transactionEvent.getNumCarte()
                    + ", Montant = " + transactionEvent.getMontant() + " " + transactionEvent.getDevise());

            // Appel du service
            transactionProcessingService.processTransaction(transactionEvent);

            // Log après traitement
            System.out.println("✅ Transaction ID " + transactionEvent.getIdTransaction() + " traitée avec succès.");

        } catch (Exception e) {
            // Log d'erreur
            System.out.println("❌ Erreur lors du traitement de la transaction ID "
                    + transactionEvent.getIdTransaction() + " : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

