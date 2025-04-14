package com.example.moviecatalogue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "favorites")
public class Movie {
    @Id
    private Long id;
    private String title;
    private String overview;
    private String release_date;
    private double vote_average;
    private String poster_path;

    public String getPosterUrl() {
        return "https://image.tmdb.org/t/p/w500" + poster_path;
    }
}
