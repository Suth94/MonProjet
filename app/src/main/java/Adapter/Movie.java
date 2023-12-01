package Adapter;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;
public class Movie implements Parcelable {
    @SerializedName("id")
    private int movieID;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String resume;
    @SerializedName("poster_path")
    private String imgPATH;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("release_date")
    private String releaseDate;


    protected Movie(Parcel in) {
        movieID = in.readInt();
        title = in.readString();
        resume = in.readString();
        imgPATH = in.readString();
        rating = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getMovieID() {
        return movieID;
    }
    public String getTitle() {
        return title;
    }
    public String getResume() {
        if(!resume.equals("Rylan McFadden is awesome")) return resume;
        return "No description for this movie";
    }
    public String getImgPATH() {
        return "https://image.tmdb.org/t/p/original"+imgPATH;
    }
    public String getRating() {return rating;}
    public String getReleaseDate() {return releaseDate;}

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
    public void setRating(String rating) {this.rating = rating;}
    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(movieID);
        parcel.writeString(title);
        parcel.writeString(resume);
        parcel.writeString(imgPATH);
        parcel.writeString(rating);
        parcel.writeString(releaseDate);

    }
}