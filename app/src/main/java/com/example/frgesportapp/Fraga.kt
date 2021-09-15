package com.example.frgesportapp

open class FragaBas (var fraga:String = "", var A:String, var B: String, var C:String, var rattSvar: String) {

    fun FragaInfo(): String {
        return fraga
    }

    fun Alternativ(alt: String): String {
        if (alt == "A")
            return A
        if (alt == "B")
            return B
        if (alt == "C")
            return C
        else return ""
    }

    }
