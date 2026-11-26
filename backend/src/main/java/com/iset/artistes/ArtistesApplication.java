package com.iset.artistes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.iset.artistes.entities.Artist;
import com.iset.artistes.entities.Categorie;
import com.iset.artistes.repos.ArtistRepository;
import com.iset.artistes.repos.CategorieRepository;

@SpringBootApplication
public class ArtistesApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public static void main(String[] args) {
        SpringApplication.run(ArtistesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Spring Data REST ne renvoie pas les id par défaut : on les expose pour Angular
        repositoryRestConfiguration.exposeIdsFor(Artist.class, Categorie.class);

        // Données de départ (créées seulement si les tables sont vides)
        if (categorieRepository.count() == 0) {
            categorieRepository.save(new Categorie("rap"));
            categorieRepository.save(new Categorie("pop"));
            categorieRepository.save(new Categorie("chant"));
        }
        if (artistRepository.count() == 0) {
            Categorie rap = categorieRepository.findAll().get(0);
            Categorie pop = categorieRepository.findAll().get(1);
            artistRepository.save(new Artist("Artiste exemple 1", LocalDate.of(2015, 3, 1), 3, rap));
            artistRepository.save(new Artist("Artiste exemple 2", LocalDate.of(2018, 9, 15), 2, pop));
        }
    }
}
