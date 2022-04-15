package com.example.microservice.repos;

import com.example.microservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {
}
