package edu.kirkwood.model.xml;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class OmdbMovieResponse {
    @XmlAttribute(name = "totalResults")
    private int totalResults;
    @XmlAttribute(name = "response")
    private String response;
    @XmlElement(name = "result")
    List<MovieSearchResult> searchResults;

    public int getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public List<MovieSearchResult> getSearchResults() {
        return searchResults;
    }
}
