package `2020_Day_9`

import java.io.File
fun findSumOfTwo(intList: List<Int>, pre: Int): Int? {
    var counter = 0
    val maxCounter = (pre - 1) * (pre - 1)
    var lastLoop = 0

    for (i in pre until intList.size) {
        val tempInt = intList[i]

        for (j in i - pre until i) {
            val firstInt = intList[j]

            for (k in j + 1 until i) {
                val intToCheck = firstInt + intList[k]
                if (intToCheck == tempInt) {
                    counter = 0
                    break
                } else {
                    counter++
                    //println("inttocheck: $intToCheck counter: $counter  tempInt: $tempInt")
                }
            }
        }
        lastLoop++
        if (counter == maxCounter) {
            return tempInt
        }
    }
    return null
}
fun main() {

    val intList = listOf(
        35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
    val data: List<Int> = File("src/InputDay9.txt").readLines().map { it.toIntOrNull() ?: 0 }

    println(findSumOfTwo(data,25))


}


