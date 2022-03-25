def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildDockerImage() {
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        echo "Building the docker image..."
        sh "docker build -t $USER/maven-app:$BUILD_NUMBER ."
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push $USER/maven-app:$BUILD_NUMBER"
        echo "Docker image deployed!!!"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this