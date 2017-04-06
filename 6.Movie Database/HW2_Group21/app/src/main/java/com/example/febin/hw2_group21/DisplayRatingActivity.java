package com.example.febin.hw2_group21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisplayRatingActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewDescription;
    TextView textViewGenre;
    TextView textViewRating;
    TextView textViewYear;
    TextView textViewLink;
    int page=0;
    int size;
    ImageButton imageButtonFirst;
    ImageButton imageButtonPrevious;
    ImageButton imageButtonNext;
    ImageButton imageButtonLast;
    ArrayList<Movies> moviesYear=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rating);
        setTitle("Movies by Rating");

        moviesYear=(ArrayList<Movies>)getIntent().getSerializableExtra(MainActivity.MOVIE_LIST);
        size=moviesYear.size();
        textViewTitle =(TextView)findViewById(R.id.textViewTitleValueRating);
        textViewDescription =(TextView)findViewById(R.id.textViewDesValueRating);
        textViewGenre =(TextView)findViewById(R.id.textViewGenreValueRating);
        textViewRating =(TextView)findViewById(R.id.textViewRatingValueRating);
        textViewYear =(TextView)findViewById(R.id.textViewYearvalueRating);
        textViewLink =(TextView)findViewById(R.id.textViewLinkValueRating);

        Collections.sort(moviesYear, new Comparator<Movies>() {
            @Override
            public int compare(Movies o1, Movies o2) {
                return o1.getRating()-(o2.getRating());
            }
        });
        textViewTitle.setText(moviesYear.get(page).getName());
        textViewDescription.setText(moviesYear.get(page).getDescription());
        textViewGenre.setText(moviesYear.get(page).getGenre());
        textViewRating.setText(""+moviesYear.get(page).getRating());
        textViewYear.setText(""+moviesYear.get(page).getYear());
        textViewLink.setText(moviesYear.get(page).getLink());
    }

    public void finishButtonRating(View view)
    {
        finish();
    }
    public void clickFirstRating(View view)
    {
        if(page==0)
        {
            Toast.makeText(getApplicationContext(),"Already Displaying the first Movie",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=0;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickPreviousRating(View view)
    {
        if(page==0)
        {
            Toast.makeText(getApplicationContext(),"There is no previous movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=page-1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickNextRating(View view)
    {
        if(page==size-1)
        {
            Toast.makeText(getApplicationContext(),"There is no next movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=page+1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
    public void clickLastRating(View view)
    {
        if(page==size-1)
        {
            Toast.makeText(getApplicationContext(),"There is no next movie to display",Toast.LENGTH_SHORT).show();
        }
        else
        {
            page=size-1;
            textViewTitle.setText(moviesYear.get(page).getName());
            textViewDescription.setText(moviesYear.get(page).getDescription());
            textViewGenre.setText(moviesYear.get(page).getGenre());
            textViewRating.setText(""+moviesYear.get(page).getRating());
            textViewYear.setText(""+moviesYear.get(page).getYear());
            textViewLink.setText(moviesYear.get(page).getLink());
        }
    }
}
