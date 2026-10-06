package edu.kirkwood.dao;

import edu.kirkwood.model.Movie;

import java.util.List;

public interface MovieDAO<T> {

    /**
     * Find a single movie by its unique ID
     * @param id The ID of the movie to find
     * @return The single movie object, or null if not found
     */
    T findById(String id);

    /**
     * Retrieves all movies from the data source that match the title
     * @param title The title of the movie
     * @return A list of all movies that match the title
     */
    List<T> search(String title);
}
