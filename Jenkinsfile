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

// pipeline {
//     agent any

//     stages {
//         stage('Setup') {
//             steps {
//                 script {
//                     try {
//                         // Verify if the sample.groovy file exists before loading it
//                         def groovyScriptPath = 'sample.groovy'
//                         if (!fileExists(groovyScriptPath)) {
//                             error "File not found: ${groovyScriptPath}"
//                         }
                        
//                         // Load the external Groovy script
//                         def configScript = load groovyScriptPath
                        
//                         // Verify that the script was loaded successfully
//                         if (configScript == null) {
//                             error "Failed to load ${groovyScriptPath}"
//                         }
                        
//                         // Call the function from the external script
//                         def config = configScript.loadConfig()
//                         def environment = config.environment
//                         def version = config.version
                        
//                         // Print the values
//                         echo "Environment: ${environment}"
//                         echo "Version: ${version}"
//                     } catch (FileNotFoundException e) {
//                         error "Pipeline configuration file not found: ${e.message}"
//                     } catch (Exception e) {
//                         error "An error occurred: ${e.message}"
//                     }
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
                        // Read the pipeline.json file
                        // def jsonFileContent = readFile 'pipeline.json'
                        // // Parse the JSON content
                        // def jsonContent = readJSON text: jsonFileContent
                        
                        // Check if the necessary fields exist
                        // if (jsonContent.environment && jsonContent.version && jsonContent.dockerCredentialsId) {
                        //     def environment = jsonContent.environment
                        //     def version = jsonContent.version
                        //     def dockerCredentialsId = jsonContent.dockerCredentialsId
                            
                        //     // Print the values
                        //     echo "Environment: ${environment}"
                        //     echo "Version: ${version}"
                        //     echo "Docker Credentials ID: ${dockerCredentialsId}"
                            
                        //     // Store the credential ID in the environment
                        //     env.DOCKER_CREDENTIALS_ID = dockerCredentialsId

                                def groovyScriptPath = 'sample.groovy'
                                def configScript = load groovyScriptPath
                                def config = configScript.loadConfig()
                                def environment = config.environment
                                def version = config.version
                                def dockerCredentialsId = config.dockerCredentialsId
                                echo "Environment: ${environment}"
                                echo "Version: ${version}"
                                echo "Docker Credentials ID: ${dockerCredentialsId}"
                                env.DOCKER_CREDENTIALS_ID = dockerCredentialsId
                                                                      
                        } else {
                            error "Required fields not found in: pipeline.json"
                        }
                    } catch (FileNotFoundException e) {
                        error "Pipeline configuration file not found: ${e.message}"
                    } catch (Exception e) {
                        error "An error occurred: ${e.message}"
                    }
                }
            }
        }
        stage('Docker Login') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                    }
                }
            }
        }
    }
}















