package com.mss.host.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBanque;
    private String nomBanque;
    private String adresseBanque;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "banque")
    //private List<BIN> bins;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "banque")
    private List<Comission> comissions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "banque")
    private List<Compte> comptes ;

    // Getters
    public Long getIdBanque() {
        return idBanque;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public String getAdresseBanque() {
        return adresseBanque;
    }

    /* public List<BIN> getBins() {
        return bins;
    }*/

    public List<Comission> getComissions() {
        return comissions;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    // Setters
    public void setIdBanque(Long idBanque) {
        this.idBanque = idBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public void setAdresseBanque(String adresseBanque) {
        this.adresseBanque = adresseBanque;
    }

   /* public void setBins(List<BIN> bins) {
        this.bins = bins;
    }*/

    public void setComissions(List<Comission> comissions) {
        this.comissions = comissions;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }


}
