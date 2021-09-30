package com.example.frgesportapp

object DataManager {
    var frageBibliotek = mutableListOf<FragaBas>()
    var questionsDone = mutableListOf<FragaBas>()

    init {
        addQuestionsList()
    }
    fun addQuestionsList(){
        frageBibliotek.add(FragaBas("Hur många säten har en formula 1 bil", "4", "3", "1", "1"))
        frageBibliotek.add(FragaBas("8 Juni 2014 döptes Prinsessan Leonore. Vilka förnamn döptes hon till?",
            "Leonore, Lilian, Maria", "Leonore, Josephine,Alice", "Lenore, Désireé, Mary", "Leonore, Lilian, Maria"))
        frageBibliotek.add(FragaBas("Hur många lingon finns det i världen?", "3", "1", "120000000", "3"))
        frageBibliotek.add(FragaBas("På den fiktiva planeten Stankilorius luktar\n det lite suspekt. Vad är det som luktar där?"
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
        frageBibliotek.add(FragaBas("1976 kom Stephen King ut med sin debutroman som handlar om en mobbad tonårsflicka med övernaturliga förmågor. 1980 kom romanen ut med svensk översättning. Vad heter boken?",
        "Varsel","Knackarna","Carrie","Carrie"))
        frageBibliotek.add(FragaBas("Tv-serien Dallas fångar tv-tittare runt om i världen. En maktkamp mellan familjerna Ewing och Barnes med ärkeskurken JR Ewing i spetsen. I serien gifter sig Bobby Ewing med Pamela Barnes, vad heter dessa 2 skådespelare?",
        "Bruce Willis och Tuva Novotny","Patrick Duffy och Victoria Principal","Humphfrey Bogart och Meryl Streep","Patrick Duffy och Victoria Principal"))
        frageBibliotek.add(
            FragaBas("Låten \"Eye of tiger\" skrivs till filmen Rocky III. Vad heter gruppen som gjort låten?",

            "Toto","Survivor","Audioslave","Survivor"))
        frageBibliotek.add(FragaBas("Detta år börjar SVT visa en australiensk serie med\n Richard Chamberlain i en av huvudrollerna. Serien bygger på en roman med samma namn och är skriven av Colleen McCullough. Vad heter tv-serien?",
        "Törnfåglarna","Doktorn kan komma","Kvinnofängelset","Törnfåglarna"))
    }

    fun forkortaBibliotek(gammalFraga: FragaBas) {
        for (question in frageBibliotek) {
            if (gammalFraga == question) {
                frageBibliotek.remove(question)
                questionsDone.add(gammalFraga)
                break
            }
        }
    }
    fun newGameAddLists(){
        frageBibliotek.clear()
        addQuestionsList()
        questionsDone.clear()
    }
}