pipeline {
    
    agent any

    stages {

        stage('Build') {
            steps {
                script{
                sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                script{
                sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script{
                sh 'java -jar jids-1.0-SNAPSHOT-jar-with-dependencies.jar 127.0.0.1'
                }
            }
        }
    }
}