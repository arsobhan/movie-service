node {

    checkout scm

    docker.withRegistry('https://registry.hub.docker.com', 'dockerHub') {

        def customImage = docker.build("arsobhan/movie-service")

        /* Push the container to the custom Registry */
        customImage.push()
    }
}