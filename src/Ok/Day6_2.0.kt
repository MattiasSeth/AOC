package `2020Day6`

import java.io.File


fun main() {
    val data: List<String> = File("src/InputDay6.txt").readLines()
        .joinToString("\n")
        .split("\n\n")

    val groups: List<String> = data.map {
        it.split("\n").joinToString("")
    }
    val result = groups.map { it.chars().distinct().count() }
        .reduce { a, b -> a + b }

    println(result)
}