package com.iset.artistes.service;

import java.util.List;

import com.iset.artistes.entities.Artist;

public interface ArtistService {
    Artist saveArtist(Artist a);

    Artist updateArtist(Artist a);

    void deleteArtistById(Long id);

    Artist getArtist(Long id);

    List<Artist> getAllArtists();

    List<Artist> findByCategorieId(Long idCat);
}
