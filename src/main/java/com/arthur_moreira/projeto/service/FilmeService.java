package com.arthur_moreira.projeto.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arthur_moreira.projeto.model.Filme;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class FilmeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvarFilmes() {
        List<Filme> filmes = Arrays.asList(
                new Filme("Captain America: The Winter Soldier", "Action", "12", 7.8),
                new Filme("Iron Man", "Action", "10", 7.9),
                new Filme("The Avengers", "Action", "12", 8.0),
                new Filme("Avengers: Infinity War", "Action", "12", 8.4),
                new Filme("Avengers: Endgame", "Action", "12", 8.4),
                new Filme("Black Panther", "Action", "12", 7.3),
                new Filme("Captain America: The Winter Soldier", "Action", "12", 7.8),
                new Filme("Iron Man", "Action", "10", 7.9),
                new Filme("The Avengers", "Action", "12", 8.0),
                new Filme("Avengers: Infinity War", "Action", "12", 8.4),
                new Filme("Avengers: Endgame", "Action", "12", 8.4),
                new Filme("Black Panther", "Action", "12", 7.3),
                new Filme("Mad Max: Fury Road", "Action", "16", 8.1),
                new Filme("John Wick", "Action", "18", 7.4),
                new Filme("John Wick: Chapter 2", "Action", "18", 7.5),
                new Filme("John Wick: Chapter 3 - Parabellum", "Action", "18", 7.6),
                new Filme("John Wick: Chapter 4", "Action", "18", 8.2),
                new Filme("Die Hard", "Action", "18", 8.2),
                new Filme("Die Hard 2", "Action", "18", 7.1),
                new Filme("Die Hard with a Vengeance", "Action", "18", 7.6),
                new Filme("Live Free or Die Hard", "Action", "14", 7.1),
                new Filme("A Good Day to Die Hard", "Action", "14", 5.3),
                new Filme("Gladiator", "Action", "16", 8.5),
                new Filme("The Dark Knight", "Action", "14", 9.0),
                new Filme("The Dark Knight Rises", "Action", "14", 8.4),
                new Filme("Batman Begins", "Action", "14", 8.2),
                new Filme("Wonder Woman", "Action", "12", 7.4),
                new Filme("Man of Steel", "Action", "12", 7.1),
                new Filme("Batman v Superman: Dawn of Justice", "Action", "12", 6.4),
                new Filme("Justice League", "Action", "12", 6.1),
                new Filme("Zack Snyder's Justice League", "Action", "14", 8.0),
                new Filme("Spider-Man: No Way Home", "Action", "12", 8.3),
                new Filme("Spider-Man: Far From Home", "Action", "12", 7.4),
                new Filme("Spider-Man: Homecoming", "Action", "12", 7.4),
                new Filme("Doctor Strange", "Action", "12", 7.5),
                new Filme("Thor", "Action", "12", 7.0),
                new Filme("Thor: Ragnarok", "Action", "12", 7.9),
                new Filme("Thor: Love and Thunder", "Action", "12", 6.3),
                new Filme("Captain Marvel", "Action", "12", 6.8),
                new Filme("The Incredible Hulk", "Action", "12", 6.7),
                new Filme("Ant-Man", "Action", "12", 7.3),
                new Filme("Ant-Man and the Wasp", "Action", "12", 7.0),
                new Filme("Deadpool", "Action", "18", 8.0),
                new Filme("Deadpool 2", "Action", "18", 7.7),
                new Filme("Logan", "Action", "18", 8.1),
                new Filme("X-Men", "Action", "12", 7.4),
                new Filme("X2: X-Men United", "Action", "12", 7.4),
                new Filme("X-Men: The Last Stand", "Action", "12", 6.7),
                new Filme("X-Men: First Class", "Action", "12", 7.7),
                new Filme("X-Men: Days of Future Past", "Action", "12", 8.0),
                new Filme("X-Men: Apocalypse", "Action", "12", 6.9),
                new Filme("The Wolverine", "Action", "12", 6.7),
                new Filme("Fast & Furious 7", "Action", "12", 7.1),
                new Filme("Fast & Furious 8", "Action", "12", 6.7),
                new Filme("Fast & Furious 9", "Action", "12", 5.2),
                new Filme("Hobbs & Shaw", "Action", "12", 6.5),
                new Filme("Transformers", "Action", "12", 7.0),
                new Filme("Transformers: Revenge of the Fallen", "Action", "12", 6.0),
                new Filme("Transformers: Dark of the Moon", "Action", "12", 6.2),
                new Filme("Transformers: Age of Extinction", "Action", "12", 5.6),
                new Filme("Transformers: The Last Knight", "Action", "12", 5.2),
                new Filme("Bumblebee", "Action", "12", 6.7),
                new Filme("Pacific Rim", "Action", "12", 6.9),
                new Filme("Pacific Rim: Uprising", "Action", "12", 5.6),
                new Filme("RoboCop", "Action", "16", 7.5),
                new Filme("RoboCop (2014)", "Action", "14", 6.2),
                new Filme("The Matrix", "Action", "16", 8.7),
                new Filme("The Matrix Reloaded", "Action", "16", 7.2),
                new Filme("The Matrix Revolutions", "Action", "16", 6.7),
                new Filme("The Matrix Resurrections", "Action", "16", 5.7),
                new Filme("Captain America: The Winter Soldier", "Action", "12", 7.8),
                new Filme("Iron Man", "Action", "10", 7.9),
                new Filme("The Avengers", "Action", "12", 8.0),
                new Filme("Avengers: Infinity War", "Action", "12", 8.4),
                new Filme("Avengers: Endgame", "Action", "12", 8.4),
                new Filme("Black Panther", "Action", "12", 7.3),
                new Filme("Mad Max: Fury Road", "Action", "16", 8.1),
                new Filme("John Wick", "Action", "18", 7.4),
                new Filme("Inception", "Sci-Fi", "14", 8.8),
                new Filme("Interstellar", "Sci-Fi", "12", 8.6),
                new Filme("The Martian", "Sci-Fi", "12", 8.0),
                new Filme("Blade Runner 2049", "Sci-Fi", "16", 8.0),
                new Filme("The Matrix", "Sci-Fi", "16", 8.7),
                new Filme("The Matrix Reloaded", "Sci-Fi", "16", 7.2),
                new Filme("The Matrix Revolutions", "Sci-Fi", "16", 6.7),
                new Filme("The Matrix Resurrections", "Sci-Fi", "16", 5.7),
                new Filme("The Godfather", "Crime", "18", 9.2),
                new Filme("The Godfather: Part II", "Crime", "18", 9.0),
                new Filme("The Godfather: Part III", "Crime", "18", 7.6),
                new Filme("Goodfellas", "Crime", "18", 8.7),
                new Filme("The Dark Knight", "Action", "14", 9.0),
                new Filme("The Dark Knight Rises", "Action", "14", 8.4),
                new Filme("Batman Begins", "Action", "14", 8.2),
                new Filme("The Shawshank Redemption", "Drama", "14", 9.3),
                new Filme("Forrest Gump", "Drama", "12", 8.8),
                new Filme("Schindler's List", "Drama", "16", 9.0),
                new Filme("Gladiator", "Action", "16", 8.5),
                new Filme("Saving Private Ryan", "War", "16", 8.6),
                new Filme("1917", "War", "14", 8.3),
                new Filme("Dunkirk", "War", "14", 7.9),
                new Filme("Titanic", "Romance", "12", 7.9),
                new Filme("La La Land", "Romance", "12", 8.0),
                new Filme("The Notebook", "Romance", "12", 7.8),
                new Filme("Pride & Prejudice", "Romance", "12", 7.8),
                new Filme("Casablanca", "Romance", "12", 8.5),
                new Filme("Jaws", "Thriller", "14", 8.0),
                new Filme("Se7en", "Thriller", "18", 8.6),
                new Filme("Fight Club", "Thriller", "18", 8.8),
                new Filme("Pulp Fiction", "Thriller", "18", 8.9),
                new Filme("The Silence of the Lambs", "Thriller", "18", 8.6),
                new Filme("The Exorcist", "Horror", "18", 8.0),
                new Filme("Halloween", "Horror", "18", 7.8),
                new Filme("A Nightmare on Elm Street", "Horror", "18", 7.5),
                new Filme("The Conjuring", "Horror", "18", 7.5),
                new Filme("It", "Horror", "18", 7.3),
                new Filme("Finding Nemo", "Animation", "L", 8.1),
                new Filme("Toy Story", "Animation", "L", 8.3),
                new Filme("Shrek", "Animation", "L", 7.8),
                new Filme("The Lion King", "Animation", "L", 8.5),
                new Filme("Frozen", "Animation", "L", 7.4),
                new Filme("Up", "Animation", "L", 8.2)
        );

        for (Filme filme : filmes) {
            entityManager.persist(filme);
        }
        
        System.out.println("Filmes adicionaods");
    }

    public List<Filme> buscarTodosFilmes() {
        List<Filme> filmes = entityManager.createQuery("SELECT f FROM Filme f", Filme.class)
                                          .getResultList();
        System.out.println("Filmes encontrados: " + filmes.size());  // Verifique se está retornando os filmes
        return filmes;
    }
}
