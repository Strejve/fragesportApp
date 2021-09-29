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
    lateinit var textViewPoints:TextView
    var numberOfPlayers = 1
    var gammalFraga: FragaBas? = null
    var playerIndex = 1
    var turnIndex = 0
    var buttonIndex = 0
    var pointsList = mutableListOf<Int>()
    var questionsDone = mutableListOf<FragaBas>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alternativA = findViewById(R.id.alternativA)
        alternativB = findViewById(R.id.alternativB)
        alternativC = findViewById(R.id.alternativC)

        alternativA.setVisibility(Button.GONE)
        alternativB.setVisibility(Button.GONE)
        alternativC.setVisibility(Button.GONE)

        rattEllerFel = findViewById<TextView>(R.id.rattEllerFel)
        rattEllerFel.setText("")
        numberOfPlayers = intent.getIntExtra("numberOfPlayers", 1)
        turnIndex =  numberOfPlayers * 2
        for (i in 1..numberOfPlayers){
            pointsList.add(0)
        }
        var nyFraga = findViewById<Button>(R.id.nyFraga)
        nyFraga.setText("Spelare1, varsågod!")

        nyFraga.setOnClickListener() {
            buttonIndex+=1

             if (gammalFraga!= null){
                 DataManager.questionsDone.add(gammalFraga!!)
                 DataManager.frageBibliotek = forkortaBibliotek(gammalFraga!!, DataManager.frageBibliotek)
             }
            gammalFraga = NyFraga(DataManager.frageBibliotek)
            alternativA.setVisibility(Button.VISIBLE)
            alternativB.setVisibility(Button.VISIBLE)
            alternativC.setVisibility(Button.VISIBLE)
            nyFraga.setVisibility(Button.GONE)
            alternativA.isEnabled = true
            alternativB.isEnabled = true
            alternativC.isEnabled = true
        }
    }
    fun NyFraga(frageBibliotek: MutableList<FragaBas>): FragaBas{
        fraga = findViewById<TextView>(R.id.fraga)
        rattEllerFel = findViewById<TextView>(R.id.rattEllerFel)
        rattEllerFel.setText("")
        var currentFraga = (frageBibliotek.random())
        var fragaText = currentFraga.FragaInfo()
        fraga.setText(fragaText)
        alternativA = findViewById(R.id.alternativA)
        alternativB = findViewById(R.id.alternativB)
        alternativC = findViewById(R.id.alternativC)
        alternativA.setText(currentFraga.Alternativ("A"))
        alternativB.setText(currentFraga.Alternativ("B"))
        alternativC.setText(currentFraga.Alternativ("C"))

        textViewPoints = findViewById(R.id.textViewPoints)
         var textPoints = "Player Points:\n"
        for(i in 1..numberOfPlayers){
            textPoints = textPoints + "Player $i: ${pointsList[i-1]}\n"
        }
        textViewPoints.setText(textPoints)

        alternativA.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativA.text) {
                rattEllerFel.setText("Rätt!")
                pointsList[playerIndex-1] +=1
            } else {
                rattEllerFel.setText("Fel!")
            }
            alternativB.setVisibility(Button.GONE)
            alternativC.setVisibility(Button.GONE)
            var nyFraga = findViewById<Button>(R.id.nyFraga)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            if(numberOfPlayers>1 && playerIndex<=numberOfPlayers) {
                nyFraga.setText("Spelare $playerIndex, varsågod!")
            }
            else {
                nyFraga.setText("Spelare 1, varsågod!")
                playerIndex = 1
            }
            if (turnIndex <= buttonIndex){
                DataManager.questionsDone.add(currentFraga)
                startResultactivity()
            }
            alternativA.isEnabled = false
        }
        alternativB.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativB.text) {
                rattEllerFel.setText("Rätt!")
                pointsList[playerIndex-1] +=1
            } else {
                rattEllerFel.setText("Fel!")
            }
            alternativA.setVisibility(Button.GONE)
            alternativC.setVisibility(Button.GONE)
            var nyFraga = findViewById<Button>(R.id.nyFraga)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            if(numberOfPlayers>1 && playerIndex<=numberOfPlayers) {
                nyFraga.setText("Spelare $playerIndex, varsågod!")
            }
            else {
                nyFraga.setText("Spelare 1, varsågod!")
                playerIndex = 1
            }
            if (turnIndex <= buttonIndex){
                DataManager.questionsDone.add(currentFraga)
                startResultactivity()
            }
            alternativB.isEnabled = false
        }

        alternativC.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativC.text) {
                rattEllerFel.setText("Rätt!")
                pointsList[playerIndex-1] +=1
            } else {
                rattEllerFel.setText("Fel!")
            }
            alternativB.setVisibility(Button.GONE)
            alternativA.setVisibility(Button.GONE)
            var nyFraga = findViewById<Button>(R.id.nyFraga)
            nyFraga.setVisibility(Button.VISIBLE)
            playerIndex+=1
            if (turnIndex <= buttonIndex){
                DataManager.questionsDone.add(currentFraga)
                startResultactivity()
            }
            else if(numberOfPlayers>1 && playerIndex<=numberOfPlayers) {

                    nyFraga.setText("Spelare $playerIndex, varsågod!")
            }
            else {
                nyFraga.setText("Spelare 1, varsågod!")
                playerIndex = 1
            }
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

    fun forkortaBibliotek(gammalFraga: FragaBas, frageBibliotek: MutableList<FragaBas>)
    : MutableList<FragaBas> {
        for (question in frageBibliotek) {
            if (gammalFraga == question) {
                frageBibliotek.remove(question)
                break
            }
        }
        return frageBibliotek
    }
}






