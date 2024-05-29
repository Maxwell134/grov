import groovy.json.JsonSlurper

@NonCPS
def parseJson(jsonText) {
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(jsonText)
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile 'pipeline.json'
                    def data = parseJson(jsonText)

                    // Call the sample.groovy script passing the JSON data
                    def result = load 'sample.groovy'
                    result.greet(data.name)
                }
            }
        }
    }
}
