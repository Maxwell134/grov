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
        stage('Setup') {
            steps {
                script {
                    // Load the external Groovy script
                    def configScript = load 'sample.groovy'
                        result = configScript.loadConfig()
                        println(result)
                    
                    // Call the function from the external script
                    
                }
            }
        }
    }
}
