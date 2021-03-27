package com.example.scanlive.actvities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scanlive.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {
    String  ClaveYouTube ="AIzaSyDGSgpRax0jEUO_FIWr13TJ8vQZH3fT2dM";
    YouTubePlayerView youTubePlayerView;
    String urlVideo;
    TextView TituloVideo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        //ini
        TituloVideo = findViewById(R.id.TituloVideo);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b!=null){
        TituloVideo.setText(b.getString("TIT"));
            urlVideo=b.getString("URL");
        }

        youTubePlayerView=findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(ClaveYouTube,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        if (!fueRestaurado){
            //auqui va la url del video solo lo que esta despues de v=
            //youTubePlayer.cueVideo("Kunpa60Qmoc");
            youTubePlayer.cueVideo(urlVideo);

        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


        if (youTubeInitializationResult.isUserRecoverableError()){

            youTubeInitializationResult.getErrorDialog(this,1).show();

        }
        else {
            String mensaje = "error al iniciar Youtube"+youTubeInitializationResult.toString();
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }

    }
    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if (resultcode==1){
            getYoutubePlayerProvider().initialize(ClaveYouTube,this);

        }
    }
    protected  YouTubePlayer.Provider getYoutubePlayerProvider(){
        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

        onPlaying();

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
