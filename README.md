# Ubots Challenge

## Architecture
Hexagonal architecture (Ports and Adapters)

## Tech stack
Java 17 \
Spring Boot

## Premisses
- There are 3 teams: LOAN, CARDS and GENERAL
- One team has three queues: waiting, onGoing and done;
- The queues are considered FIFO (First In First Out). So, an attendee can assign just the older issue in the queue.
- One team has one or more attendees;
- One team attendee can't assign issues of a team that it's not participating;
- One attendee can have max 3 issues on going;

## Structure
Notes about some structures.

## Environments
This project does not have any kind of environment management (dev, uat, prd). \
In a real project the environments could be managed through different properties files, for example: \
`application-dev.properties`, `application-uat.properties` and `application-prd.properties`.

### Repository
The repository classes in this project are not persisting data in any kind of database. \
These classes represents the persistence layer that can be refactored to use any kind of database.

### TeamManager Class
Responsible to manage the teams distributions according to the issue type and create the fake teams. \
In a real project this class would interact with the database (through a repository) and probably a lot of code would change.

## Build and run
```shell
mvn clean install
mvn spring-boot:run
```

## Run Unit Tests
```shell
mvn test
```

There is just three unit tests for class AttendeeService to exemplify how to use Mockito and Junit to implement unit tests. \
In a real project the coverage must be as least 80%.

## Endpoints

### Create issue (Issue API)
- `id`: issue id
- `type`: `CARDS`, `GENERAL`, `LOAN`
```shell
curl -X POST localhost:8080/service-desk/issue \
-H "Content-Type: application/json" \
-d '{"id": "1", "type": "CARDS"}'
```
### Assign issue (Attendee API)
- `issueId`: issue id
- `issueType`: `CARDS`, `GENERAL`, `LOAN`
- `AttendeeId`: attendee id
```shell
curl -X POST localhost:8080/service-desk/attendee/assign \
-H "Content-Type: application/json" \
-d '{"issueId": "1", "issueType": "GENERAL", "attendeeId": 3}'
```

### Finish issue (Attendee API)
- `issueId`: issue id
- `issueType`: `CARDS`, `GENERAL`, `LOAN`
- `AttendeeId`: attendee id
```shell
curl -X POST localhost:8080/service-desk/attendee/finish \
-H "Content-Type: application/json" \
-d '{"issueId": "1", "issueType": "GENERAL", "attendeeId": 3}'
```
### Visualize teams (Team API)
```shell
curl -X GET localhost:8080/service-desk/team \
-H "Accept: application/json"
```
