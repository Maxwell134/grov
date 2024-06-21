def main() {
    // Read JSON file
    
    def jsonFile = readFile ('pipeline.json')
    def jsonContent = readJSON text: jsonFile

    // Extract the variable from JSON
    def login_credentials = jenkinsCredentials.id

    def getJenkinsCredentials(id) {
    withCredentials([usernamePassword(dockerhub-credentials: id, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        return [username: env.USERNAME, password: env.PASSWORD]
    }
}
    
    // Get credentials
    def credentials = getJenkinsCredential(login_credentials)
    def username = credentials.username
    def password = credentials.password
    
    // Call the message function
    
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

main()
