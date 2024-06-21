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

    stages {
        stage('Read JSON') {
            steps {
                script {
                    // Read the JSON file
                    
                    // Load the Groovy script
                    def sample = load 'sample.groovy'
                    
                    // Call the hello method with the greeting message
                    sample.loadConfig()
                }
            }
        }       
    }
}
