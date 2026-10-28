package edu.kirkwood.model.sql;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "year", nullable = false)
    private int releaseYear;

    @Column(columnDefinition = "TEXT")
    private String plot;

    public MovieEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getPlot() {
        return plot;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", plot='" + plot + '\'' +
                '}';
    }
}
