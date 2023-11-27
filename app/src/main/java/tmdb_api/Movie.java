package tmdb_api;

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


    protected Movie(Parcel in) {
        movieID = in.readInt();
        title = in.readString();
        resume = in.readString();
        imgPATH = in.readString();
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
    }
}