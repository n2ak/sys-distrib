package com.example.microservice.services;

import com.example.microservice.entities.Compte;
import com.example.microservice.repos.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompteService {
    @Autowired
    private CompteRepo repo;
    public void virement(Long de,Long a,double montant){
        Compte c1 = repo.getById(de);
        Compte c2 = repo.getById(a);
        if(c1.getSolde() >= montant){
            c1.setSolde(c1.getSolde() - montant);
            c2.setSolde(c2.getSolde() + montant);
            repo.save(c1);
            repo.save(c2);
        }
    }
}

