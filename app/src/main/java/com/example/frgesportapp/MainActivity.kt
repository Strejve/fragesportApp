package com.example.frgesportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    lateinit var fraga: TextView
    lateinit var rattEllerFel: TextView
    lateinit var alternativA: Button
    lateinit var alternativB: Button
    lateinit var alternativC: Button
    lateinit var nyFraga: Button
    lateinit var textViewPoints:TextView
    var gammalFraga: FragaBas? = null
    var playerIndex = 5
    var turnIndex = 0
    var buttonIndex = 0
    var pointsList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alternativA = findViewById(R.id.alternativA)
        alternativB = findViewById(R.id.alternativB)
        alternativC = findViewById(R.id.alternativC)
        nyFraga = findViewById(R.id.nyFraga)
        textViewPoints = findViewById(R.id.textViewPoints)

        alternativA.setVisibility(Button.GONE)
        alternativB.setVisibility(Button.GONE)
        alternativC.setVisibility(Button.GONE)

        rattEllerFel = findViewById<TextView>(R.id.rattEllerFel)
        rattEllerFel.setText("")
        val numberOfPlayers = intent.getIntExtra("numberOfPlayers", 1)
        setTurnsAndPointsList(numberOfPlayers)

        setNextPlayer(numberOfPlayers)

        nyFraga.setOnClickListener() {
            buttonIndex+=1

             if (gammalFraga!= null){
                 DataManager.forkortaBibliotek(gammalFraga!!)
             }
            gammalFraga = nyFraga(DataManager.frageBibliotek, numberOfPlayers)
            alternativA.setVisibility(Button.VISIBLE)
            alternativB.setVisibility(Button.VISIBLE)
            alternativC.setVisibility(Button.VISIBLE)
            nyFraga.setVisibility(Button.GONE)
            alternativA.isEnabled = true
            alternativB.isEnabled = true
            alternativC.isEnabled = true
        }
    }
    fun nyFraga(frageBibliotek: MutableList<FragaBas>, numberOfPlayers: Int): FragaBas{
        fraga = findViewById(R.id.fraga)
        rattEllerFel = findViewById(R.id.rattEllerFel)
        rattEllerFel.setText("")
        val currentFraga = (frageBibliotek.random())
        fraga.setText(currentFraga.fraga)
        alternativA.setText(currentFraga.A)
        alternativB.setText(currentFraga.B)
        alternativC.setText(currentFraga.C)

        showPoints(numberOfPlayers)

        alternativA.setOnClickListener()
        {
            checkAnswer(currentFraga.rattSvar,currentFraga.A)
            alternativB.setVisibility(Button.GONE)
            alternativC.setVisibility(Button.GONE)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            checkTurns(currentFraga)
            setNextPlayer(numberOfPlayers)
            alternativA.isEnabled = false
        }
        alternativB.setOnClickListener()
        {
            checkAnswer(currentFraga.rattSvar,currentFraga.B)

            alternativA.setVisibility(Button.GONE)
            alternativC.setVisibility(Button.GONE)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            checkTurns(currentFraga)
            setNextPlayer(numberOfPlayers)
            alternativB.isEnabled = false
        }

        alternativC.setOnClickListener()
        {
            checkAnswer(currentFraga.rattSvar,currentFraga.C)

            alternativB.setVisibility(Button.GONE)
            alternativA.setVisibility(Button.GONE)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            checkTurns(currentFraga)
            setNextPlayer(numberOfPlayers)
            alternativC.isEnabled = false
        }
        return currentFraga
    }


    fun startResultactivity() {
        val finalPointsArray = pointsList.toIntArray()
        intent = Intent(this, ResultsActivity::class.java)
        intent.putExtra("finalPointsArray",finalPointsArray)
        Log.d("!!!MainActivity","$finalPointsArray")
        startActivity(intent)
    }
    fun showPoints(numberOfPlayers:Int){
        var textPoints = "Player Points:\n"
        for(i in 1..numberOfPlayers){
            textPoints = textPoints + "Player $i: ${pointsList[i-1]}\n"
        }
        textViewPoints.setText(textPoints)
    }
    fun checkAnswer(rightAnswer: String,answer: String){
        if (rightAnswer == answer) {
            rattEllerFel.setText("Rätt!")
            pointsList[playerIndex-1] +=1
        } else {
            rattEllerFel.setText("Fel!")
        }
    }
    fun setNextPlayer(numberOfPlayers: Int){
        if(numberOfPlayers>1 && playerIndex<=numberOfPlayers) {
            nyFraga.setText("Spelare $playerIndex, varsågod!")
        }
        else {
            nyFraga.setText("Spelare 1, varsågod!")
            playerIndex = 1
        }
    }
    fun checkTurns(currentFraga: FragaBas){
        if (turnIndex <= buttonIndex){
            DataManager.questionsDone.add(currentFraga)
            startResultactivity()
        }
    }
    fun setTurnsAndPointsList(numberOfPlayers: Int){
        turnIndex =  numberOfPlayers * 4
        for (i in 1..numberOfPlayers) {
            pointsList.add(0)
        }
    }
}






