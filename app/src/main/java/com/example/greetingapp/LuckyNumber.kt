package com.example.greetingapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class LuckyNumber : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lucky_number)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val luckyNumText:TextView = findViewById(R.id.luckyNumText);
        val shareBtn:Button = findViewById(R.id.shareBtn);
        val userName:TextView = findViewById(R.id.userName);

        var username = receiveUserName();
        userName.text = username;

        var randomNum = generateRandomNum();
        luckyNumText.text = randomNum.toString();

        shareBtn.setOnClickListener(){
            shareData(username,randomNum);
        }

    }


    fun receiveUserName():String{
        var bundle:Bundle? = intent.extras;
        var username = bundle?.get("name").toString();
        return username;
    }

    fun generateRandomNum():Int{
        val random = Random.nextInt(1000);
        return random;
    }

    //Sharing the username & number
    fun shareData(username:String,num:Int){
        var i:Intent = Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,"$username is Lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is $num");
        startActivity(i);
    }
}