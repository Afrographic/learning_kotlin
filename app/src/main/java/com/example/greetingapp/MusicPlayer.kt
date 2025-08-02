package com.example.greetingapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.TimeUnit

class MusicPlayer : AppCompatActivity() {

    //Media Player Finaltime and startTime
    lateinit var mediaPlayer:MediaPlayer ;
    lateinit var handler: Handler;
    lateinit var time_left:TextView;
    lateinit var seekBar:SeekBar;

    val SEEK_INTERVAL = 3000; // 3 Seconds
    var finalTime:Double = 0.0;
    var currentTime:Double = 0.0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music_player)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        time_left = findViewById(R.id.time_left);
        val song_title: TextView = findViewById(R.id.song_title);
        seekBar = findViewById(R.id.seek_bar);
        val play_btn:Button = findViewById(R.id.play_btn);
        val pause_btn:Button = findViewById(R.id.pause_btn);
        val backward_btn:Button = findViewById(R.id.back_btn);
        val forward_btn:Button = findViewById(R.id.forward_btn);


        var onTimeOnly:Int = 0;


        //Media Player
        mediaPlayer = MediaPlayer.create(this,R.raw.booba_jsx_gta);
        handler = Handler(Looper.getMainLooper());

        seekBar.max = mediaPlayer.duration;

        //Features of buttons
        play_btn.setOnClickListener(){
            if(!mediaPlayer.isPlaying) {
                mediaPlayer.start();
                updateElapsedTime();
            }
        }

        pause_btn.setOnClickListener(){
            if(mediaPlayer.isPlaying){
               mediaPlayer.pause();
            }
        }

        forward_btn.setOnClickListener(){
            val newPosition = mediaPlayer.currentPosition + SEEK_INTERVAL;
            mediaPlayer.seekTo(newPosition.coerceAtMost(mediaPlayer.duration))
        }

        backward_btn.setOnClickListener(){
            val newPosition = mediaPlayer.currentPosition - SEEK_INTERVAL;
            mediaPlayer.seekTo(newPosition.coerceAtLeast(0))
        }

        //Update player on user drag
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                    time_left.text = formatTime(progress.toLong())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }


    private fun updateElapsedTime(){
        handler.postDelayed(object:Runnable{
            override fun run() {
                if(mediaPlayer.isPlaying){
                    val elapsed = mediaPlayer.currentPosition.toLong();
                    time_left.text = formatTime(elapsed);
                    val currentPos = mediaPlayer.currentPosition;
                    seekBar.progress = currentPos;
                    handler.postDelayed(this,1000);
                }
            }
        },0)
    }

    private fun formatTime(milliseconds:Long):String{
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;
        return String.format("%02d:%02d",minutes,seconds);
    }


    override fun onDestroy() {
        super.onDestroy()
        if(mediaPlayer.isPlaying){
            mediaPlayer.stop();
        }
        handler.removeCallbacksAndMessages(null);
        mediaPlayer.release()
    }


}