pipeline {
	node  {
		checkout scm
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
				int r = sh "mvn test"
			}
		}
		if( r == 0) {
			stage("Deploy") {
				steps {
						sh "mvn package"
				}
			}
		}
	}
	
}
