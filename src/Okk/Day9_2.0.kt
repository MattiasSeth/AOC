package `2020_Day_9`

import java.io.File


fun calculate(intList: List<Int>, pre: Int): Int? {

    return (pre until intList.size).asSequence()
        .map { i ->
            val tempInt = intList[i]
            val pairs = (i - pre until i).asSequence()
                .flatMap { j ->
                    (j + 1 until i).asSequence()
                        .map { k -> intList[j] + intList[k] }
                }
            Pair(tempInt, pairs)
        }
        .firstOrNull { (tempInt, pairs) -> !pairs.contains(tempInt) }
        ?.first
}


fun main() {

    val data: List<Int> = File("src/InputDay9.txt").readLines().map { it.toIntOrNull() ?: 0 }
    println(calculate(data,25))
}