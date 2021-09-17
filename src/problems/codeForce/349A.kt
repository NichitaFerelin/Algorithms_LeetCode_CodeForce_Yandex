package problems.codeForce

import readFromConsole

class `349A` {
    fun alg() {
        val moneyStream = readFromConsole()[1].split(" ").map { it.toInt() }

        val bill25 = 25
        val bill50 = 50
        val bill100 = 100
        val oneTicketCost = bill25

        val billsContainer = hashMapOf(
            bill25 to 0,
            bill50 to 0,
            bill100 to 0
        )

        moneyStream.forEach { currentBill ->
            val change = currentBill - oneTicketCost
            val billsForChange = billsContainer[change]

            when {
                change == 0 -> billsContainer[bill25] = billsContainer[bill25]!! + 1
                change == bill25 -> {
                    if (billsForChange != 0) {
                        billsContainer[change] = billsForChange!! - 1
                        billsContainer[bill50] = billsContainer[bill50]!! + 1
                    } else {
                        println("NO")
                        return
                    }
                }
                change == bill100 - oneTicketCost -> {
                    if (billsContainer[bill25]!! >= 1 && billsContainer[bill50]!! >= 1) {
                        billsContainer[bill25] = billsContainer[bill25]!! - 1
                        billsContainer[bill50] = billsContainer[bill50]!! - 1
                    } else if (billsContainer[bill25]!! >= 3) {
                        billsContainer[bill25] = billsContainer[bill25]!! - 3
                    } else {
                        println("NO")
                        return
                    }
                }

                else -> {
                    println("NO")
                    return
                }
            }
        }
        println("YES")
    }
}