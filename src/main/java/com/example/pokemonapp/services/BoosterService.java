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

    private Random random = new Random();

    public BoosterDTO ouvrirBoosterParType(Long dresseurId, String type) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = new Booster();
        booster.setDateOuverture(LocalDate.now());
        booster.setDresseur(dresseur);

        List<Pokemon> cartes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Pokemon p = new Pokemon();
            p.setNom("Pokémon " + (i+1));
            p.setType(type); // on force le type
            p.setNiveau(random.nextInt(50) + 1);
            p.setAttaque(random.nextInt(100));
            p.setDefense(random.nextInt(100));
            p.setRarete(new String[]{"Commune","Peu Commune","Rare","Légendaire"}[random.nextInt(4)]);
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

    public List<BoosterDTO> lister() {
        return boosterRepo.findAll().stream()
                .map(b -> new BoosterDTO(b.getId(), b.getDateOuverture(), b.getCartes()))
                .toList();
    }
}
