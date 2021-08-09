
func genCheckDigit(digits: String) -> Int
{
    var sum = 0
    for i in 0...digits.count-1
    {
        if i % 2 == 1
        {
            sum += digits[digits.index(digits.startIndex, offsetBy: i)].wholeNumberValue! //Would make a try catch here in case they enter an invalid string...
        }
        else
        {
            let target = (digits[digits.index(digits.startIndex, offsetBy: i)].wholeNumberValue!) * 2
            if target >= 10
            {
                sum += (1 + (target - 10))
            }
            else
            {
                sum += target
            }
        }
    }
    for i in 0...9
    {
        if (sum + i) % 10 == 0
        {
            return i
        }
    }
    return -1
}

func valCheckDigit(digits: String) -> Bool
{
    return digits.last!.wholeNumberValue! == genCheckDigit(digits: String(digits.dropLast()))
}



var cc = "4929939187355598"
valCheckDigit(digits: cc)


