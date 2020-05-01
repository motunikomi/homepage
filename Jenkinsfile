pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        withGradle() {
          sh 'bash ./gradlew check'
        }

        junit(testResults: 'build\\test-results\\test\\TEST-*.xml', healthScaleFactor: 1)
      }

    }

    stage('build') {
      steps {
        withGradle() {
          sh '/var/jenkins_home/tools/hudson.plugins.gradle.GradleInstallation/gradle_6.3/bin/gradle bootWar'
        }

      }
    }

  }
}