import groovy.json.JsonSlurper

def loadConfig() {
    def jsonSlurper = new JsonSlurper()
    def jsonFile = new File('pipeline.json')
    if (jsonFile.exists()) {
        def config = jsonSlurper.parse(jsonFile)
        def environment = config.environment
        def version = config.version
                    
        echo "Environment: ${environment}"
        echo "Version: ${version}"
        
    } else {
        throw new FileNotFoundException("File not found: pipeline.json")
    }
}

return this 
