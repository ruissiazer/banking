package com.example.smt.entity;

import com.example.smt.entity.Enum.EtatTransaction;
import com.example.smt.entity.Enum.TypeTransaction;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private Long numCarte;
    private BigDecimal montant;
    private String devise;
    private LocalDateTime horodatage;
    @Enumerated(EnumType.STRING)
    private EtatTransaction etatTransaction;
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    // Getters & Setters
    public Long getIdTransaction() { return idTransaction; }
    public void setIdTransaction(Long idTransaction) { this.idTransaction = idTransaction; }
    public Long getNumCarte() { return numCarte; }
    public void setNumCarte(Long numCarte) { this.numCarte = numCarte; }
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    public String getDevise() { return devise; }
    public void setDevise(String devise) { this.devise = devise; }
    public LocalDateTime getHorodatage() { return horodatage; }
    public void setHorodatage(LocalDateTime horodatage) { this.horodatage = horodatage; }
    public EtatTransaction getEtat() { return etatTransaction; }
    public void setEtat(EtatTransaction etat) { this.etatTransaction = etat; }
    public TypeTransaction getTypeTransaction() { return typeTransaction; }
    public void setTypeTransaction(TypeTransaction typeTransaction) { this.typeTransaction = typeTransaction; }

}
