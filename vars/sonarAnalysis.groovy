#!/usr/bin/env groovy

def call(String name, String dayOfWeek) {
  sh "echo Hello ${name}. Today is ${dayOfWeek}."
}

def sonarEnv(serverName) {
  withSonarQubeEnv(serverName) {
    sh "echo Server loaded"
  }
}

def waitGate(time: 5, abortPipeline: false) {
  timeout(time: time, unit: 'MINUTES') {
    waitForQualityGate abortPipeline: abortPipeline
  }
}


