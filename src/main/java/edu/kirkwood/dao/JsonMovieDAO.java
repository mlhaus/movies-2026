package edu.kirkwood.dao;

import com.google.gson.*;
import edu.kirkwood.model.json.MovieSearchResult;

import edu.kirkwood.model.json.TmdbMovieResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
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
        String responseBody = fetchRawData(title);
        // prettyPrintResponse(responseBody);
        Gson gson = new GsonBuilder().create();
        TmdbMovieResponse movieResponse = null;
        try {
            movieResponse = gson.fromJson(responseBody, TmdbMovieResponse.class);
        } catch(JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
        return movieResponse.getResults();
    }

    public void prettyPrintResponse(String responseBody) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        JsonElement jsonElement = new JsonParser().parse(responseBody);
        String json = gson.toJson(jsonElement);
        System.out.print(json);
    }

    public String fetchRawData(String title) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiURL + title)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiToken)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch(IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        String responseBody = "";
        try {
            responseBody = response.body().string();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return responseBody;
    }
}
