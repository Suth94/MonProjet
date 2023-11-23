package tmdb_api;

public class Movie {

    private int movieID;
    private String title;
    private String resume;
    private String imgPATH;
    public Movie(){

    }

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
        return imgPATH;
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
