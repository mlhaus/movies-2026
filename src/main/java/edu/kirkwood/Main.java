package edu.kirkwood;

import edu.kirkwood.dao.*;
import edu.kirkwood.dao.json.JsonMovieDAO;
import edu.kirkwood.dao.xml.XmlMovieDAO;

import java.util.List;

public class Main {
    static void main() {
        MovieDAO movieDAO = MovieDAOFactory.getMovieDAO();
        String title = "Scream"; // Prompt the user for their search
        if(movieDAO instanceof XmlMovieDAO) {
            XmlMovieDAO xmlMovieDao = (XmlMovieDAO) movieDAO;
            List<edu.kirkwood.model.xml.MovieSearchResult> results = xmlMovieDao.search(title);
            results.forEach(System.out::println);
        } else if(movieDAO instanceof JsonMovieDAO) {
            JsonMovieDAO jsonMovieDao = (JsonMovieDAO) movieDAO;
            List<edu.kirkwood.model.json.MovieSearchResult> results = jsonMovieDao.search(title);
            results.forEach(System.out::println);
        }
    }
}
