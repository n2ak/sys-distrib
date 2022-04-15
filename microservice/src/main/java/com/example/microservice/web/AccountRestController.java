package com.example.microservice.web;

import com.example.microservice.dtos.VirementRequestDTO;
import com.example.microservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired
    private CompteService service;

    @PutMapping(path = "comptes/virement")
    public void virement(@RequestBody VirementRequestDTO req){
        service.virement(req.getDe(),req.getA(),req.getMontant());
    }
}
