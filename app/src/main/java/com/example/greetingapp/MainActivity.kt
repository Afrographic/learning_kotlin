package com.example.greetingapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishBtn:Button = findViewById(R.id.wish_btn)
        val welcomeText:TextView = findViewById(R.id.welcomeText);
        val nameInput:EditText = findViewById(R.id.nameInput);


        wishBtn.setOnClickListener(){
            val name = nameInput.text

            //Explicit Intent
            var i:Intent = Intent(this,MusicPlayer::class.java);
            i.putExtra("name",name);
            startActivity(i);
        }

        // Change Kotlin Color
        var color:Int = resources.getColor(R.color.cyan);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }


}