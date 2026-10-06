package edu.kirkwood;

import edu.kirkwood.dao.MovieDAO;
import edu.kirkwood.dao.MovieDAOFactory;
import edu.kirkwood.dao.XmlMovieDAO;
import edu.kirkwood.model.xml.MovieSearchResult;

import java.util.List;

public class Main {
    static void main() {
        MovieDAO movieDAO = MovieDAOFactory.getMovieDAO();
        String title = "Scream"; // Prompt the user for their search
        if(movieDAO instanceof XmlMovieDAO) {
            XmlMovieDAO xmlMovieDao = (XmlMovieDAO) movieDAO;
            List<MovieSearchResult> results = xmlMovieDao.search(title);
            results.forEach(System.out::println);
        }
    }
}
