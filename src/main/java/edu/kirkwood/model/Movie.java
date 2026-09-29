package edu.kirkwood.model;

import java.util.Objects;

// A simple Plain Old Java Object (POJO)
public class Movie implements Comparable<Movie> {
    private String id;
    private String title;
    private int releaseYear;

    public Movie() {
    }

    public Movie(String id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    /**
     * Compares two Movie objects by their release year (0-9), then title (A-Z)
     * @param o The other Movie being compared
     * @return an integer, in order if less than or equal to 0, not in order if greater than 0
     */
    @Override
    public int compareTo(Movie o) {
        int result = Integer.compare(this.releaseYear, o.getReleaseYear());
        if(result == 0) {
            result = this.title.compareTo(o.title);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear);
    }
}