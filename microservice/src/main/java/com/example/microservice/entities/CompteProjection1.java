package com.example.microservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types =Compte.class)
public interface CompteProjection1 {

    public Long getId();
    public  double getSolde();

}