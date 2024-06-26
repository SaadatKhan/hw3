pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'saadatkhan/hw3-edited'
        DOCKER_TAG = "${BUILD_NUMBER}"
        REGISTRY_CREDENTIALS_ID = 'docker-hub-creds'  // ID for Docker Hub credentials configured in Jenkins
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig'  // ID for kubeconfig file credentials
    }

    stages {
        stage('Prepare') {
            steps {
                script {
                    // Use Maven to clean and build the project
                    sh 'mvn clean install'
                }
            }
        }

        stage('Dockerize') {
            steps {
                script {
                    // Building the Docker image
                    docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}", '.')
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Login to Docker Hub
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        sh "echo ${DOCKERHUB_PASSWORD} | docker login --username ${DOCKERHUB_USERNAME} --password-stdin"
                    }
                    // Push the Docker image
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
              
            }
        }

        stage('Update Kubernetes Deployment') {
            steps {
                script {
                    // Set up Kubeconfig
                    withCredentials([file(credentialsId: KUBECONFIG_CREDENTIALS_ID, variable: 'KUBECONFIG')]) {
                        // Update the Kubernetes deployment to use the new image
                        sh "kubectl set image deployment/hw3-app-deployment hw3-app=${DOCKER_IMAGE}:${DOCKER_TAG} --record"
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up after the pipeline runs
            cleanWs()
        }
        success {
            echo 'Process completed successfully.'
        }
        failure {
            echo 'Process failed.'
        }
    }
}
