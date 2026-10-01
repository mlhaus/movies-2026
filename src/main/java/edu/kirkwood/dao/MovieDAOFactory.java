package edu.kirkwood.dao;

import java.io.InputStream;
import java.util.Properties;

public class MovieDAOFactory {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = MovieDAOFactory.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Unable to find application.properties");
            }
            props.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MovieDAO getMovieDAO() {
        String sourceType = props.getProperty("datasource.type");

        switch (sourceType.toUpperCase()) {
            case "XML":
                String apiURL = props.getProperty("xml.apiURL");
                if (apiURL == null) {
                    throw new IllegalArgumentException("XML API URL is not configured in application.properties");
                }
                return new XmlMovieDAO(apiURL);

            // other cases for JSON, MYSQL, MongoDB, etc.

            default:
                throw new IllegalArgumentException("Invalid data source type specified: " + sourceType);
        }
    }
}