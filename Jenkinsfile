pipeline {
    agent any

    environment {
        PIPELINE_JSON = 'pipeline.json'
    }

    // stages {
    //     stage('Setup') {
    //         steps {
    //             script {
    //                 // Read JSON data from pipeline.json
    //                 def jsonText = readFile env.PIPELINE_JSON
    //                 env.pipelineData = jsonText
    //             }
    //         }
    //     }
        
        stage('Build Non-Prod') {
            
            steps {
                script {
                    // def data = readJSON text: env.pipelineData

                    // Extract the name for the target environment
                      
                    // Call the sample.groovy script passing the environment-specific data
                    def result = load 'sample.groovy'
                    result.main()
                }
            }
        }
        
    }
}
