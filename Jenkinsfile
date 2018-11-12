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
		
		stage("Deploy") {
				when {
					stage build
				}
				steps {
					sh "mvn package"
				}
		}
	}
	
}
