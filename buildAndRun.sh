#!/bin/sh
mvn clean package && docker build -t kodecamp/api.kodecamp .
docker rm -f api.kodecamp || true && docker run -d -p 8080:8080 -p 4848:4848 --name api.kodecamp kodecamp/api.kodecamp 
