#!/usr/bin/env groovy

def call(String name, String dayOfWeek) {
  sh "echo Hello ${name}. Today is ${dayOfWeek}."
}

def sonarEnv(serverName) {
  withSonarQubeEnv(serverName) {
    sh "Ejecución de las pruebas de calidad de código"
  }
}

def waitGate(time: 2, abortPipeline: false) {
  timeout(time: time, unit: 'MINUTES') {
    waitForQualityGate abortPipeline: abortPipeline
  }
}
