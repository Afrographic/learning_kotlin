package com.example.greetingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       var btn:Button = findViewById(R.id.btn);
//        btn.setOnClickListener(){
//
//            //Explicit Intents to direct to the second Activity
//            var i:Intent = Intent(this,Activity2::class.java);
//
//            //Passing Data between activities
//            i.putExtra("nom","Tesse brunel");
//            i.putExtra("age",56);
//
//            startActivity(i);
//        }
    }


}