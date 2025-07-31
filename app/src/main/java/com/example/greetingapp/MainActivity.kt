package com.example.greetingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
            var i:Intent = Intent(this,LuckyNumber::class.java);
            i.putExtra("name",name);
            startActivity(i);
        }




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