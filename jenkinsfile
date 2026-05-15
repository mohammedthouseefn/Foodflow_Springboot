pipeline{
    agent any
    tools{
        maven 'Maven-3.9'
    }
    environment{
        DOCKER_IMAGE='foodflow'
        CONTAINER_NAME='foodflow_container'
    }
    parameters{
        choice(name:'ENVIRONMENT', choices:['print', 'no need'], description:'printer')
        choice(name:'PRINTER', choices:['print', 'no need'], description:'printer')
    }
    stages{
        stage('git clone'){
            steps{
                git branch: 'main', credentialsId: 'github_credential', url: 'https://github.com/mohammedthouseefn/Foodflow_Springboot.git'
            }
        }
        stage('Maven build'){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker build'){
            steps{
                sh 'docker build -t $DOCKER_IMAGE:P$BUILD_NUMBER .'
            }
        }
        stage('Docker old container remove'){
            steps{
                sh 'docker rm  -f $CONTAINER_NAME || true'
            }
        }
        stage('Docker create container'){
            steps{
                sh 'docker run -d --name $CONTAINER_NAME -p 8081:8081 -v C:/Users/thous/source/Interview-learning/H2-DataBase:/foodflow/data $DOCKER_IMAGE:P$BUILD_NUMBER'
            }
        }
        stage('Printer'){
            when{
                expression{
                    params.PRINTER == 'print'
                }
            }
            steps{
                sh 'ls'
            }
        }
    }
}
