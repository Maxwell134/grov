import groovy.json.JsonSlurperClassic



pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile 'pipeline.json'
                    def data = new JsonSlurperClassic().parseText(jsonText)

                    // Call the sample.groovy script passing the JSON data
                    def result = load 'sample.groovy'
                    result.greet(data.name)
                }
            }
        }
    }
}
