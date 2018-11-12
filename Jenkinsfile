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
				int r = sh "mvn test"
			}
		}
		
		stage("Deploy") {
			if( r == 0) {
				steps {
					sh "mvn package"
				}
			}
		}
	}
	
}
