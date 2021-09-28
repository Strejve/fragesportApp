package com.example.frgesportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class scrollQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_questions)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        //skapa en adapter från vår adapter-klass, skicka med vår lista
        val adapter = scrollQuestionsAdapter(this,questionsDone)

        //koppla ihop vår adapter med recyclerView:n
        recyclerView.adapter = adapter

    }
}