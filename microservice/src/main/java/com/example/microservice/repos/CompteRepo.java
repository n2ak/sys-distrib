package com.example.microservice.repos;

import com.example.microservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepo extends JpaRepository<Compte,Long> {
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param(value = "type") Compte.CompteType compteType);
}
