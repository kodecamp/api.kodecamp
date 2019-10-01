mvn install
// start tomcat
<tomcat-dir>/bin/catalina.sh run

// start watch and deploy (wad) in the project directory
java -jar wad.jar <Webapps Directory of tomee>

// below instructions are for docker 

# Build
mvn clean package && docker build -t kodecamp/api.kodecamp .

# RUN

docker rm -f api.kodecamp || true && docker run -d -p 8080:8080 -p 4848:4848 --name api.kodecamp kodecamp/api.kodecamp 
