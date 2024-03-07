package `2021_Day_1`

import java.io.File


fun problemOneX (aList : List<Int> ) : Int {
    return aList.zipWithNext().count { (current, next) -> next > current }
}
fun problemTwoX(aList : List<Int>) : Int {
    return aList.windowed(3,1){it.sum() }
        .zipWithNext().count {it.first < it.second}
}


fun main() {
    val data: List<Int> = File("src/InputDay1.txt").readLines().map { it.toIntOrNull() ?: 0 }
    var testList = listOf(199,200,208,210,200,207,240,269,260,263)

    println(problemOneX(data))
    println(problemTwoX(data))

}

/*
aList.windowed(3, 1) { it.sum() }: This creates a sequence of the sums of consecutive windows of three elements each,
 moving one element at a time. The lambda expression { it.sum() } is used to calculate the sum of each window.

.zipWithNext(): This function pairs each element with its next element in the sequence.
 So, for each sum, it forms a pair with the next sum.

.count { it.first < it.second }: This counts the number of pairs where the first element is less than the second.
 In other words, it counts the number of occurrences where the sum of the next three elements in the
  original list is greater than the sum of the current three elements.
 */