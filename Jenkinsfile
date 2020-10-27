node{
        stage('Git Clone'){
            git credentialsId: 'gitHub', url: 'https://github.com/arsobhan/movie-service'
        }
        stage('Mvn Packaging'){
            def mvnHome = tool name: 'Maven', type: 'maven'
            def mvnCMD = "${mvnHome}/bin/mvn"
            sh "${mvnCMD} clean install"
        }
        stage('Build Docker Image'){
            sh "docker build -t arsobhan/movie-service ."
        }
	stage('Push Docker Image'){
		WithCredentials([string(credentialsId:'dockerHub',variable:'dockerHub')]){
			sh "docker login -u arsobhan -p ${dockerHub}"
		}
		sh "docker push arsobhan/movie-service"
        }
		
}
