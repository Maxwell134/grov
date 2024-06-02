pipeline {
    agent any

    environment {
        // Define the environment you want to use here
        TARGET_ENV = 'non-prod' // Change this to 'prod' for production
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Read JSON data from pipeline.json
                    def jsonText = readFile 'pipeline.json'
                    def data = readJSON text: jsonText

                    // Extract the name for the target environment
                    def envData = data.environments[env.TARGET_ENV]
                    if (!envData) {
                        error "Environment '${env.TARGET_ENV}' not found in pipeline.json"
                    }

                    // Call the sample.groovy script passing the environment-specific data
                    def result = load 'sample.groovy'
                    result.message(envData)
                }
            }
        }
    }
}
