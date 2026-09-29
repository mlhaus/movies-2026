package edu.kirkwood.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class MovieSearchResult {
    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "year")
    private String year;

    @XmlAttribute(name = "imdbID")
    private String imdbID;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "poster")
    private String poster;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "MovieSearchResult{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}