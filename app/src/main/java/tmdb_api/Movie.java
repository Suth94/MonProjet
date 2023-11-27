package tmdb_api;

import com.google.gson.annotations.SerializedName;
public class Movie {
    @SerializedName("id")
    private int movieID;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String resume;
    @SerializedName("poster_path")
    private String imgPATH;


    public int getMovieID() {
        return movieID;
    }
    public String getTitle() {
        return title;
    }
    public String getResume() {
        return resume;
    }
    public String getImgPATH() {
        return "https://image.tmdb.org/t/p/original"+imgPATH;
    }
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }
    public void setImgPATH(String imgPATH) {
        this.imgPATH = imgPATH;
    }
}