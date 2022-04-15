package com.example.microservice.web;

import com.example.microservice.entities.Compte;
import com.example.microservice.repos.CompteRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteController {
    private CompteRepo repo;

    public CompteController(CompteRepo repo) {
        this.repo = repo;
    }
    @GetMapping(path = "/comptes")
    public List<Compte> getComptes(){
        return repo.findAll();
    }
    @GetMapping(path="/comptes/{id}")
    public Compte getCompte(Long id){
        return repo.findById(id).get();
    }
    @PostMapping(path = "/comptes")
    public Compte addCompte(@RequestBody Compte c){
        return repo.save(c);
    }
    @PutMapping(path = "/comptes/{id}")
    public Compte updateCompte(@PathVariable Long id,@RequestBody Compte c){
        c.setId(id);
        return repo.save(c);
    }
    @DeleteMapping(path = "/comptes/{id}")
    public void deleteCompte(@PathVariable Long id){
        repo.deleteById(id);
    }
}
