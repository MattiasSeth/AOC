package `2020Day6`

import java.io.File

class Day6{
    fun calculate (stringList : List<String>): Int {
        var counter = 0
        var firstIndex = 0

        for (i in stringList.indices){
            var tempString = stringList[i]
            if (tempString.isBlank()){
                counter = counter + stringList.subList(firstIndex, i).joinToString(separator = "").toSet().size
                firstIndex = i+1
            }

        }
        if (firstIndex < stringList.size) {
            counter += stringList.subList(firstIndex, stringList.size).joinToString(separator = "").toSet().size
        }
        return counter
    }
}

fun main() {

    val d6 = Day6()
    val data: List<String> = File("src/InputDay6.txt").readLines()

    val data2 = listOf("abc"," ","a","b","c"," ","ab","ac"," ", "a","a","a","a"," ","b")
    println(d6.calculate(data))

    //7println(data2.size)
    //println(data2[14])


}

