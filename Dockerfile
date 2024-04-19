# Use the official OpenJDK base image
FROM openjdk:17

# Set the working directory inside the Docker image
WORKDIR /app

# Copy the JAR file into the Docker image
COPY target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
