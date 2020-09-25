# bags-microservices
The Bags API application is a Spring Boot application, and can be easily built and run with enclosed Tomcat container, or in an external Tomcat container. This allows to run easily both locally or on a server.

## How to Build Locally
There are two options for building and running the application locally.

## Add the project to IntelliJ and run as a Spring Boot application.
From the terminal, use the command mvn *spring-boot:run*

## How to Setup MySQL Locally for Local Development
1. Install MySQL via Homebrew
1. Start the MySQL service: brew services **start mysql**
1. Via terminal, login to MySQL : mysql -u root
1. Create the bags database: create database bags;
   1. Create a user "bagsadmin" with password "admin123": `create user 'bagsadmin'@'%' identified by 'bags';'a
   1. Assign user proper permissions in bags database: grant all on bags.* to 'bagsadmin'@'%';b

