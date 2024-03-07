package `2021_Day_2`

import java.io.File

fun calculateX(up: Int?, down: Int?, forward: Int?): Int {
    val upValue = up ?: 0
    val downValue = down ?: 0
    val forwardValue = forward ?: 0

    return (downValue - upValue) * forwardValue
}
fun calculateTwoX(stringList: List<String>, intList: List<Int>): Int {
    var aim = 0
    var depth = 0
    var horizontalPosition = 0

    stringList.zip(intList).forEach { (action, value) ->  // zip to pair the lists!
        when (action) {                                   // switch
            "forward" -> {
                horizontalPosition += value
                depth += value * aim
            }
            "up" -> aim -= value
            "down" -> aim += value
        }
    }
    return depth * horizontalPosition
}

fun main() {
    val data: List<String> = File("src/InputDay2.txt").readLines()
    val dataMap: Map<String, Int> = data.groupBy { it.substringBefore(" ")}
        .mapValues { s -> s.value.sumOf { it.substringAfter(" ").toInt() } }

    println(calculateX(dataMap.get("up"),dataMap.get("down"),dataMap.get("forward"))) // Svar: 87380

    //////////////////////////
    /////////////////////////

    val stringList = mutableListOf<String>()
    val intList = mutableListOf<Int>()

    for (line in data) {
        val (action, value) = line.split(" ", limit = 2)
        stringList.add(action)
        intList.add(value.toIntOrNull() ?: 0)
    }

    println(calculateTwoX(stringList, intList)) // Svar: 2086357770
}