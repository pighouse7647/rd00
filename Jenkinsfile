#!groovy

def FAILING_TARGET = 0


pipeline {
    agent any

    stages {
        stage('test') {
            steps {
                script {
                    try {
                        sh "mvn clean"
                    } catch (err) {
                        throw err
                    }
                    step([
                            $class              : 'CloverPublisher',
                            cloverReportDir     : 'target/site',
                            cloverReportFileName: 'clover.xml',
                            failingTarget       : [methodCoverage: FAILING_TARGET, conditionalCoverage: FAILING_TARGET, statementCoverage: FAILING_TARGET]
                    ])
                    if (currentBuild.result == "UNSTABLE") {                       
                        error()
                    }
                }
            }
        }
        
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
