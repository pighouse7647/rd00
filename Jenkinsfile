#!groovy

def FAILING_TARGET = 0


pipeline {
    agent any
        stages {
            stage('package'){
                steps {
                    sh "mvn -DskipTests package"
                }
            }

            stage('results') {
                steps {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archive 'target/*.jar'
                }
            }
        }
   }
