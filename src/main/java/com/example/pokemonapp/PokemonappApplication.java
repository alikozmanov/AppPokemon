package com.example.pokemonapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pokemonapp.entities.*;
import com.example.pokemonapp.repositories.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PokemonappApplication implements CommandLineRunner {

	@Autowired
	private DresseurRepository dresseurRepository;

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private BoosterRepository boosterRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokemonappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (dresseurRepository.count() == 0) {

			// Création de dresseurs
			Dresseur sacha = new Dresseur();
			sacha.setNom("Ketchum");
			sacha.setPseudo("Sacha");
			sacha.setNiveau(10);

			Dresseur ondine = new Dresseur();
			ondine.setNom("Misty");
			ondine.setPseudo("Ondine");
			ondine.setNiveau(8);

			dresseurRepository.saveAll(Arrays.asList(sacha, ondine));

			// Création de Pokémon
			Pokemon pikachu = new Pokemon();
			pikachu.setNom("Pikachu");
			pikachu.setType("Électrik");
			pikachu.setNiveau(15);
			pikachu.setAttaque(55);
			pikachu.setDefense(40);
			pikachu.setRarete("Rare");
			pikachu.setDresseur(sacha);

			Pokemon bulbizarre = new Pokemon();
			bulbizarre.setNom("Bulbizarre");
			bulbizarre.setType("Plante");
			bulbizarre.setNiveau(12);
			bulbizarre.setAttaque(49);
			bulbizarre.setDefense(49);
			bulbizarre.setRarete("Commune");
			bulbizarre.setDresseur(sacha);

			Pokemon carapuce = new Pokemon();
			carapuce.setNom("Carapuce");
			carapuce.setType("Eau");
			carapuce.setNiveau(14);
			carapuce.setAttaque(48);
			carapuce.setDefense(65);
			carapuce.setRarete("Peu Commune");
			carapuce.setDresseur(ondine);

			Pokemon salameche = new Pokemon();
			salameche.setNom("Salamèche");
			salameche.setType("Feu");
			salameche.setNiveau(13);
			salameche.setAttaque(52);
			salameche.setDefense(43);
			salameche.setRarete("Commune");
			salameche.setDresseur(ondine);

			// Nouveaux Pokémon
			Pokemon roucool = new Pokemon();
			roucool.setNom("Roucool");
			roucool.setType("Vol");
			roucool.setNiveau(10);
			roucool.setAttaque(45);
			roucool.setDefense(40);
			roucool.setRarete("Commune");
			roucool.setDresseur(sacha);

			Pokemon pikachu2 = new Pokemon();
			pikachu2.setNom("Pikachu");
			pikachu2.setType("Électrik");
			pikachu2.setNiveau(12);
			pikachu2.setAttaque(50);
			pikachu2.setDefense(35);
			pikachu2.setRarete("Rare");
			pikachu2.setDresseur(ondine);

			Pokemon herbizarre = new Pokemon();
			herbizarre.setNom("Herbizarre");
			herbizarre.setType("Plante");
			herbizarre.setNiveau(16);
			herbizarre.setAttaque(62);
			herbizarre.setDefense(63);
			herbizarre.setRarete("Peu Commune");
			herbizarre.setDresseur(sacha);

			Pokemon salamèche2 = new Pokemon();
			salamèche2.setNom("Salamèche");
			salamèche2.setType("Feu");
			salamèche2.setNiveau(14);
			salamèche2.setAttaque(54);
			salamèche2.setDefense(42);
			salamèche2.setRarete("Commune");
			salamèche2.setDresseur(sacha);

			Pokemon carapuce2 = new Pokemon();
			carapuce2.setNom("Carapuce");
			carapuce2.setType("Eau");
			carapuce2.setNiveau(15);
			carapuce2.setAttaque(49);
			carapuce2.setDefense(66);
			carapuce2.setRarete("Peu Commune");
			carapuce2.setDresseur(ondine);

			// Sauvegarde de tous les Pokémon
			List<Pokemon> pokemons = Arrays.asList(
					pikachu, bulbizarre, carapuce, salameche,
					roucool, pikachu2, herbizarre, salamèche2, carapuce2
			);
			pokemonRepository.saveAll(pokemons);

			// Création d’un booster fictif pour Sacha
			Booster booster1 = new Booster();
			booster1.setDateOuverture(LocalDate.now());
			booster1.setDresseur(sacha);
			booster1.setCartes(Arrays.asList(pikachu, bulbizarre, roucool, herbizarre, salamèche2));

			boosterRepository.save(booster1);

			System.out.println("Données initiales créées : Dresseurs, Pokémon et Boosters !");
		}
	}
}
