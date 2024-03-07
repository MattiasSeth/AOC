package `2021_Day_1`

import java.io.File

fun problemOne (aList : List<Int> ) : Int {
    return aList.zipWithNext().count { (current, next) -> next > current }
}
fun problemTwo (aList : List<Int>) : Int {
    var result = 0
    try {
        for (i in aList.indices){
            var tempA = aList[i]+aList[i+1]+aList[i+2]
            var tempB = aList[i+1]+aList[i+2]+aList[i+3]
            if (tempB>tempA)
                result++
        }
    }catch (e: IndexOutOfBoundsException){

    }
    return result
}

fun main() {
    val data: List<Int> = File("src/InputDay1.txt").readLines().map { it.toIntOrNull() ?: 0 }

    //println(data)

    var testList = listOf(199,200,208,210,200,207,240,269,260,263)

    println(problemOne(data))
    println(problemTwo(data))

}