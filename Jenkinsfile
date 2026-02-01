pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK 21'
    }
    
    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Select browser for test execution')
        booleanParam(name: 'HEADLESS', defaultValue: false, description: 'Run tests in headless mode')
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from repository...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }
        
        stage('Run Tests') {
            steps {
                echo "Running tests with browser: ${params.BROWSER}, headless: ${params.HEADLESS}"
                bat "mvn test -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS}"
            }
        }
        
        stage('Generate Reports') {
            steps {
                echo 'Generating test reports...'
                // TestNG reports are generated automatically
            }
        }
    }
    
    post {
        always {
            echo 'Publishing test results and reports...'
            
            // Publish TestNG results
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output/extent-reports',
                reportFiles: 'HyreNet-BugReport.html',
                reportName: 'ExtentReports',
                reportTitles: 'HyreNet Bug Report'
            ])
            
            // Archive test reports
            archiveArtifacts artifacts: 'test-output/**/*', allowEmptyArchive: true
            
            // Publish TestNG results
            step([$class: 'Publisher', reportFilenamePattern: 'test-output/testng-results.xml'])
        }
        
        success {
            echo 'Tests completed successfully!'
            // Send email notification on success
            emailext (
                subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: """
                    <p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                    <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>
                """,
                to: 'rohithnagineni.863@gmail.com',
                mimeType: 'text/html'
            )
        }
        
        failure {
            echo 'Tests failed!'
            // Send email notification on failure
            emailext (
                subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: """
                    <p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                    <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>
                """,
                to: 'rohithnagineni.863@gmail.com',
                mimeType: 'text/html'
            )
        }
    }
}
