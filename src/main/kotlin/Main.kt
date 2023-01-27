package factDecomp

import kotlin.math.pow

fun Int.isPrime(): Boolean {
    val limit = this.toDouble().pow(0.5).toInt()
    for (i in 2..limit) {
        if (this % i == 0) return false
    }
    return true
}

fun decomp(m:Int):String {
    val primes = mutableListOf<Int>()
    val result = mutableListOf<String>()

    (2..5000).forEach {
        if (it.isPrime()) primes += it
    }

    primes.forEach { prime ->
        var d = prime
        var sum = 0

        while (m / d > 0) {
            sum += m / d
            d *= prime
        }

        when (sum) {
            0 -> Unit
            1 -> result += "$prime"
            else -> result += "$prime^$sum"
        }
    }

    return result.joinToString(" * ")
}