// import groovy.json.JsonSlurper

def loadConfig() {
    // def jsonSlurper = new JsonSlurper()
    // def jsonFile = new File('pipeline.json')
    def jsonFile = readFile 'pipeline.json'
    def jsonContent = readJSON text: jsonFile
    
    if (jsonContent.exists()) {
        def config = jsonSlurper.parse(jsonFile)
        def environment = config.environment
        def version = config.version
        
        return [environment,
                environment          
            ]
    } else {
        throw new FileNotFoundException("File not found: pipeline.json")
    }
}

return this
