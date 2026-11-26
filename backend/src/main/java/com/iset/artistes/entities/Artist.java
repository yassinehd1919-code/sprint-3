package com.iset.artistes.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomArtiste;

    private LocalDate dateDebut; // JSON : "2010-05-01"

    private int nombreAlbums;

    @ManyToOne
    private Categorie categorie;

    public Artist() {
    }

    public Artist(String nomArtiste, LocalDate dateDebut, int nombreAlbums, Categorie categorie) {
        this.nomArtiste = nomArtiste;
        this.dateDebut = dateDebut;
        this.nombreAlbums = nombreAlbums;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNombreAlbums() {
        return nombreAlbums;
    }

    public void setNombreAlbums(int nombreAlbums) {
        this.nombreAlbums = nombreAlbums;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
