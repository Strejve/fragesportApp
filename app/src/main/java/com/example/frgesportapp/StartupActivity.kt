package com.example.frgesportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartupActivity : AppCompatActivity() {
    lateinit var spelare1: Button
    lateinit var spelare2: Button
    lateinit var spelare3: Button
    lateinit var spelare4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
        var spelare1 = findViewById<Button>(R.id.button1p)
        var spelare2 = findViewById<Button>(R.id.button2p)
        var spelare3 = findViewById<Button>(R.id.button3p)
        var spelare4 = findViewById<Button>(R.id.button4p)

        spelare1.setOnClickListener(){
        var numberOfPlayers = 1
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("numberOfPlayers",numberOfPlayers)
            startActivity(intent)
        }
        spelare2.setOnClickListener(){
            var numberOfPlayers = 2
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("numberOfPlayers",numberOfPlayers)
            startActivity(intent)
        }
        spelare3.setOnClickListener(){
            var numberOfPlayers = 3
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("numberOfPlayers",numberOfPlayers)
            startActivity(intent)
        }
        spelare4.setOnClickListener(){
            var numberOfPlayers = 4
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("numberOfPlayers",numberOfPlayers)
            startActivity(intent)
        }

    }
}