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
        val resultsPointsArray = intent.getIntArrayExtra("finalPointsArray")
        //Log.d("!!!resultsNull?","$resultsPointsArray")

        showFinalPoints(resultsPointsArray!!)

        if (resultsPointsArray.size == 1){
            singlePlayerComment(resultsPointsArray)
        }
        else {
            val winnersList = getWinners(resultsPointsArray)
            printWinners(winnersList)
        }
        val scrollQuestionsButton = findViewById<Button>(R.id.scrollQuestionsButton)
        scrollQuestionsButton.setOnClickListener(){
            startScrollQuestionsActivity()
        }
    }
    fun showFinalPoints(resultsPointsArray: IntArray){
        var index = 1
        var resultsText = ""
        for (i in resultsPointsArray) {
            resultsText = resultsText + "Player $index points: $i \n"
            index+=1
        }
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        resultsTextView.setText(resultsText)
    }

    fun singlePlayerComment(resultsPointsArray: IntArray){

        val winnersTextView = findViewById<TextView>(R.id.winnersTextView)
        if (resultsPointsArray[0] == 0) {
            winnersTextView.setText("Alla fel! Bättre kan du.")
        }
        else if (resultsPointsArray[0] >= 1 && resultsPointsArray[0]<4) {
            winnersTextView.setText("Inte så dåligt!")
        }
        else winnersTextView.setText("Alla rätt! Bra jobbat!")
    }

    fun getWinners(resultsPointsArray:IntArray): MutableList<Int> {
        val sortResultsPoints = resultsPointsArray.copyOf()
        for (i in 0..sortResultsPoints.size - 1) {
            if ((i + 1) > (sortResultsPoints.size - 1)) {
                break
            }
            if (sortResultsPoints[i] < sortResultsPoints[i + 1] && sortResultsPoints[0] < sortResultsPoints[i + 1]) {
                sortResultsPoints[0] = sortResultsPoints[i + 1]
            }
        }
        var indexWinner = 1
        val winnersList = mutableListOf<Int>()
        for (players in resultsPointsArray) {
            if (players == sortResultsPoints[0]) {
                winnersList.add(indexWinner)
            }
            indexWinner++
        }
        return winnersList
    }
    fun printWinners(winnersList:MutableList<Int>){
        var winnersText :String
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
        intent = Intent(this, ScrollQuestionsActivity::class.java)
        startActivity(intent)
    }
}