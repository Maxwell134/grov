def message(data) {
    def name = data.name ?: "World" // Default to "World" if name is not in the JSON
    def greetMessage = greet(name)
    println(greetMessage)
}

def greet(name) {
    return "Hello, $name!"
}

return this
