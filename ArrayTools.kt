/*
ArrayTools.kt Write a small Kotlin command line application (ArrayTools.kt) that provides useful tools to developers:
1. encrypt Create a Caesar cipher function that accepts a String (the String to encrypt), a shift value, and returns the new String.
2. arrayAvg Write a function that accepts an array and produces the average of all values (array should be numeric type)
3. arrayContains Write a function that accepts an array and a search value, and determines if the array contains the value (true/false) (the array can use any data type you want)
4. reverse Write a function that reverses an array (gives a new array) (the array can use any data type you want)
*/


fun main() {
    println("----------------> Lab 2 - Functions and Arrays <----------------\n\n")
    println("1. Encrypt a string using Caesar cipher")
    println("2. Find the average of an integer array")
    println("3. Check if an array contains a value")
    println("4. Reverse an array")
    print("\n\nPlease choose one option from above: ")
    val enteredValue = readLine()?.toIntOrNull()

    if (enteredValue in 1..4) {
        when (enteredValue) {
            1 -> {
                println("Please enter a string to be encrypted: ")
                val inputString = readLine()
                println("Please enter the number of shifts: ")
                val shifts = readLine()?.toIntOrNull()
                if (inputString != null && shifts != null) {
                    val encryptedString = caesarCipher(inputString, shifts)
                    println("Encrypted string: $encryptedString")
                } else {
                    println("Invalid input. Please enter valid values.")
                }
            }
            2 -> {
                println("Enter elements of the array separated by spaces:")
                val input = readLine()
                val array = input?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                if (array != null && array.isNotEmpty()) {
                    val average = calculateAverage(array)
                    println("The average is: $average")
                } else {
                    println("Invalid input. Please enter valid values.")
                }
            }
            3 -> {
                println("Enter elements of the array separated by spaces:")
                val input = readLine()
                val array = input?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                if (array != null && array.isNotEmpty()) {
                    println("Enter the value to check:")
                    val value = readLine()?.toIntOrNull()
                    if (value != null) {
                        val contains = containsValue(array, value)
                        if (contains) {
                            println("The array contains the value $value")
                        } else {
                            println("The array does not contain the value $value")
                        }
                    } else {
                        println("Invalid input. Please enter a valid value.")
                    }
                } else {
                    println("Invalid input. Please enter valid values.")
                }
            }
            4 -> {
                println("Enter elements of the array separated by spaces:")
                val input = readLine()
                val array = input?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
                if (array != null && array.isNotEmpty()) {
                    val reversedArray = reverseArray(array)
                    println("Reversed array: ${reversedArray.joinToString(", ")}")
                } else {
                    println("Invalid input. Please enter valid values.")
                }
            }
        }
    } else {
        println("Invalid input")
    }
}

fun caesarCipher(input: String, shift: Int): String {
    var result = ""

    for (char in input) {
        if (char.isLetter()) {
            val base = if (char.isLowerCase()) 'a' else 'A'
            val offset = (char - base + shift) % 26
            val shiftedChar = (base + offset).toChar()
            result += shiftedChar
        } else {
            result += char
        }
    }

    return result
}

fun calculateAverage(array: IntArray): Double {
    if (array.isEmpty()) {
        return 0.0
    }

    val sum = array.sum()
    return sum.toDouble() / array.size
}

fun containsValue(array: IntArray, value: Int): Boolean {
    return value in array
}

fun reverseArray(array: IntArray): IntArray {
    val reversedArray = IntArray(array.size)
    var lastIndex = array.size - 1

    for (element in array) {
        reversedArray[lastIndex] = element
        lastIndex--
    }

    return reversedArray
}
