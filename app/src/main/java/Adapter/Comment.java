package Adapter;

import android.text.TextUtils;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

/**
 * Model POJO for a rating.
 */

public class Comment {

    private double rating;
    private @ServerTimestamp Date timestamp;




        private String content;
        private String author;

        public Comment() {
            // Constructeur par défaut requis pour Firebase
        }

        public Comment(String content, String author) {
            this.content = content;
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

