package com.example.pokemonapp.controllers;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.services.BoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boosters")
@CrossOrigin(origins = "http://localhost:4200")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    @PostMapping("/ouvrir/{dresseurId}")
    public BoosterDTO ouvrir(@PathVariable Long dresseurId, @RequestBody Map<String, String> body) {
        String type = body.get("type");
        return boosterService.ouvrirBoosterParType(dresseurId, type);
    }

    @GetMapping
    public List<BoosterDTO> getAll() {
        return boosterService.lister();
    }
}

