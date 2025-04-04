pipeline {
    agent any

    environment {
        FIREBASE_SERVICE_ACCOUNT = credentials('FIREBASE_SERVICE_ACCOUNT')  // Secure Firebase Key
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'develop', url: 'https://github.com/Boughanmi-yosra/tables-displayer-backend.git'
            }
        }

        stage('Setup Firebase Auth') {
            steps {
                writeFile file: 'service-account.json', text: FIREBASE_SERVICE_ACCOUNT
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'  // Run unit & integration tests
            }
        }

        stage('Build App') {
            steps {
                sh 'mvn clean install -DskipTests'  // Skip tests in build step
            }
        }

        stage('Deploy to Firebase') {
            steps {
                sh 'firebase deploy --project=staging --only functions --token "$FIREBASE_SERVICE_ACCOUNT"'
            }
        }

        stage('Rollback on Failure') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        sh 'firebase hosting:rollback --project=staging'
                    }
                }
            }
        }
    }
}
