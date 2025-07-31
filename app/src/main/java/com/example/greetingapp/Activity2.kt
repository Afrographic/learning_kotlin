package com.example.greetingapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Receiving Data
        val bundle:Bundle? = intent.extras
        val age = bundle?.get("age");
        val nom = bundle?.get("nom")

        Toast.makeText(this, "$nom Your age is $age",Toast.LENGTH_LONG).show();

        //Open Browser link
        val btn:Button = findViewById(R.id.button2)
        btn.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com"))
            startActivity(intent);
        }

    }
}