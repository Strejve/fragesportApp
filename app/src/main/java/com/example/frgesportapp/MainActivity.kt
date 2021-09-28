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
    val fraga5: FragaBas = FragaBas("Nelson Mandela dömdes till livstid fängelse 1964. Vad heter ön utanför Kapstaden, Sydafrika där han satt fängslad?"
        ,"Robben Island","Bornholm","Gran Canaria","Robben Island")
    val fraga6 = FragaBas("Vilken skådespelare hade huvudrollen i filmen \"den siste scouten\" (The Last Boy Scout) från 1991?"
            ,"Tom Cruise","Robert Gustavsson","Bruce Willis","Bruce Willis")
    val fraga7 = FragaBas("Vad heter bakteriologen från Skottland som upptäckte penicillinet?","James Watson","Alexander Flemming","Albert Einstein","Alexander Flemming")
    val fraga8 = FragaBas("Från vilken stad kommer ishockey-laget Brynäs?","Gällivare","Gävle","Borås","Gävle")
    val fraga9 = FragaBas("Vilka fyra simsätt ingår i tävlingsgrenen Medley?","Hundsim, ryggsim, Crawl, Simkort","Fjärilsim, Grodsim, Bröstsim, Hundsim" ,"Fjärilsim, Ryggsim, Bröstsim, Frisim","Fjärilsim, Ryggsim, Bröstsim, Frisim")
    val fraga10 =FragaBas("Vad heter författaren som skrev uppföljaren till Stig Larssons Millenium-trilogi?"
            ,"David Lagercrantz","Liza Marklund","P.O Engquist","David Lagercrantz")
    val fraga11 = FragaBas("Hur många ledamöter har Sveriges riksdag?","349","347","353","349")
    val fraga12 = FragaBas("Vilket grundämne har förkortningen Ag i periodiska systemet?","Silver","Guld","Platina","Silver")
    var frageBibliotek = mutableListOf<FragaBas>(fraga1, fraga2, fraga3, fraga4,fraga5,fraga6,fraga7,fraga8, fraga9,fraga10,fraga11,fraga12)

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
                 questionsDone.add(gammalFraga!!)
                 frageBibliotek = forkortaBibliotek(gammalFraga!!, frageBibliotek)
             }
            gammalFraga = NyFraga(frageBibliotek)
            alternativA.setVisibility(Button.VISIBLE)
            alternativB.setVisibility(Button.VISIBLE)
            alternativC.setVisibility(Button.VISIBLE)
            nyFraga.setVisibility(Button.GONE)

        }
    }
    fun NyFraga(frageBibliotek: MutableList<FragaBas>): FragaBas{
        fraga = findViewById<TextView>(R.id.fraga)
        rattEllerFel = findViewById<TextView>(R.id.rattEllerFel)
        rattEllerFel.setText("")
        var currentFraga = (frageBibliotek.random())
        var fragaText = currentFraga.FragaInfo()
        fraga.setText(fragaText)
        alternativA = findViewById<Button>(R.id.alternativA)
        alternativB = findViewById<Button>(R.id.alternativB)
        alternativC = findViewById<Button>(R.id.alternativC)
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
               startResultactivity()
            }
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
               startResultactivity()
            }
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
                startResultactivity()
            }
            else if(numberOfPlayers>1 && playerIndex<=numberOfPlayers) {

                    nyFraga.setText("Spelare $playerIndex, varsågod!")
            }
            else {
                nyFraga.setText("Spelare 1, varsågod!")
                playerIndex = 1
            }

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

    fun forkortaBibliotek(
        gammalFraga: FragaBas,
        frageBibliotek: MutableList<FragaBas>
    ): MutableList<FragaBas> {

        for (question in frageBibliotek) {
            if (gammalFraga == question) {
                frageBibliotek.remove(question)
                break
            }
        }
        return frageBibliotek
    }
}






