package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private final String BASE_URL = "https://api.themoviedb.org/3";

    public List<Movie> getPopularMovies() {
        String url = BASE_URL + "/movie/popular?api_key=" + apiKey;
        MovieResponse response = restTemplate.getForObject(url, MovieResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    public List<Movie> searchMovies(String query) {
        String url = BASE_URL + "/search/movie?api_key=" + apiKey + "&query=" + query;
        MovieResponse response = restTemplate.getForObject(url, MovieResponse.class);
        return response != null ? response.getResults() : List.of();
    }

    public Movie getMovieDetails(Long id) {
        String url = BASE_URL + "/movie/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, Movie.class);
    }
}
