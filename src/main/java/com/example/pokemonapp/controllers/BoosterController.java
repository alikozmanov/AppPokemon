package com.example.pokemonapp.controllers;

import com.example.pokemonapp.dto.BoosterDTO;
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

    @PostMapping("/ouvrir/{dresseurId}")
    public BoosterDTO ouvrir(@PathVariable Long dresseurId) {
        return boosterService.ouvrirBooster(dresseurId);
    }

    @GetMapping
    public List<BoosterDTO> getAll() {
        return boosterService.lister();
    }
}
