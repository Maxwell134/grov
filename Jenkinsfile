pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile 'pipeline.json'
                    def data = readJSON text: jsonText

                    // Call the sample.groovy script passing the JSON data
                    def result = load 'sample.groovy'
                    result.message(data)
                }
            }
        }
    }
}
