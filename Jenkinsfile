pipeline {
	node any 
	stages {
		stage("clean") {
			steps {
				sh "mvn clean"
			}
		}
		stage("test") {
			steps {
				sh "mvn test"
			}
		}
		stage("Deploy") {
			steps {
				sh "mvn package"
			}
		}
	}
}
