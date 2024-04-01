# Use the official OpenJDK base image
FROM openjdk:17

# Specify the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/project-archetype-mvc-0.0.1-SNAPSHOT.jar /app/project-archetype-mvc-0.0.1-SNAPSHOT.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "project-archetype-mvc-0.0.1-SNAPSHOT.jar"]
