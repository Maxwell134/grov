def loadConfig() {
    // Read the pipeline.json file
    def jsonFileContent = readFile 'pipeline.json'
    // Parse the JSON content
    def jsonContent = readJSON text: jsonFileContent
    
    // Check if the necessary fields exist
    if (jsonContent.environment && jsonContent.version) {
        def environment = jsonContent.environment
        def version = jsonContent.version
        
        return [environment: environment, version: version]
    } else {
        throw new FileNotFoundException("Required fields not found in: pipeline.json")
    }
}

return this
