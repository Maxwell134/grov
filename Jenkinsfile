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
                    try {
                        // Verify if the sample.groovy file exists before loading it
                        def filePath = 'sample.groovy'
                        if (!fileExists(filePath)) {
                            error "File not found: ${filePath}"
                        }
                        
                        // Load the external Groovy script
                        def configScript = load filePath
                        
                        // Verify that the script was loaded successfully
                        if (configScript == null) {
                            error "Failed to load ${filePath}"
                        }
                        
                        // Call the function from the external script
                        def config = configScript.loadConfig()
                        def environment = config.environment
                        def version = config.version
                        
                        echo "Environment: ${environment}"
                        echo "Version: ${version}"
                    } catch (FileNotFoundException e) {
                        error "Pipeline configuration file not found: ${e.message}"
                    } catch (Exception e) {
                        error "An error occurred: ${e.message}"
                    }
                }
            }
        }
    }
}
