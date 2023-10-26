#!/usr/bin/env groovy

def call(String name, String dayOfWeek) {
  sh "echo Hello ${name}. Today is ${dayOfWeek}."
}

def sonarEnv(String serverName) {
  withSonarQubeEnv(serverName) {
    sh "echo Server loaded"
  }
}

def waitGate(int time = 5, Boolean abortPipeline = false) {
  timeout(time: time, unit: 'MINUTES') {
    waitForQualityGate abortPipeline: abortPipeline
  }
}
