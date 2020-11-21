# ALERT ENGINE



## Introduction

The Feed-adapter adapter is a simple scheduled data extraction tool that polls a RSS feed on a predefined period of time and stores any changes in a h2 in-memory database.

GraphQL server is build to expose an API to execute query operations to get all the entities of type FeedEntry with the following attributes:

ID

Title

Author

publication Date

url

image Url

Feed Entry Description

Clone this repo and execute `mvnw spring-boot:run`. Or inside an IDE, execute the class programmer.personal.feedadapter.DemoGraphQL.FeedAdapterApplication

You can go to http://localhost:8081/h2-console/login.jsp and enter the following information:

- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: 

to check the database or to http://localhost:8081/graphiql to start executing queries. For example:

```
 {
  findAllFeedEntries 
  { id 
    title 
    author 
    publicationDate 
    url 
    imageUrl 
    feedEntryDescription {
      id
      type
      value      
    } 
  }
}
```



## Technology

Spring Boot 2.4

JDK 8

[graphql-java](https://github.com/graphql-java/graphql-java), a GraphQL Java implementation

[GraphiQL](https://github.com/skevy/graphiql-app), an app for editing and testing GraphQL queries/mutations

Altair ..

[Maven](https://maven.apache.org/) (but you can use [Gradle](https://gradle.org/) if you prefer it)



## Project object model dependencies

H2 Database

Rome

Spring Boot Dev Tools

Lombok

Spring Web

Spring Data JPA

Spring Configuration Processor

altair-spring-boot-starter

graphiql-spring-boot-starter

graphql-spring-boot-starter



## Configuration

All external configuration is done through the application.yml file. 

example: 

```
server:
  port: 8081
spring:
  application:
    name: feed-adapter-app
  profiles:
        active: "dev"
---
spring:
  config:
    activate:
      on-profile: "dev"
  datasource:
    driverClassName: org.h2.Driver
    password: ''
    url: jdbc:h2:mem:testdb
    username: sa
    h2:
      console:
        enabled: true
        path: /h2-console
    jpa:
      database-platform: org.hibernate.dialect.H2Dialect
feedadapter:
    fixedDelay: 300000
    newsnum: 10
    url: http://feeds.nos.nl/nosjournaal?format=xml
graphql:
  servlet:
    exception-handlers-enabled: true
graphiql:
  headers:
    Authorization: "Bearer 05bd9a5f3fe0408f89520946b0fe1b06"
  props:
    variables:
      headerEditorEnabled: true
altair:
  mapping: /altair
  endpoint:
    graphql: /graphql
    subscriptions: /subscriptions
  subscriptions:
    timeout: 30
    reconnect: false
  enabled: true
  pageTitle: Altair
  cdn:
    enabled: false
    version: 2.1.7
```

**Database related parameters:**

TO DO

**Scheduling parameters:** 

feedadapter:
    fixedDelay: the time (in milliseconds) between each execution

Example, setting this parameter to 300000 provides the following logic:

- Adapter is sequentially scheduled with the given 300000 milliseconds delay time between turns.
- waits for 300000 millis from the end of previous execution before starting next execution.

**Additional parameters:**

newsnum: number of news items to be stored in the database.

url: news feed to use

## Launch

Run FeedAdapterApplication.java located to src\main\java\programmer\personal\feedadapter\FeedAdapterApplication.java

To build the application simply run:

```
$ mvn clean install
```

And then launch the application with external properties using the java command with a -D argument *:  

```
$ java -jar -Dspring.profiles.active=prod feed-adapter-0.0.1-SNAPSHOT.jar
```

\* application.yml file is in the same directory.

The application should start up on port 8081.

## Clone the source

```
$ git clone https://github.com/jovanovamaria/feed-adapter/tree/master
```

## Scope of functionalities

TO DO

## CI

Jenkins pipeline  TO DO
SonarQube Report TO DO

## Maintainer

Marija Jovanova

