package edu.kirkwood.dao.sql;

import edu.kirkwood.model.sql.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    /**
     * Finds movies whose title contains the given text, ignoring case
     * @param title The text to look for in the title
     * @return A list of matching movies
     */
    List<MovieEntity> findByTitleContainingIgnoreCase(String title);
}
