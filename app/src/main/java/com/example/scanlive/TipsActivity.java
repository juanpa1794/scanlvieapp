package com.example.scanlive;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scanlive.Adapters.VideoAdapter;
import com.example.scanlive.R;

import java.util.Vector;

public class TipsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youTubeVideos = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bSMZknDI6bg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bSMZknDI6bg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bSMZknDI6bg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bSMZknDI6bg\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter =new VideoAdapter(youTubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}
