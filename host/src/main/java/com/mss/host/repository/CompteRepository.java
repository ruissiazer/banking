package com.mss.host.repository;

import com.mss.host.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
   // Optional<Compte> findByCarteNumCarte(Long numCarte);
}

