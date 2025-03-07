package com.mss.host.entity;

import com.mss.host.entity.Enum.TypeTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComission;
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;
    private BigDecimal montantFixe;
    private long taux;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBanque", nullable = false)
    private Banque banque;

    // Getters
    public Long getIdComission() {
        return idComission;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public BigDecimal getMontantFixe() {
        return montantFixe;
    }

    public long getTaux() {
        return taux;
    }

    public Banque getBanque() {
        return banque;
    }

    // Setters
    public void setIdComission(Long idComission) {
        this.idComission = idComission;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public void setMontantFixe(BigDecimal montantFixe) {
        this.montantFixe = montantFixe;
    }

    public void setTaux(long taux) {
        this.taux = taux;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}