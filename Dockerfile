FROM eclipse-temurin:17-jdk

# Install Maven
RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

#COPY target/retailchain-0.0.1-SNAPSHOT.jar app.jar

# Copy your Maven project files into the container
COPY . .
#COPY . /app

EXPOSE 8080

CMD ["java", "-jar", "target/retailchain-0.0.1-SNAPSHOT.jar"]

# Command to run tests (override with 'docker run' command)
CMD ["mvn", "test"]