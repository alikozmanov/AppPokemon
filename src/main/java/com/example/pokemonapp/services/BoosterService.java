package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Booster;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.BoosterRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import com.example.pokemonapp.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BoosterService {

    @Autowired
    private BoosterRepository boosterRepo;

    @Autowired
    private DresseurRepository dresseurRepo;

    @Autowired
    private PokemonRepository pokemonRepo;

    private static final String[] NOMS = {"Pikachu", "Salamèche", "Carapuce", "Bulbizarre", "Roucool", "Mewtwo"};
    private static final String[] TYPES = {"Électrik", "Feu", "Eau", "Plante", "Normal", "Psy"};
    private static final String[] RARETES = {"Commune", "Peu Commune", "Rare", "Légendaire"};

    private Random random = new Random();

    public Booster ouvrirBooster(Long dresseurId) {
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

            pokemonRepo.save(p); // ajout à la collection
            cartes.add(p);
        }

        booster.setCartes(cartes);
        return boosterRepo.save(booster);
    }

    public List<Booster> lister() {
        return boosterRepo.findAll();
    }
}
