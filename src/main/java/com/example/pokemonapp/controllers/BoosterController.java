package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Booster;
import com.example.pokemonapp.services.BoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boosters")
@CrossOrigin(origins = "http://localhost:4200")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    // Ouvrir un booster pour un dresseur
    @PostMapping("/ouvrir/{dresseurId}")
    public Booster ouvrir(@PathVariable Long dresseurId) {
        return boosterService.ouvrirBooster(dresseurId);
    }

    // Lister tous les boosters ouverts
    @GetMapping
    public List<Booster> getAll() {
        return boosterService.lister();
    }
}
