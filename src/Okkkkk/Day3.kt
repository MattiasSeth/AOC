package `2021_Day_3`

import java.io.File


fun findMostCommonChar(input: String): Char? {
    return input.groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key
}
fun findLeastCommonChar(input: String): Char? {
    val result = input.groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key
    return if (result == '1') {
        '0'
    } else {
        '1'
    }
}

fun calculateOne (aList : List<String>) : List<String> {
    val resultList = mutableListOf<String>()

    for (i in aList[0].indices) {
        val tempString = aList.mapNotNull { if (i < it.length) it[i] else null }
        resultList.add(tempString.joinToString(""))
    }

    return resultList
}
fun stringsToIntegerList(stringList: List<String>): List<Int> {
    return stringList.map { it.toIntOrNull() ?: 0 }
}
fun binaryToDecimal(bits: List<Int>): Int {
    return bits.fold(0) { acc, bit -> acc * 2 + bit }
}
fun main() {

    var testList = listOf("00100","11110","10110","10111","10101","01111","00111","11100","10000",
        "11001","00010","01010")
    val data: List<String> = File("src/InputDay3.txt").readLines()

    var x = calculateOne(data)

    var gamma = stringsToIntegerList(x.map { findMostCommonChar(it).toString() })
    var epsilon = stringsToIntegerList(x.map { findLeastCommonChar(it).toString() })

    var result = binaryToDecimal(gamma) * binaryToDecimal(epsilon)

    println(result)

}

//[011110011100, 010001010101, 111111110000, 011101100011, 000111100100]
