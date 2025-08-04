# Use OpenJDK 11 base image
FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim

# Set working directory inside the container
WORKDIR /opt

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]