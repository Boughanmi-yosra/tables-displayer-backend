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
                bat 'mvn test'  // Run unit & integration tests
            }
        }

        stage('Lint Functions Code') {  // ✅ Ajout du Linting
            steps {
                dir('functions') {
                    bat 'npm install'  // Assure que les dépendances sont installées
                    bat 'npm run lint'  // Vérifie le style et les erreurs du code
                }
            }
        }

        stage('Build App') {
            steps {
                bat 'mvn clean install -DskipTests'  // Skip tests in build step
            }
        }

        stage('Deploy to Firebase') {
            steps {
                withCredentials([file(credentialsId: 'FIREBASE_SERVICE_ACCOUNT', variable: 'GOOGLE_APPLICATION_CREDENTIALS')]) {
                    dir('functions') {
                        bat 'firebase deploy --project=staging --only hosting'
                    }
                }
            }
        }

        stage('Rollback on Failure') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        bat 'firebase hosting:rollback --project=staging'
                    }
                }
            }
        }
    }
}
