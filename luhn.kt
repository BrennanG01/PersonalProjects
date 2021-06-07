/**
 * 	Luhn Algorithm translated for: Kotlin  v 1.5.0
 *  Algorithm Version: 0.1.0
 *  Brennan Goins - June 6th 2021
 */

fun main() {
    val cc = "12345678912345";
    print(valCheckDigit(cc));
}

fun genCheckDigit(digits: String): Int {
    var sum: Int = 0
    for (n in 1..digits.count()) {
        if (n % 2 == 1) {
            var oneDigit = digits.substring(n-1, n)
            sum += oneDigit.toInt();
        }
        else {
            var oneDigit = digits.substring(n-1, n);
            val target = oneDigit.toInt() * 2;
            if (target >= 10) sum += (1 + (target - 10));
            else sum += target;
        }
    }
    for (n in 0..9) {
        if ((sum + n) % 10 == 0) return n;
    }
    return -1;
}

fun valCheckDigit(digits: String): Boolean {
    val lastIndex = digits.count();
	var lastDigit = digits.substring(lastIndex - 1, lastIndex);
    var otherDigits: String = digits.substring(0, lastIndex - 1);
    return lastDigit.toInt() == genCheckDigit(otherDigits)
}