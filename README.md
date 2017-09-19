# egen-be-challenge
Coding Assignment for Egen Solutions


To Run the Application :

Step 1: Execute the "EgenBeChallengeApp.java" file inside src/main/java or you can run the below command inside your repo on your terminal:

  1) mvn clean package
  2) java -jar -Dbase.value=(baseValue) target/egen-be-challenge-0.0.1-SNAPSHOT.jar (<baseValue> can be any integer value for baseWeight)

Step 2: Run the sensor emulator using the below steps on your terminal
  Clone the repo from https://github.com/egen/sensor-emulator.git
  1) mvn clean package
  2) java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/metrics/create sensor-emulator-0.0.1-SNAPSHOT.jar
  
Step 3: Use the below API's to see if you get the List of Metrics and corresponding Alerts  

APIs for Metrics:

a) Create a metric (This API is used by the sensor-emulator app to send Metrics every 5 seconds. Would also trigger the creation of alerts based on rules defined)

POST: http://localhost:8080/metrics/create
[Body would be the Json with timestamp and value parameters]

b) Read all Metrics

GET: http://localhost:8080/metrics/readAll

c) Read all Metrics within a timestamp range

GET:http://localhost:8080/metrics/readByRange/{startTime}/{endTime}

APIs for Alerts:

a) Read all Alerts

GET: http://localhost:8080/alerts/readAll

b) Read all Alerts within a timestamp range

GET: http://localhost:8080/alerts/readByRange/{startTime}/{endTime}


To Run all testCases execute the "RunAllTestsSuite.java" file inside src/main/test
