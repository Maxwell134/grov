def loadConfig() {
    // Read the pipeline.json file
    def jsonFileContent = readFile 'pipeline.json'
    // Parse the JSON content
    def jsonContent = readJSON text: jsonFileContent
    
    // Check if the necessary fields exist
    if (jsonContent.environment && jsonContent.version && jsonContent.dockerCredentialsId) {
        def environment = jsonContent.environment
        def version = jsonContent.version
        def credentials = sonContent.dockerCredentialsId
        
        return [environment: environment, version: version, credentials: credentials]
    } else {
        throw new FileNotFoundException("Required fields not found in: pipeline.json")
    }
}

return this
