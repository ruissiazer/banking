package com.mss.host.entity;

import com.mss.host.entity.Enum.Monnaie;
import com.mss.host.entity.Enum.TypeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private BigDecimal solde;
    @Enumerated(EnumType.STRING)
    private Monnaie monnaie;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

   // @OneToMany(fetch = FetchType.LAZY, mappedBy ="compte")
    //private List<Carte> cartes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBanque", nullable = false)
    private Banque banque;

    // Getters
    public Long getIdCompte() {
        return idCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public Monnaie getMonnaie() {
        return monnaie;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public Banque getBanque() {
        return banque;
    }

    // Setters
    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public void setMonnaie(Monnaie monnaie) {
        this.monnaie = monnaie;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}
