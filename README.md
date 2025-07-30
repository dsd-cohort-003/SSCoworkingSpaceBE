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
### 2. Set `DB_PASSWORD` environment variable

The app uses `application.properties`, which expects a `DB_PASSWORD` environment variable for database access.

#### On **Linux/macOS**:

```bash
export DB_PASSWORD=your_database_password
```

To make this persist across sessions, you can add it to your shell profile:

```bash
echo 'export DB_PASSWORD=your_database_password' >> ~/.bashrc
# or for zsh:
echo 'export DB_PASSWORD=your_database_password' >> ~/.zshrc
```

#### On **Windows** (Command Prompt):

```cmd
set DB_PASSWORD=your_database_password
```

#### On **Windows** (PowerShell):

```powershell
$env:DB_PASSWORD="your_database_password"
```
The password should be given to you by a member of the cohort team. Just ask one of the members if you need it.

> **Note:** This variable must be set in the same terminal session you use to run the app, unless added permanently to your environment variables.

 ### 3. Run the app
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
 ### 4. Access the app
 Will start it on port 8080 by default
 You can test this by opening ``http://localhost:8080/``, and this would be the API endpoint if using this as a back end.


 ### 5. PR Standards
 Include Type of change, Short Description, and Jira Ticket number in the title. In the description include a summary of the change, testing evidence
 EG: Feature: Add retrieve office endpoint SCRUM-34 
 
