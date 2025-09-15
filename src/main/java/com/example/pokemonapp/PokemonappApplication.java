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

			// Création de pokémons
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

			List<Pokemon> pokemons = Arrays.asList(pikachu, bulbizarre, carapuce, salameche);
			pokemonRepository.saveAll(pokemons);

			// Création d’un booster fictif pour Sacha
			Booster booster1 = new Booster();
			booster1.setDateOuverture(LocalDate.now());
			booster1.setDresseur(sacha);
			booster1.setCartes(Arrays.asList(pikachu, bulbizarre));

			boosterRepository.save(booster1);

			System.out.println("Données initiales créées : Dresseurs, Pokémon et Boosters !");
		}
	}
}
