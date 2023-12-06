package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.helloworld.MovieDetail;
import com.example.helloworld.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

        private Context context;
        private List<Movie> movies;

        public MovieAdapter(Context context , List<Movie> movies){
            this.context = context;
            this.movies = movies;
        }
        @NonNull
        @Override
        public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.movie_preview , parent , false);
            return new MovieHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

            Movie movie = movies.get(position);
            Glide.with(context).load(movie.getImgPATH()).into(holder.imageView);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MovieDetail.class);
                    intent.putExtra("movie",movie);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        public class MovieHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            ConstraintLayout constraintLayout;
            public MovieHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.img);
                constraintLayout = itemView.findViewById(R.id.film);
            }
        }
    }
