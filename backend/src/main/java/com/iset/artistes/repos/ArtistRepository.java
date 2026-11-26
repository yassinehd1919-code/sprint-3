package com.iset.artistes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iset.artistes.entities.Artist;

// Spring Data REST : http://localhost:8080/rest
@RepositoryRestResource(path = "rest")
@CrossOrigin("http://localhost:4200")
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    // http://localhost:8080/rest/search/findByNomArtisteContains?nom=a
    List<Artist> findByNomArtisteContains(@Param("nom") String nom);

    // http://localhost:8080/rest/search/findByCategorieId?id=1
    List<Artist> findByCategorieId(@Param("id") Long id);
}
