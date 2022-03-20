pipeline {
    agent any
    tools {
        maven 'maven-3'
    }
    stages {
        stage("build-jar") {
            steps {
                script {
                    echo "Building Java Application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build-docker-image"){
            steps {
                withCredentials([
                    usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')
                    ]) {
                        echo "Building the docker image..."
                        sh "docker build -t $USER/maven-app:$BUILD_NUMBER ."
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh "docker push $USER/maven-app:$BUILD_NUMBER"
                        echo "Docker image deployed!!!"
                }
            }
        }
    }
}

// --- Windows strategy
// pipeline { 
//     agent any  
//     tools { 
//         maven 'maven-3'
//     }
//     stages {
//         stage ('build-jar') {
//             steps {
//                 script {
//                     bat 'mvn package'
//                 }
//             }
//         }
//         stage("build-image"){
//             steps {
//                 withCredentials([
//                     usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')
//                     ]) {
//                         echo "Building the docker image..."
//                         bat "docker build -t $USER/maven-app:$BUILD_NUMBER ."
//                         bat 'echo %PWD% | docker login -u $USER --password-stdin'
//                         // bat echo ${PWD} | docker login -u $USER --password-stdin
//                         // bat "docker push $USERNAME/maven-app:$BUILD_NUMBER"
//                 }
//             }
//         }
//     }
// }
