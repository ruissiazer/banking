package com.example.smt.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
public class TransactionEvent {
    private Long idTransaction;
    private Long numCarte;
    private BigDecimal montant;
    private String devise;
    private String etat; // "PENDING", "APPROUVEE", "REJETEE"
    private String typeTransaction;

    // Constructeurs
    public TransactionEvent() {}

    public TransactionEvent(Long idTransaction, Long numCarte, BigDecimal montant, String devise, String etat, String typeTransaction) {
        this.idTransaction = idTransaction;
        this.numCarte = numCarte;
        this.montant = montant;
        this.devise = devise;
        this.etat = etat;
        this.typeTransaction = typeTransaction;
    }

    // Getters & Setters
    public Long getIdTransaction() { return idTransaction; }
    public void setIdTransaction(Long idTransaction) { this.idTransaction = idTransaction; }

    public Long getNumCarte() { return numCarte; }
    public void setNumCarte(Long numCarte) { this.numCarte = numCarte; }

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    public String getDevise() { return devise; }
    public void setDevise(String devise) { this.devise = devise; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }

    public String getTypeTransaction() { return typeTransaction; }
    public void setTypeTransaction(String typeTransaction) { this.typeTransaction = typeTransaction; }

    // toString() pour faciliter le débogage
    @Override
    public String toString() {
        return "TransactionEvent{" +
                "idTransaction=" + idTransaction +
                ", numCarte=" + numCarte +
                ", montant=" + montant +
                ", devise='" + devise + '\'' +
                ", etat='" + etat + '\'' +
                ", typeTransaction='" + typeTransaction + '\'' +
                '}';
    }
}

