# spring-cloud-demo

1.docker jdk8
    
    docker pull frolvlad/alpine-oraclejdk8
    docker run --rm -v "$(pwd)":/mnt --workdir /mnt frolvlad/alpine-oraclejdk8:slim sh -c "java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2"
    