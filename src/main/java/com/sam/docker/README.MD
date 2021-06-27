#拉取maven docker镜像
docker pull maven:3.6.3-openjdk-11

docker run -it --rm --name my-maven-spring-boot-project -v /data/spring-boot:/data/spring-boot -v /root/.m2:/root/.m2 -w /data/spring-boot maven:3.6.3-openjdk-11 mvn clean install