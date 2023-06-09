fun main() {
    val array = mutableListOf<Int>()
    
    println("Enter the elements of the array (enter 'done' to finish):")
    
    var input = readLine()
    while (input != "done") {
        val element = input?.toIntOrNull()
        if (element != null) {
            array.add(element)
        } else {
            println("Invalid input. Please enter a valid integer or 'done' to finish.")
        }
        
        input = readLine()
    }
    
    println("Array: $array")
}
