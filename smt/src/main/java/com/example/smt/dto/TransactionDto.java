package com.example.smt.dto;

import com.example.smt.entity.Enum.TypeTransaction;

import java.math.BigDecimal;

public class TransactionDto {
    private Long idTransaction;
    private Long numCarte;
    private BigDecimal montant;
    private String devise;
    private TypeTransaction typeTransaction;

    public TransactionDto() {
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    // Getters & Setters
    public Long getNumCarte() { return numCarte; }
    public void setNumCarte(Long numCarte) { this.numCarte = numCarte; }
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    public String getDevise() { return devise; }
    public void setDevise(String devise) { this.devise = devise; }
    public TypeTransaction getTypeTransaction() { return typeTransaction; }
    public void setTypeTransaction(TypeTransaction typeTransaction) { this.typeTransaction = typeTransaction; }
}
