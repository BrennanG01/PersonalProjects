/*  ~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~ *
 * 	Luhn Algorithm for: Kotlin  v 1.5.0			Brennan Goins			June 7th, 2021        *
 *  ~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~ */

fun main() {
    var cc: String;
    cc = "4847352989263094"; // Test case							T
    //cc = "4929939187355598"; // Test case							T    
    
    //~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~
    //Sourced Test Cases Below: https://www.paypalobjects.com/en_AU/vhelp/paypalmanager_help/credit_card_numbers.htm
    //~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~=-=~
    //cc = "378282246310005"; // American Express					F
    //cc = "371449635398431"; // American Express					F
    //cc = "378734493671000"; // American Express Corporate				F
    //cc = "5610591081018250"; // Australian BankCard					T
    //cc = "30569309025904"; // Diners Club						T
    //cc = "38520000023237"; // Diners Club						T
    //cc = "6011111111111117"; // Discover						T
    //cc = "6011000990139424"; // Discover						T
    //cc = "3530111333300000"; // JCB							T
    //cc = "3566002020360505"; // JCB							T
    //cc = "5555555555554444"; // MasterCard						T
    //cc = "5105105105105100"; // MasterCard						T
    //cc = "4111111111111111"; // Visa							T
    //cc = "4012888888881881"; // Visa							T
    //cc = "4222222222222"; // Visa							F
    //cc = "76009244561"; // Dankort (PBS)						F
    //cc = "5019717010103742"; // Dankort (PBS)						T
    //cc = "6331101999990016"; // Switch/Solo (Paymentech)				T
    
    print(valCheckDigit(cc));
}

fun genCheckDigit(digits: String): Int {
    var sum: Int = 0
    for (n in 0..digits.count() - 1) {
        if (n % 2 == 1) {
            var oneDigit = digits.substring(n, n + 1)
            sum += oneDigit.toInt();
        }
        else {
            var oneDigit = digits.substring(n, n + 1);
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
    val lastIndex = digits.count() - 1;
	var lastDigit = digits.substring(lastIndex, lastIndex + 1);
    var otherDigits: String = digits.substring(0, lastIndex);
    return lastDigit.toInt() == genCheckDigit(otherDigits);
}