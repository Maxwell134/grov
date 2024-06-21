import groovy.json.JsonSlurper

class PipelineConfig {
    def config

    PipelineConfig(String jsonFilePath) {
        def jsonSlurper = new JsonSlurper()
        def jsonFile = new File(jsonFilePath)
        if (jsonFile.exists()) {
            config = jsonSlurper.parse(jsonFile)
        } else {
            throw new FileNotFoundException("File not found: ${jsonFilePath}")
        }
    }

    def getConfig() {
        return config
    }
}

def loadConfig() {
    def pipelineConfig = new PipelineConfig('pipeline.json')
    return pipelineConfig.getConfig()
}
