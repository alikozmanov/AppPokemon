package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DresseurService {

    @Autowired
    private DresseurRepository repo;

    public List<Dresseur> lister() {
        return repo.findAll();
    }

    public Optional<Dresseur> rechercher(Long id) {
        return repo.findById(id);
    }

    public Dresseur sauvegarder(Dresseur d) {
        return repo.save(d);
    }

    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}
