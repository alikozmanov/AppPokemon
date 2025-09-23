package com.example.pokemonapp.services;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.entities.*;
import com.example.pokemonapp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BoosterService {

    @Autowired private BoosterRepository boosterRepo;
    @Autowired private DresseurRepository dresseurRepo;
    @Autowired private PokemonRepository pokemonRepo;
    @Autowired private CollectionRepository collectionRepo;

    private static final String[] NOMS = {"Pikachu","Salamèche","Carapuce","Bulbizarre","Roucool","Mewtwo"};
    private static final String[] TYPES = {"Électrik","Feu","Eau","Plante","Normal","Psy"};
    private static final String[] RARETES = {"Commune","Peu Commune","Rare","Légendaire"};
    private Random random = new Random();

    // Ouvrir un booster pour un dresseur
    public BoosterDTO ouvrirBooster(Long dresseurId) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = new Booster();
        booster.setDateOuverture(LocalDate.now());
        booster.setDresseur(dresseur);

        List<Pokemon> cartes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pokemon p = new Pokemon();
            p.setNom(NOMS[random.nextInt(NOMS.length)]);
            p.setType(TYPES[random.nextInt(TYPES.length)]);
            p.setNiveau(random.nextInt(50) + 1);
            p.setAttaque(random.nextInt(100));
            p.setDefense(random.nextInt(100));
            p.setRarete(RARETES[random.nextInt(RARETES.length)]);
            p.setDresseur(dresseur);
            pokemonRepo.save(p);
            cartes.add(p);

            Collection c = new Collection();
            c.setDresseur(dresseur);
            c.setCarte(p);
            collectionRepo.save(c);
        }

        booster.setCartes(cartes);
        boosterRepo.save(booster);

        return new BoosterDTO(booster.getId(), booster.getDateOuverture(), cartes);
    }

    // Lister tous les boosters
    public List<BoosterDTO> lister() {
        return boosterRepo.findAll().stream()
                .map(b -> new BoosterDTO(b.getId(), b.getDateOuverture(), b.getCartes()))
                .toList();
    }
}
