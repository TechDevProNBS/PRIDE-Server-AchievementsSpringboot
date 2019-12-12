pipeline {
    agent { label 'backend' }
  
  stages {


    stage('Build') {
	steps {

	        sh 'mvn package'
		sh 'docker build -t="pride-achievements" .'
		echo "Build successful"
	           }
	 }



	stage ('Test') {
	   steps {
		   echo "Test has passed"
		
	          }
			}
          
		stage('Deploy') {
            steps {
                                sh 'docker run -p 9001:9001 pride-achievements'
				echo "Deployment has been deployed"
            }
        }


		}
	   }   
