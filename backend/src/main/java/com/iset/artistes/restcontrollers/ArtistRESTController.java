package com.iset.artistes.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iset.artistes.entities.Artist;
import com.iset.artistes.service.ArtistService;

// URL de base : http://localhost:8080/api
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtistRESTController {

    @Autowired
    ArtistService artistService;

    @GetMapping()
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable("id") Long id) {
        return artistService.getArtist(id);
    }

    @PostMapping()
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping()
    public Artist updateArtist(@RequestBody Artist artist) {
        return artistService.updateArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable("id") Long id) {
        artistService.deleteArtistById(id);
    }

    @GetMapping("/artistscat/{idCat}")
    public List<Artist> getArtistsByCatId(@PathVariable("idCat") Long idCat) {
        return artistService.findByCategorieId(idCat);
    }
}
