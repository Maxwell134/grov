// Jenkinsfile

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile 'pipeline.json'
                    def jsonSlurper = new groovy.json.JsonSlurper()
                    def data = jsonSlurper.parseText(jsonText)

                    // Call the sample.groovy script passing the JSON data
                    def result = load 'sample.groovy'
                    result.greet(data.name)
                }
            }
        }
    }
}
