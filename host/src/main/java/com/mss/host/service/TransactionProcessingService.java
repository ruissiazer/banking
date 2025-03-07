package com.mss.host.service;

import com.mss.host.entity.Compte;
import com.mss.host.kafka.TransactionEvent;
import com.mss.host.kafka.TransactionProducer;
import com.mss.host.repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionProcessingService {
    private final CompteRepository compteRepository;
    private final TransactionProducer transactionProducer;
    private final RestClient restClient;

    public TransactionProcessingService(CompteRepository compteRepository, TransactionProducer transactionProducer, RestClient restClient) {
        this.compteRepository = compteRepository;
        this.transactionProducer = transactionProducer;
        this.restClient = restClient;
    }

    @Transactional
    public void processTransaction(TransactionEvent transactionEvent) {
        // 🔹 1. Récupérer l'ID du compte en appelant CMS
        Long idCompte = getCompteIdFromCMS(transactionEvent.getNumCarte());

        if (idCompte == null) {
            transactionProducer.sendTransactionRejected(transactionEvent, "Compte non trouvé");
            return;
        }

        // 🔹 2. Trouver le compte dans Host
        Optional<Compte> compteOpt = compteRepository.findById(idCompte);

        if (compteOpt.isEmpty()) {
            transactionProducer.sendTransactionRejected(transactionEvent, "Compte non trouvé");
            return;
        }

        Compte compte = compteOpt.get();

        // 🔹 3. Vérifier et modifier le solde
        if (transactionEvent.getTypeTransaction().equals("PAIEMENT") || transactionEvent.getTypeTransaction().equals("RETRAIT")) {
            if (compte.getSolde().compareTo(transactionEvent.getMontant()) < 0) {
                transactionProducer.sendTransactionRejected(transactionEvent, "Solde insuffisant");
                return;
            }
            compte.setSolde(compte.getSolde().subtract(transactionEvent.getMontant()));
        } else {
            compte.setSolde(compte.getSolde().add(transactionEvent.getMontant()));
        }

        // 🔹 4. Sauvegarder et envoyer un événement
        compteRepository.save(compte);
        transactionProducer.sendTransactionApproved(transactionEvent);
    }

    // 🔹 Méthode pour récupérer l'ID du compte depuis CMS
    private Long getCompteIdFromCMS(Long numCarte) {
        try {
            return restClient.get()
                    .uri("http://CMS-SERVICE/api/cartes/{numCarte}/compte", numCarte)
                    .retrieve()
                    .body(Long.class);
        } catch (Exception e) {
            return null; // Retourne null si l'appel échoue
        }
    }
}
