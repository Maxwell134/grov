// pipeline {
//     agent any

//     environment {
//         PIPELINE_JSON = 'pipeline.json'
//     }

//     stages {
//         stage('Setup') {
//             steps {
//                 script {
//                     // Read JSON data from pipeline.json
//                     def jsonText = readFile env.PIPELINE_JSON
//                     env.PIPELINE_DATA = jsonText
//                 }
//             }
//         }
        
//         stage('Build Non-Prod') {
//             steps {
//                 script {
//                     // Load and execute the sample.groovy script
//                     def result = load 'sample.groovy'
//                     result.main()
//                 }
//             }
//         }
//     }
// }


pipeline {
    agent any
    
    environment {
        PIPELINE_JSON = 'pipeline.json'
    }
    
    stages {
        stage('Setup') {
            steps {
                script {
                    // Read JSON data from pipeline.json using JsonSlurper
                    def jsonText = readFile(env.PIPELINE_JSON)
                    def slurper = new JsonSlurper()
                    def pipelineData = slurper.parseText(jsonText)
                    
                    // Call the sample.groovy script passing the environment-specific data
                    def result = load 'sample.groovy'
                    result.main(pipelineData)
                }
            }
        }
    }
}

