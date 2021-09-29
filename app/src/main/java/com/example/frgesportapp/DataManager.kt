package com.example.frgesportapp

object DataManager {
    val fraga1: FragaBas = FragaBas("Hur många säten har en formula 1 bil", "4", "3", "1", "1")
    val fraga2: FragaBas = FragaBas("8 Juni 2014 döptes Prinsessan Leonore. Vilka förnamn döptes hon till?",
        "Leonore, Lilian, Maria", "Leonore, Josephine,Alice", "Lenore, Désireé, Mary", "Leonore, Lilian, Maria")
    val fraga3: FragaBas = FragaBas("Hur många lingon finns det i världen?", "3", "1", "120000000", "3")
    val fraga4: FragaBas = FragaBas("På den fiktiva planeten Stankilorius luktar det lite suspekt. Vad är det som luktar där?"
        , "En rövargubbes andedräkt", "En burk surströmming", "Tre små lingon", "Tre små lingon")
    val fraga5: FragaBas = FragaBas("Nelson Mandela dömdes till livstid fängelse 1964. Vad heter ön utanför Kapstaden, Sydafrika där han satt fängslad?"
        ,"Robben Island","Bornholm","Gran Canaria","Robben Island")
    val fraga6 = FragaBas("Vilken skådespelare hade huvudrollen i filmen \"den siste scouten\" (The Last Boy Scout) från 1991?"
        ,"Tom Cruise","Robert Gustavsson","Bruce Willis","Bruce Willis")
    val fraga7 = FragaBas("Vad heter bakteriologen från Skottland som upptäckte penicillinet?","James Watson","Alexander Flemming","Albert Einstein","Alexander Flemming")
    val fraga8 = FragaBas("Från vilken stad kommer ishockey-laget Brynäs?","Gällivare","Gävle","Borås","Gävle")
    val fraga9 = FragaBas("Vilka fyra simsätt ingår i tävlingsgrenen Medley?","Hundsim, ryggsim, Crawl, Simkort","Fjärilsim, Grodsim, Bröstsim, Hundsim"
        ,"Fjärilsim, Ryggsim, Bröstsim, Frisim","Fjärilsim, Ryggsim, Bröstsim, Frisim")
    val fraga10 =FragaBas("Vad heter författaren som skrev uppföljaren till Stig Larssons Millenium-trilogi?"
        ,"David Lagercrantz","Liza Marklund","P.O Engquist","David Lagercrantz")
    val fraga11 = FragaBas("Hur många ledamöter har Sveriges riksdag?","349","347","353","349")
    val fraga12 = FragaBas("Vilket grundämne har förkortningen Ag i periodiska systemet?","Silver","Guld","Platina","Silver")
    var frageBibliotek = mutableListOf<FragaBas>(fraga1, fraga2, fraga3, fraga4,fraga5,fraga6,fraga7,fraga8, fraga9,fraga10,fraga11,fraga12)
    var questionsDone = mutableListOf<FragaBas>()

    fun ForkortaBibliotek(gammalFraga: FragaBas, frageBibliotek: MutableList<FragaBas>)
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