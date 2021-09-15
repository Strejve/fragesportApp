package com.example.frgesportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    val fraga1: FragaBas = FragaBas("Hur många säten har en formula 1 bil", "4", "3", "1", "1")
    val fraga2: FragaBas = FragaBas(
        "8 Juni 2014 döptes Prinsessan Leonore. Vilka förnamn döptes hon till?",
        "Leonore, Lilian, Maria",
        "Leonore, Josephine,Alice",
        "Lenore, Désireé, Mary",
        "Leonore, Lilian, Maria"
    )
    val fraga3: FragaBas =
        FragaBas("Hur många lingon finns det i världen?", "3", "1", "120000000", "3")
    val fraga4: FragaBas = FragaBas(
        "På den fiktiva planeten Stankilorius luktar det lite suspekt. Vad är det som luktar där?",
        "En rövargubbes andedräkt",
        "En burk surströmming",
        "Tre små lingon",
        "Tre små lingon"
    )
    var frageBibliotek = mutableListOf<FragaBas>(fraga1, fraga2, fraga3, fraga4)


    lateinit var fraga: TextView
    lateinit var rattEllerFel: TextView
    lateinit var alternativA: Button
    lateinit var alternativB: Button
    lateinit var alternativC: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nyfraga = findViewById<Button>(R.id.nyFraga)
        nyfraga.setOnClickListener {

            NyFraga(frageBibliotek)
            rattEllerFel = findViewById<TextView>(R.id.rattEllerFel)
            rattEllerFel.setText("")
        }
    }

    fun NyFraga(frageBibliotek: MutableList<FragaBas>) {
        fraga = findViewById<TextView>(R.id.fraga)
        var currentFraga = (frageBibliotek.random())
        var fragaText = currentFraga.FragaInfo()
        fraga.setText(fragaText)
        alternativA = findViewById<Button>(R.id.alternativA)
        alternativB = findViewById<Button>(R.id.alternativB)
        alternativC = findViewById<Button>(R.id.alternativC)
        alternativA.setText(currentFraga.Alternativ("A"))
        alternativB.setText(currentFraga.Alternativ("B"))
        alternativC.setText(currentFraga.Alternativ("C"))

        alternativA.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativA.text) {
                rattEllerFel.setText("Rätt!")
            } else
                rattEllerFel.setText("Fel!")
        }
        alternativB.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativB.text) {
                rattEllerFel.setText("Rätt!")
            } else {
                rattEllerFel.setText("Fel!")
            }

        }
        alternativC.setOnClickListener()
        {
            if (currentFraga.rattSvar == alternativC.text) {
                rattEllerFel.setText("Rätt!")
            } else
                rattEllerFel.setText("Fel!")
        }
    }
}




