package edu.kirkwood.dao;

import edu.kirkwood.model.Movie;

import java.util.List;

public interface MovieDAO<T> {

    /**
     * Retrieves all movies from the data source that match the title
     * @param title The title of the movie
     * @return A list of all movies that match the title
     */
    List<T> search(String title);
}
