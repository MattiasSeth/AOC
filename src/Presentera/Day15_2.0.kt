package `2020_Day_15`
/*
In your code, the sequence is used to generate a sequence of numbers based on a given
 set of rules until a specified number of rounds (rounds). Let's break down the code:
 */
fun calculate2(rounds: Int): Int {
    val gameList = mutableListOf(-1, 11, 0, 1, 10, 5, 19)

    return sequence {
        yieldAll(gameList)                      // add all to seq

        for (round in (gameList.size - 1) until rounds) {
            val lastIndex = round + 1
            val lastNumber = gameList.last()
            var previousIndex = -1

            for (i in round - 1 downTo 0) {
                if (gameList[i] == lastNumber) {
                    previousIndex = i
                    break
                }
            } //    -1 = firstTime //// else last - previous
            val spokenNumber = if (previousIndex == -1) 0 else lastIndex - previousIndex - 1

            yield(spokenNumber)
            gameList.add(spokenNumber)  // add to seq
        }
    }.toList().last()  // convert to list, get last

}

fun main() {
    val result = calculate2(2020)
    println(result)
}