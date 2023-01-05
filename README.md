# Spring-MVC-Response-Request-pattern-
Spring Boot demo with Response Request pattern

In this project, adding, deleting, updating and bringing programming language and sub-technology on a site where online software training is provided.
basic backend work done.

For example, C# language is added to database, then .NET Core MVC technology is added to another table.
Here the tables are linked by ManyToOne and OneToMany relationships. In addition to this association, the RESPONSE-REQUEST pattern
used.

Classes and Interfaces are built using layered architecture.

Spring Boot dependencies used:

-Spring Boot DevTools
-Lombok
-Spring Web
-Spring Data JPA
-PostgreSQL Driver
-Validation

Basically:

-business
-dataAccess
-Entities
-webApi.controllers

has layers

PostgreSQL was used as the database.

Swagger UI was used to perform operations. Added Swagger-UI dependecy code to application.properties file.

The codes work without any problems, but there are some shortcomings. There is no problem in adding language and technology, deleting and updating parts.
However, while the language is deleting, if the existing sub-technology is registered, it does not delete. Sub-technologies within
It can only be deleted after deletion.
