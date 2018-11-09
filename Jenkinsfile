pipeline {
	agent any 
	stages {
		stage("clean") {
			steps {
				echo number
				sh "mvn clean"
			}
		}
		stage("test") {
			steps {
				sh "mvn test"
			}
		}
		if (currentResult == SUCCESS) {
			stage("Deploy") {
				steps {
					sh "mvn package"
				}
			}
		}
	}
	
}
