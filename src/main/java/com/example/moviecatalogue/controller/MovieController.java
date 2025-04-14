package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.service.MovieService;
import com.example.moviecatalogue.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/")
    public String home(Model model) {
        List<Movie> movies = movieService.getPopularMovies();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Movie> movies = movieService.searchMovies(query);
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/movie/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieDetails(id);
        model.addAttribute("movie", movie);
        model.addAttribute("isFavorite", favoriteService.isFavorite(id));
        return "detail";
    }

    @PostMapping("/favorite/{id}")
    public String addToFavorites(@PathVariable Long id) {
        Movie movie = movieService.getMovieDetails(id);
        favoriteService.addFavorite(movie);
        return "redirect:/movie/" + id;
    }

    @PostMapping("/unfavorite/{id}")
    public String removeFromFavorites(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
        return "redirect:/movie/" + id;
    }

    @GetMapping("/favorites")
    public String showFavorites(Model model) {
        List<Movie> favorites = favoriteService.getFavorites();
        model.addAttribute("favorites", favorites);
        return "favorites";
    }
}
