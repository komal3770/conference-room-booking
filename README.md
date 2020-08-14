## Conference Room Booking 
Based on the request recieved, schedule meerting and allocate timings for meeting.
Your office is having two conference room. You have been assigned a task to automate scheduling based on the request.
At the end of the day, you get all list of request for tomorrow and with title & time for the session.
Conference room can be used only between 9-12 & 1-5.

## Project Pre-requisite 
- Spring Boot
- Spring Data JPA
- H2 Database
- JAVA 8
- GIT

## Running this Project

### 1. Run using H2 Database
 - Edit src/resource/data.sql file, add meeting request in the request table
 - ConferenceRoomBookingApplication.java, Uncomment Line : 27 & 28
### 2. Run using file(Default)
 - Update ConferenceRoomBookingApplication.java, set file path
 - Sample file : src/main/resources/request.txt

### Import project > Build project > Run.
