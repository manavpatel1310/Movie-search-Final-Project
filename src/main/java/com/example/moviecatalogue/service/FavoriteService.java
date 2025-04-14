package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public void addFavorite(Movie movie) {
        if (!favoriteRepository.existsById(movie.getId())) {
            favoriteRepository.save(movie);
        }
    }

    public void removeFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    public List<Movie> getFavorites() {
        return favoriteRepository.findAll();
    }

    public boolean isFavorite(Long id) {
        return favoriteRepository.existsById(id);
    }
}
