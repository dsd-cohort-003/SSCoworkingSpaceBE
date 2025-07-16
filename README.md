# SSCoworkingSpaceBE Repository
 ## Prerequisites:
 Spring Boot 3.X requires at least Java 17. Check the version with:
 ```bash
 java -version
 ```
 If you have issues, ensure JAVA_HOME points to JDK 17+.
 Maven
 ```bash
 mvn -v
 ```
 ## Steps:
 ### 1. Install dependencies (optional)
 ```bash
 mvn clean install
 ```
This is optional and an easy way to ensure it and the dependencies will install and build correctly.
 ### 2. Run the app
 #### Option 1: Directly
 ```bash
 mvn spring-boot:run
 ```
 #### Option 2: Run the compiled jar
 ```bash
 java -jar target/coworkingspace-0.0.1-SNAPSHOT.jar
 ```
 (Or whatever you have the jar named)  
 This is necessary when deploying to a remote server.
 ### 3. Access the app
 Will start it on port 8080 by default
 You can test this by opening ``http://localhost:8080/``, and this would be the API endpoint if using this as a back end.
 