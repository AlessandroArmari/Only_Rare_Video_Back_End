package com.digitazon.onlyrarevideobe.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String collectionName;

    @Column
    private String sanitizeCollectionName;

    @Column(length = 20000)
    private String collectionDescription;

    @Column(length = 20000)
    private String longCollectionDescription;

    @Column(length = 20000)
    private String collectionImage;

    @ManyToMany
    @JoinColumn
    private List<Movie> movies;

    @Column
    private boolean isComingSoon;

    public Collection(String collectionName, String sanitizeCollectionName, String collectionDescription,
            String longCollectionDescription, String collectionImage, List<Movie> movies, boolean isComingSoon) {
        this.collectionName = collectionName;
        this.sanitizeCollectionName = sanitizeCollectionName;
        this.collectionDescription = collectionDescription;
        this.longCollectionDescription = longCollectionDescription;
        this.collectionImage = collectionImage;
        this.movies = movies;
        this.isComingSoon = isComingSoon;
    }

}
