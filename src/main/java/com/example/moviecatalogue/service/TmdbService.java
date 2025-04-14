package com.example.moviecatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.base-url}")

    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getPopularMovies() {
        String url = BASE_URL + "/movie/popular?api_key=" + apiKey;
        MovieResponse response = restTemplate.getForObject(url, MovieResponse.class);
        return response.getResults();
    }

    public List<Movie> searchMovies(String query) {
        String url = BASE_URL + "/search/movie?api_key=" + apiKey + "&query=" + query;
        MovieResponse response = restTemplate.getForObject(url, MovieResponse.class);
        return response.getResults();
    }

    public Movie getMovieDetails(Long movieId) {
        String url = BASE_URL + "/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, Movie.class);
    }
}
