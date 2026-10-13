package edu.kirkwood.dao;

import edu.kirkwood.model.json.MovieSearchResult;

import java.util.List;

public class JsonMovieDAO implements MovieDAO<MovieSearchResult> {
    private String apiURL;
    private String apiToken;

    public JsonMovieDAO(String apiURL, String apiToken) {
        this.apiURL = apiURL;
        this.apiToken = apiToken;
    }

    /**
     * Retrieves all movies from the data source that match the title
     *
     * @param title The title of the movie
     * @return A list of all movies that match the title
     */
    @Override
    public List<MovieSearchResult> search(String title) {
        return List.of();
    }
}
