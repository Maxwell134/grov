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
                    env.pipelineData = jsonText
                }
            }
        }
        
        stage('Build Non-Prod') {
            environment {
                TARGET_ENV = 'non-prod'
            }
            steps {
                script {
                    def data = readJSON text: env.pipelineData

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

        stage('Build Prod') {
            environment {
                TARGET_ENV = 'prod'
            }
            steps {
                script {
                    def data = readJSON text: env.pipelineData

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
