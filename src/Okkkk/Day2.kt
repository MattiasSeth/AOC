package `2021_Day_2`

import java.io.File

fun calculate(up: Int?, down: Int?, forward: Int?): Int {
    val upValue = up ?: 0
    val downValue = down ?: 0
    val forwardValue = forward ?: 0

    return (downValue - upValue) * forwardValue
}

fun calculateTwo(stringList: List<String>, intList: List<Int>): Int {
    var aim = 0
    var depth = 0
    var horizontalPosition = 0

    for (i in intList.indices){
        if (stringList[i].equals("forward")){
            horizontalPosition = horizontalPosition + intList[i]
            var tempDepth = intList[i]*aim
            depth = depth + tempDepth
        } else if (stringList[i].equals("up")){
            aim = aim - intList[i]
        } else { // Down
            aim = aim + intList[i]
        }
    }
    return depth*horizontalPosition
}

fun main() {
    val data: List<String> = File("src/InputDay2.txt").readLines()

    //println(data)

    val dataMap: Map<String, Int> = data.groupBy { it.substringBefore(" ")}
                .mapValues { s -> s.value.sumOf { it.substringAfter(" ").toInt() } }

    println(dataMap.map { "${it.key}: ${it.value }"})

    val up = dataMap.get("up")
    val down = dataMap.get("down")
    val forward = dataMap.get("forward")

    println(calculate(up,down,forward)) // Svar: 87380

    //////////////////////////
    /////////////////////////

    val stringList = mutableListOf<String>()
    val intList = mutableListOf<Int>()

    for (line in data) {
        val (action, value) = line.split(" ", limit = 2)
        stringList.add(action)
        intList.add(value.toIntOrNull() ?: 0)
    }

    var l = listOf("forward","down","forward","up","down","forward")
    var i = listOf(5,5,8,3,8,2)

    println(calculateTwo(stringList, intList)) // Svar: 2086357770
}