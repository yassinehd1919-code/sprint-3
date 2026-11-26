package com.iset.artistes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iset.artistes.entities.Artist;
import com.iset.artistes.repos.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public Artist saveArtist(Artist a) {
        return artistRepository.save(a);
    }

    @Override
    public Artist updateArtist(Artist a) {
        return artistRepository.save(a); // save() fait un UPDATE si l'id existe déjà
    }

    @Override
    public void deleteArtistById(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist getArtist(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public List<Artist> findByCategorieId(Long idCat) {
        return artistRepository.findByCategorieId(idCat);
    }
}
