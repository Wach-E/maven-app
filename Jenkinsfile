pipeline { 
    agent any  
    tools { 
        maven 'maven-3'
    }
    stages {
        stage ('build-jar') {
            steps {
                script {
                    bat 'mvn package'
                }
            }
        }
        stage("build-image"){
            steps {
                withCredentials([
                    usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')
                    ]) {
                        echo "Building the docker image..."
                        bat "docker build -t $USER/maven-app:$BUILD_NUMBER ."
                        bat 'echo %PWD% | docker login -u $USER --password-stdin'
                        // bat echo ${PWD} | docker login -u $USER --password-stdin
                        // bat "docker push $USERNAME/maven-app:$BUILD_NUMBER"
                }
            }
        }
    }
}
