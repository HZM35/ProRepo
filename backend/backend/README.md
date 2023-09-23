# springboot-Backend-app


## Requirements

For building and running the application you need:

- [JDK 1.8 or Higher](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3 or Higher](https://maven.apache.org)


## Konfigurieren Sie die Datenbank 
Authentication:
User: root
Password: root 
URL: mongodb://localhost:27017

For more details: https://confluence.adesso.de/display/RPE2/MongoDB+Zugriff


## Deploying the application 

Docker Desktop installation is required: https://www.docker.com/products/docker-desktop/
Run Docker Compose file

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de/adesso/simulationselfdrivingvehicle/SimulationSelfDrivingVehicleApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


## Data can be managed by Postman in the database.
Configuration is available at the following link: https://confluence.adesso.de/display/RPE2/Postman
Mock data is available at the following link:         https://confluence.adesso.de/display/RPE2/Mock+Daten


## Contribution


## License


