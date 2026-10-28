package edu.kirkwood.dao.sql;

import edu.kirkwood.dao.MovieDAO;
import edu.kirkwood.model.sql.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQLMovieDAO implements MovieDAO<MovieEntity> {
    private final MovieRepository movieRepository;

    public SQLMovieDAO(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Retrieves all movies from the data source that match the title
     *
     * @param title The title of the movie
     * @return A list of all movies that match the title
     */
    @Override
    public List<MovieEntity> search(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
}
