-- ============================
-- Dresseurs
-- ============================
INSERT INTO dresseur (nom, pseudo, niveau) VALUES ('Sacha', 'ashKetchum', 10);
INSERT INTO dresseur (nom, pseudo, niveau) VALUES ('Ondine', 'misty', 8);
INSERT INTO dresseur (nom, pseudo, niveau) VALUES ('Pierre', 'brock', 9);

-- ============================
-- Pokémons
-- ============================
INSERT INTO pokemon (nom, type, niveau, attaque, defense, id_dresseur)
VALUES ('Pikachu', 'Electrique', 5, 55, 40, 1);

INSERT INTO pokemon (nom, type, niveau, attaque, defense, id_dresseur)
VALUES ('Salamèche', 'Feu', 6, 52, 43, 1);

INSERT INTO pokemon (nom, type, niveau, attaque, defense, id_dresseur)
VALUES ('Carapuce', 'Eau', 5, 48, 65, 2);

INSERT INTO pokemon (nom, type, niveau, attaque, defense, id_dresseur)
VALUES ('Bulbizarre', 'Plante', 5, 49, 49, 3);

INSERT INTO pokemon (nom, type, niveau, attaque, defense, id_dresseur)
VALUES ('Onix', 'Roche', 10, 45, 160, 3);

-- ============================
-- Combats
-- ============================
INSERT INTO combat (id_pokemon1, id_pokemon2, date, gagnant_id)
VALUES (1, 3, '2025-08-20', 1);

INSERT INTO combat (id_pokemon1, id_pokemon2, date, gagnant_id)
VALUES (2, 4, '2025-08-19', 4);
