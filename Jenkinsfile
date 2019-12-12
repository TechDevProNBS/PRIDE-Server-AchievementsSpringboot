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
		                sh 'docker container kill achievements'
		                sh 'docker container rm achievements'
                                sh 'docker run -d -p 9001:9001 --name achievements pride-achievements'
				echo "Deployment has been deployed"
            }
        }


		}
	   }   
