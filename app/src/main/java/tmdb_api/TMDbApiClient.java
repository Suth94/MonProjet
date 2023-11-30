package tmdb_api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TMDbApiClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "929a55fb4582fe8bef819daa7c4d3d26";
    private static TMDbApiInterface apiInterface;
    private static List<Movie> movies = new ArrayList<Movie>();
    public static TMDbApiInterface getClient() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(TMDbApiInterface.class);
        }
        return apiInterface;
    }
    public static String getApiKey() {
        return API_KEY;
    }


}

