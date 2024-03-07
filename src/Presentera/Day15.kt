package `2020_Day_15`


//11,0,1,10,5,19
fun calculate (rounds : Int) : Int {
    var gameList = mutableListOf(-1, 11, 0, 1,10,5,19)
    var round = 0
    var gameRounds = rounds - (gameList.size-1)

    while (round < gameRounds){

        for (i in gameList.indices){
            var lastNumber = gameList.last()
                if (lastNumber !in gameList.dropLast(1)){
                    gameList.add(0)
                    round++
                    break
                }else {
                    var lastIndex = gameList.size-1
                    for (i in gameList.indices.reversed()){
                        var secondLastNumber = i-1

                        if (gameList[secondLastNumber] == lastNumber){
                            gameList.add(lastIndex-secondLastNumber)
                            round++
                            break
                        }
                    }
                }
            break
        }
    }
    return gameList.last()
}


fun main() {
    //11,0,1,10,5,19
    var x = calculate(2020)
    println(x)

    //println(testList.last())

    //println(testList[3])
    //val myList = listOf(1, 2, 3, 4, 5)

    //for (i in myList.indices.reversed()) {
    //    println(i-1)
    //}

}