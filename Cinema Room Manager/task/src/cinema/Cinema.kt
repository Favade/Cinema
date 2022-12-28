package cinema

import java.lang.IndexOutOfBoundsException

var rows = 0
var seats = 0
var current = 0
var tix = 0
var percentage = 0

fun main() {
    theatre()
}

fun theatre() {
    println("Enter the number of rows:")
    val numRows = readln().toInt()

    println("Enter the number of seats in each row:")
    val numSeats = readln().toInt()

    rows += numRows
    seats += numSeats

    var exited = false
    val dashboard = menu()

    val seating = MutableList(numRows){MutableList(numSeats) {'S'} }

    while (!exited) {
        println(dashboard)
        when (readln()) {
            "1" -> showSeats(seating, numSeats)
            "2"-> buyTicket(seating, numRows, numSeats)
            "3"-> println(statistics())
            "0" -> exited = true
        }
    }


}


fun totalIncome(): String {

    val totalSeats = rows * seats

    return if (rows * seats <= 60)  {
        "$" + (totalSeats) * 10
    }
    else if (rows % 2 == 0 && totalSeats > 60) {
        val firstHalf = rows / 2
        "$" + (firstHalf * 10 + firstHalf * 8) * seats
    }
    else {
        val oddOn = rows / 2
        val oddTwo = oddOn + 1

        "$" + (oddOn * 10 + oddTwo * 8) * seats
    }
}



fun showSeats(seating: MutableList<MutableList<Char>>, seats: Int) {
    var count = 0
    println("Cinema:")
    print("  ")
    for (z in 1.. seats) {
        print("$z ")
    }
    println()
    for (i in seating.indices) {
        print("${++count} ")
        for (j in seating[i].indices) {
            print(seating[i][j] + " ")
        }
        println()
    }
}

fun buyTicket(seating: MutableList<MutableList<Char>>, rows: Int, seats: Int) {
    var purchasedTickets = 0
    var currentIncome = 0
    var promptUser = true
    var purchased = 0
    val totalSeats = rows * seats
    while (promptUser) {
        try {
            println("Enter a row number:")
            val row = readln().toInt() - 1
            println("Enter a seat number in that row:")
            val seat = readln().toInt() - 1

            if (seating[row][seat] == 'S') {
                seating[row][seat] = 'B'
                purchasedTickets++
                purchased++
            }
            if (purchased % 2 == 0) {
                println("That ticket has already been purchased!")
            } else {
               when {
                   totalSeats <= 60 -> {
                       currentIncome+= 10
                       println("Ticket price: $10")
                   }
                   row % 2 == 0 -> {
                       val half = rows /  2
                       if (row > half / 2 )  {
                           currentIncome += 8
                           println("Ticket price: $8")
                       } else {
                           println("Ticket price: $10")
                           currentIncome += 10
                       }

                   }
                   else -> {
                       val oddHalf = rows / 2
                       if (row > oddHalf) {
                           currentIncome += 8
                           println("Ticket price: $8")

                           } else {
                               currentIncome += 10
                               println("Ticket price: $10")
                           }
                   }

               }
                promptUser = false

            }
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong input!")
        }

        tix += purchasedTickets
        current += currentIncome

    }
}

fun statistics(): String {
    return """
        Number of purchased tickets: $tix
        Percentage: ${"%.2f".format(tix.toDouble() / (rows * seats) * 100)}%
        Current income: $$current
        Total income: ${totalIncome()}
    """.trimIndent()
}

fun menu(): String {
    return """
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit"""
}

