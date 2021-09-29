package com.example.frgesportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        var resultsPointsArray = intent.getIntArrayExtra("finalPointsArray")
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        var resultsText = ""
        var index = 1
        Log.d("!!!resultsNull?","$resultsPointsArray")
        for (i in resultsPointsArray!!) {
            resultsText = resultsText + "Player $index points: $i \n"
            index+=1
        }
        resultsTextView.setText(resultsText)
        if (resultsPointsArray.size == 1){
            val winnersTextView = findViewById<TextView>(R.id.winnersTextView)
            if (resultsPointsArray[0] == 0) {
                winnersTextView.setText("Alla fel! Bättre kan du.")
            }
            else if (resultsPointsArray[0] == 1) {
                winnersTextView.setText("Ett rätt! Inte så dåligt.")
            }
            else winnersTextView.setText("Alla rätt! Bra jobbat!")
        }
        else {
            val sortResultsPoints = resultsPointsArray.copyOf()
            getWinners(sortResultsPoints, resultsPointsArray)
        }
        val scrollQuestionsButton = findViewById<Button>(R.id.scrollQuestionsButton)
        scrollQuestionsButton.setOnClickListener(){
            startScrollQuestionsActivity()
        }
    }

    fun getWinners(sortResultsPoints: IntArray, resultsPointsArray:IntArray){
        for (i in 0..sortResultsPoints.size - 1) {
            if ((i + 1) > (sortResultsPoints.size - 1)) {
                break
            }
            if (sortResultsPoints[i] < sortResultsPoints[i+1] && sortResultsPoints[0] < sortResultsPoints[i + 1]) {
                sortResultsPoints[0] = sortResultsPoints[i+1]
            }
        }
        var indexWinner = 1
        var winnersList = mutableListOf<Int>()
        for (players in resultsPointsArray) {
            if (players == sortResultsPoints[0]) {
             winnersList.add(indexWinner)
            }
            indexWinner++
        }
        var winnersText = ""
        if(winnersList.size>1) {
            winnersText = "Det blev lika mellan "
            var indexSize = 1
            for (winners in winnersList) {
                if (indexSize== winnersList.size){
                    winnersText = winnersText + "och spelare $winners."
                }
                else if (indexSize == winnersList.size -1){
                    winnersText = winnersText + "spelare $winners "
                }
                else {
                    winnersText = winnersText + "spelare $winners, "
                }
                indexSize++
            }
        }
        else winnersText = "Spelare ${winnersList[0]} vann!"

        val winnersTextView = findViewById<TextView>(R.id.winnersTextView)
        winnersTextView.setText(winnersText)
    }

    fun startScrollQuestionsActivity(){
        intent = Intent(this, scrollQuestionsActivity::class.java)
        startActivity(intent)
    }
}