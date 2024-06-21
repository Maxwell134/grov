def main() {
    // Read JSON file
    def data = readJsonFile('pipeline.json')
    
    // Get credentials
    def username = 'jenkins-username-id'
    def password = 'jenkins-password-id'
    
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

main()
