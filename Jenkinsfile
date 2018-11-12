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
