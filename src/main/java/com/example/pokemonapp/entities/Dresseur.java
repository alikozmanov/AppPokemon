package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Dresseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String pseudo;
    private int niveau;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons;
}
