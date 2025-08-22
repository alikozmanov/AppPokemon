package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Echange;
import com.example.pokemonapp.repositories.EchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EchangeService {
    @Autowired
    private EchangeRepository repo;

    public Echange proposer(Echange e) {
        e.setStatut("en_attente");
        return repo.save(e);
    }

    public List<Echange> lister() {
        return repo.findAll();
    }

    public Optional<Echange> rechercher(Long id) {
        return repo.findById(id);
    }

    public Echange accepter(Long id) {
        Optional<Echange> opt = repo.findById(id);
        if (opt.isPresent()) {
            Echange e = opt.get();
            e.setStatut("accepte");
            return repo.save(e);
        }
        return null;
    }

    public Echange refuser(Long id) {
        Optional<Echange> opt = repo.findById(id);
        if (opt.isPresent()) {
            Echange e = opt.get();
            e.setStatut("refuse");
            return repo.save(e);
        }
        return null;
    }
}
