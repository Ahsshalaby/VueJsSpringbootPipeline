pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ahsshalaby/hw2app"
        DOCKER_IMAGE_BACKEND = "ulisesalmonte/survey-page"
        K8S_NAMESPACE = "default"
        KUBECONFIG_CRED_ID = 'homework3'
        DOCKER_CREDENTIALS_ID = 'dockerhub'
        DOCKER_CREDENTIALS_BACKEND = 'docker_backend'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/Ahsshalaby/VueJsSpringbootPipeline.git', branch: 'main'
            }
        }

        /*
        stage('Build Application') {
            steps {
                script {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }
        */

        stage('Build Backend') {
    steps {
        dir('ualmonte-survey-page') {
            sh 'chmod +x mvnw'
            sh './mvnw clean package -DskipTests'
        }
    }
}
        stage('Build Docker image') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE, './FrontEnd')
                    docker.build(DOCKER_IMAGE_BACKEND, './ualmonte-survey-page')
                }
            }
        }

        stage('Push Docker image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        docker.image("${DOCKER_IMAGE}").push('latest')
                    }

                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_BACKEND) {
                        docker.image("${DOCKER_IMAGE_BACKEND}").push('latest')
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                withKubeConfig([credentialsId: KUBECONFIG_CRED_ID]) {
                    sh '''
                    kubectl set image deployment/hw2acs-deployment container-0=${DOCKER_IMAGE}:latest -n ${K8S_NAMESPACE}
                    kubectl rollout restart deployment hw2acs-deployment -n ${K8S_NAMESPACE}
                    kubectl rollout status deployment/hw2acs-deployment -n ${K8S_NAMESPACE}

                    kubectl set image deployment/backendhw3 backendhw3=${DOCKER_IMAGE_BACKEND}:latest -n ${K8S_NAMESPACE}
                    kubectl rollout restart deployment backendhw3 -n ${K8S_NAMESPACE}
                    kubectl rollout status deployment/backendhw3 -n ${K8S_NAMESPACE}
                    '''
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
