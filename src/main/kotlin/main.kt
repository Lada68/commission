var amountOfTransferAll = 0
var typeCard = "VK Pay"
var amount: Int = 0

fun main() {
    commission(42000, "Мир", 700)
}

fun commission(amountOfTransferAll: Int, typeCard: String, amount: Int) {
    var commission = 0
    if (typeCard != "VK Pay") {
        if (amountOfTransferAll >= 600_000 || amount > 150_000) {
            println("Превышен лимит")
            return
        }
    } else {
        if (amountOfTransferAll >= 40_000 || amount > 15_000) {
            println("Превышен лимит")
            return
        }
    }

    when (typeCard) {
        "MasterCard", "Maestro" -> commission = if (amount < 7500) 0 else (((amount / 100 * 0.6) * 100 + 2000).toInt())
        "VK Pay" -> commission = 0
        "Visa", "Мир" -> commission = if (amount / 100 * 0.75 < 35) 3500 else (((amount / 100 * 0.75)) * 100).toInt()
    }
    val amountResult: Int = amount + commission / 100
    println(amountResult)
}
