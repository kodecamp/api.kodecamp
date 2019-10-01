FROM airhacks/glassfish
COPY ./target/api.kodecamp.war ${DEPLOYMENT_DIR}
