import groovy.json.JsonSlurper

def message(data) {
    def name = data.name ?: "World" // Default to "World" if name is not in the JSON
    def greetMessage = greet(name)
    println(greetMessage)
}

def greet(name) {
    return "Hello, $name!"
}

// Function to read JSON content
def readJsonContent(jsonContent) {
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(jsonContent)
}

// Function to get Jenkins credentials (username and password)
def getJenkinsCredentials(id) {
    def username = ''
    def password = ''
    
    withCredentials([usernamePassword(credentialsId: id, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        username = env.USERNAME
        password = env.PASSWORD
    }
    
    return [username: username, password: password]
}

// Main execution
def main(jsonContent) {
    // Parse JSON content
    def data = readJsonContent(jsonContent)
    
    // Extract credential ID from JSON
    def credentialId = data.jenkinsCredentials.id
    
    // Get credentials from Jenkins
    def credentials = getJenkinsCredentials(credentialId)
    def username = credentials.username
    def password = credentials.password
    
    // Call the message function
    message(data.environments['non-prod'])
    
    // Docker login
    def dockerLoginCommand = "docker login -u ${username} -p ${password}"
    println "Executing: ${dockerLoginCommand}"
    def process = dockerLoginCommand.execute()
    process.waitFor()
    if (process.exitValue() != 0) {
        println "Docker login failed: ${process.err.text}"
    } else {
        println "Docker login successful"
    }
}

return this
