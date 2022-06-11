package com.example.microservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2",types =Compte.class)
public interface CompteProjection2 {

    public double getSolde();
    public Compte.CompteType getType();

}