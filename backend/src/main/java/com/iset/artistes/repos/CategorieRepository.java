package com.iset.artistes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iset.artistes.entities.Categorie;

// Spring Data REST : http://localhost:8080/cat
// Angular lit la réponse dans _embedded.categories
@RepositoryRestResource(path = "cat", collectionResourceRel = "categories")
@CrossOrigin("http://localhost:4200") // pour autoriser Angular
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
