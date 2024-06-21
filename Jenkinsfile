pipeline {
    agent any

    environment {
        PIPELINE_JSON = 'pipeline.json'
    }

    stages {
        stage('Setup') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile env.PIPELINE_JSON
                    env.PIPELINE_DATA = jsonText
                }
            }
        }
        
        stage('Build Non-Prod') {
            steps {
                script {
                    // Load and execute the sample.groovy script
                    def result = load 'sample.groovy'
                    result.main()
                }
            }
        }
    }
}
