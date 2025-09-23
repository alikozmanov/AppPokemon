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

			// Création de Pokémon avec noms réels
			Pokemon pikachu = new Pokemon();
			pikachu.setNom("Pikachu");
			pikachu.setType("Électrik");
			pikachu.setNiveau(15);
			pikachu.setAttaque(55);
			pikachu.setDefense(40);
			pikachu.setRarete("Rare");
			pikachu.setDresseur(sacha);

			Pokemon pikachu2 = new Pokemon();
			pikachu2.setNom("Pikachu");
			pikachu2.setType("Électrik");
			pikachu2.setNiveau(12);
			pikachu2.setAttaque(50);
			pikachu2.setDefense(35);
			pikachu2.setRarete("Rare");
			pikachu2.setDresseur(ondine);

			Pokemon bulbizarre = new Pokemon();
			bulbizarre.setNom("Bulbizarre");
			bulbizarre.setType("Plante");
			bulbizarre.setNiveau(12);
			bulbizarre.setAttaque(49);
			bulbizarre.setDefense(49);
			bulbizarre.setRarete("Commune");
			bulbizarre.setDresseur(sacha);

			Pokemon herbizarre = new Pokemon();
			herbizarre.setNom("Herbizarre");
			herbizarre.setType("Plante");
			herbizarre.setNiveau(16);
			herbizarre.setAttaque(62);
			herbizarre.setDefense(63);
			herbizarre.setRarete("Peu Commune");
			herbizarre.setDresseur(sacha);

			Pokemon carapuce = new Pokemon();
			carapuce.setNom("Carapuce");
			carapuce.setType("Eau");
			carapuce.setNiveau(14);
			carapuce.setAttaque(48);
			carapuce.setDefense(65);
			carapuce.setRarete("Peu Commune");
			carapuce.setDresseur(ondine);

			Pokemon carapuce2 = new Pokemon();
			carapuce2.setNom("Carapuce");
			carapuce2.setType("Eau");
			carapuce2.setNiveau(15);
			carapuce2.setAttaque(49);
			carapuce2.setDefense(66);
			carapuce2.setRarete("Peu Commune");
			carapuce2.setDresseur(ondine);

			Pokemon salameche = new Pokemon();
			salameche.setNom("Salamèche");
			salameche.setType("Feu");
			salameche.setNiveau(13);
			salameche.setAttaque(52);
			salameche.setDefense(43);
			salameche.setRarete("Commune");
			salameche.setDresseur(ondine);

			Pokemon salamèche2 = new Pokemon();
			salamèche2.setNom("Salamèche");
			salamèche2.setType("Feu");
			salamèche2.setNiveau(14);
			salamèche2.setAttaque(54);
			salamèche2.setDefense(42);
			salamèche2.setRarete("Commune");
			salamèche2.setDresseur(sacha);

			Pokemon roucool = new Pokemon();
			roucool.setNom("Roucool");
			roucool.setType("Vol");
			roucool.setNiveau(10);
			roucool.setAttaque(45);
			roucool.setDefense(40);
			roucool.setRarete("Commune");
			roucool.setDresseur(sacha);

			// Sauvegarde de tous les Pokémon
			List<Pokemon> pokemons = Arrays.asList(
					pikachu, pikachu2, bulbizarre, herbizarre,
					carapuce, carapuce2, salameche, salamèche2, roucool
			);
			pokemonRepository.saveAll(pokemons);

			// --- Création de boosters par type ---
			Booster boosterElectrik = new Booster();
			boosterElectrik.setDateOuverture(LocalDate.now());
			boosterElectrik.setDresseur(sacha);
			boosterElectrik.setCartes(Arrays.asList(pikachu, pikachu2));
			boosterRepository.save(boosterElectrik);

			Booster boosterPlante = new Booster();
			boosterPlante.setDateOuverture(LocalDate.now());
			boosterPlante.setDresseur(sacha);
			boosterPlante.setCartes(Arrays.asList(bulbizarre, herbizarre));
			boosterRepository.save(boosterPlante);

			Booster boosterEau = new Booster();
			boosterEau.setDateOuverture(LocalDate.now());
			boosterEau.setDresseur(sacha);
			boosterEau.setCartes(Arrays.asList(carapuce, carapuce2));
			boosterRepository.save(boosterEau);

			Booster boosterFeu = new Booster();
			boosterFeu.setDateOuverture(LocalDate.now());
			boosterFeu.setDresseur(sacha);
			boosterFeu.setCartes(Arrays.asList(salameche, salamèche2));
			boosterRepository.save(boosterFeu);

			Booster boosterVol = new Booster();
			boosterVol.setDateOuverture(LocalDate.now());
			boosterVol.setDresseur(sacha);
			boosterVol.setCartes(Arrays.asList(roucool));
			boosterRepository.save(boosterVol);

			System.out.println("Données initiales créées : Dresseurs, Pokémon et Boosters par type !");
		}
	}
}
