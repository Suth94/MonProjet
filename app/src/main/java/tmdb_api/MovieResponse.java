package tmdb_api;

import com.google.gson.annotations.SerializedName;
import java.util.List;

import Adapter.Movie;

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
}
