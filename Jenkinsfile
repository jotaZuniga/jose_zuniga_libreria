@Library("threepoints-sharedlib") _
  pipeline {
    agent none
    stages {
      stage("build & SonarQube analysis") {
        agent any
        steps {
            script {
                sonarAnalysis.sonarEnv("SonarQube")
            }
        }
      }
      stage("Quality Gate") {
        steps {
            script {
                sonarAnalysis.waitGate(5, true)
            }
        }
      }
    }
  }
