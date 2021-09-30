package com.example.frgesportapp

object DataManager {
    var frageBibliotek = mutableListOf<FragaBas>()

    init {
        makeQuestionsList()
    }
    fun makeQuestionsList(){
        frageBibliotek.add(FragaBas("Hur många säten har en formula 1 bil", "4", "3", "1", "1"))
        frageBibliotek.add(FragaBas("8 Juni 2014 döptes Prinsessan Leonore. Vilka förnamn döptes hon till?",
            "Leonore, Lilian, Maria", "Leonore, Josephine,Alice", "Lenore, Désireé, Mary", "Leonore, Lilian, Maria"))
        frageBibliotek.add(FragaBas("Hur många lingon finns det i världen?", "3", "1", "120000000", "3"))
        frageBibliotek.add(FragaBas("På den fiktiva planeten Stankilorius luktar det lite suspekt. Vad är det som luktar där?"
            , "En rövargubbes andedräkt", "En burk surströmming", "Tre små lingon", "Tre små lingon"))
        frageBibliotek.add(FragaBas("Nelson Mandela dömdes till livstid fängelse 1964. Vad heter ön utanför Kapstaden, Sydafrika där han satt fängslad?"
            ,"Robben Island","Bornholm","Gran Canaria","Robben Island"))
        frageBibliotek.add(FragaBas("Vilken skådespelare hade huvudrollen i filmen \"den siste scouten\" (The Last Boy Scout) från 1991?"
            ,"Tom Cruise","Robert Gustavsson","Bruce Willis","Bruce Willis"))
        frageBibliotek.add(FragaBas("Vad heter bakteriologen från Skottland som upptäckte penicillinet?","James Watson","Alexander Flemming","Albert Einstein","Alexander Flemming"))
        frageBibliotek.add(FragaBas("Från vilken stad kommer ishockey-laget Brynäs?","Gällivare","Gävle","Borås","Gävle"))
        frageBibliotek.add(FragaBas("Vilka fyra simsätt ingår i tävlingsgrenen Medley?","Hundsim, ryggsim, Crawl, Simkort","Fjärilsim, Grodsim, Bröstsim, Hundsim"
            ,"Fjärilsim, Ryggsim, Bröstsim, Frisim","Fjärilsim, Ryggsim, Bröstsim, Frisim"))
        frageBibliotek.add(FragaBas("Vad heter författaren som skrev uppföljaren till Stig Larssons Millenium-trilogi?"
            ,"David Lagercrantz","Liza Marklund","P.O Engquist","David Lagercrantz"))
        frageBibliotek.add(FragaBas("Hur många ledamöter har Sveriges riksdag?","349","347","353","349"))
        frageBibliotek.add(FragaBas("Vilket grundämne har förkortningen Ag i periodiska systemet?","Silver","Guld","Platina","Silver"))
    }
        var questionsDone = mutableListOf<FragaBas>()

    fun ForkortaBibliotek(gammalFraga: FragaBas) {
        for (question in frageBibliotek) {
            if (gammalFraga == question) {
                frageBibliotek.remove(question)
                break
            }
        }
    }
}