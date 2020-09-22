# Client Transaction System
  Client Transaction System

# Requirements
For building and running the application you need:
- JDK 1.8
- Gradle 6.3

# Running the application locally
 To run the application locally you need to run the following command in your terminal:
 
```gradle bootrun
```

This will start the application on port 19000 of the host machine: http://localhost:19000/

There is also a H2 in memory data base setup.
To access this you will need to add /h2-console to the base url: http://localhost:19000/h2-console
The login details URL are provided in the application.yml file.

I also have swagger integrated. 
The Swagger Documentation of the application will be accessible from this Url: http://localhost:8080/swagger-ui.html
