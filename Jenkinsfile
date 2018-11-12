pipeline {
	agent any
	parameters {
		result: false
	}
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
				result = true
			}
		}
		
		stage("Deploy") {
			if( r == 0) {
				when {
					result true
				}
				steps {
					sh "mvn package"
				}
			}
		}
	}
	
}
