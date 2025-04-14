package com.example.moviecatalogue.model;

import lombok.Data;
import java.util.List;

@Data
public class MovieResponse {
    private int page;
    private List<Movie> results;
}