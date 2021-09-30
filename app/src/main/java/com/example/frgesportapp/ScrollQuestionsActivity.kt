package com.example.frgesportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScrollQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_questions)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        //skapa en adapter från vår adapter-klass, skicka med vår lista
        val adapter = ScrollQuestionsAdapter(this,DataManager.questionsDone)

        //koppla ihop vår adapter med recyclerView:n
        recyclerView.adapter = adapter

        val playAgain = findViewById<Button>(R.id.playAgain)
        playAgain.setOnClickListener(){
            DataManager.newGameAddLists()
            intent = Intent(this, StartupActivity::class.java)
            startActivity(intent)
        }

    }
}