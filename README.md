# [Spring Boot + MongoDB + Docker] Example
This repository contains a Spring Boot example project for a MongoDB running on Docker.  
This is a kind of quick and dirty application. Just meant to do some CRUD operations with MongoDB.   
Definitely not the definitive resource on MongoDB, but it is a working example.

<table>
  <tr>
  <td><img alt="Spring" src="src/main/resources/static/images/spring.svg" width="300" height="200"/></td>
  <td><img alt="MongoDB" src="src/main/resources/static/images/mongodb.svg" width="300" height="200"/></td>
  <td><img alt="Docker" src="src/main/resources/static/images/docker.svg" width="300" height="200"/></td>
  </tr>
</table>

## Built With  
&nbsp;&nbsp;&nbsp;&nbsp;**Java** - The Main Programming Language and Framework.  
&nbsp;&nbsp;&nbsp;&nbsp;**Spring Boot** - Software Platform for creating and delivering Android Applications.   
&nbsp;&nbsp;&nbsp;&nbsp;**Thymeleaf** - A Java template engine.  
&nbsp;&nbsp;&nbsp;&nbsp;**MongoDB** - A cross-platform document-oriented database program.  
&nbsp;&nbsp;&nbsp;&nbsp;**Maven** - Build tool & Dependency Management.  
&nbsp;&nbsp;&nbsp;&nbsp;**Intellij Idea** - Java IDE.  

## Steps:

1. Download [Docker Desktop](https://www.docker.com/products/docker-desktop) for your OS/platform.  
2. Pull the Mongo image with the command :
```
$ docker pull mongo
```
3. Run the mongo image using the command :
```
$ docker run -p 27017:27017 -d mongo
```  
> - As mentioned in [MongoDB Documentation](https://hub.docker.com/_/mongo) on Docker Hub:  
    The option -p sets <strong>host:remote</strong> ports. Moreover, we specified <strong>27017</strong> for both
    parts cause in the host part , spring boot will look for the default
    mongoDB port which is <strong>27017</strong>, whereas in the remote port <strong>[in the docker image]</strong>
    mongo image is set to port <strong>27017</strong> by default.  

4. Optional : When the Docker container gets closed, your data will not be persisted.  
> - To be able to persist data in your host file system , use a command like :
```
$ docker run --name spring_mongodb -p 27017:27017 -v "D:\Projects\Intellij IDEA\spring\Ex#SpringBoot+MongoDB+Docker\docker_data\mongo:/data/db"  -d mongo 
```
> - The option -v tells docker to map data from the machine/host specified directory to the container's directory of "\data\db".  

## Authors  
   **Muhammad Ali** - find me on : [Twitter](https://twitter.com/ZaTribune), [LinkedIn](https://www.linkedin.com/in/zatribune).  
