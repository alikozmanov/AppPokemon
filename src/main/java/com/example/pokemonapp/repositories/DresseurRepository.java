package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DresseurRepository extends JpaRepository<Dresseur, Long> {
}
