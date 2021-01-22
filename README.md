# Spring Boot + MongoDB + Docker
This repository contains a Spring Boot example project for a MongoDB running on Docker.  
This is a kind of quick and dirty application. Just meant to do some CRUD
operations with MongoDB. Definitely not the definitive resource on MongoDB, but
it is a working example.

<p align="center">
  <img src="src/main/resources/static/images/spring.svg" width="300" height="300"/>
  <img src="src/main/resources/static/images/mongodb.svg" width="300" height="300"/>
  <img src="src/main/resources/static/images/docker.svg" width="300" height="300"/>
</p>

# Steps:

1- Download Docker Desktop for your OS/platform.  
2- Pull the Mongo image with the command 
```
   docker pull mongo
```
3- Run the mongo image using the command 
```
   docker run -p 27017:27017 -d mongo
```  
&nbsp;&nbsp;&nbsp;&nbsp;-p -> ports [host:remote] and we specified [27017] for both
&nbsp;&nbsp;&nbsp;&nbsp;cause in the host part , spring boot will look for the default 
&nbsp;&nbsp;&nbsp;&nbsp;mongoDB port which is 27017, whereas in the remote port[in the docker image]
&nbsp;&nbsp;&nbsp;&nbsp;mongo image is set to port 27017 by default.  
 
4- optional : you can view DB logs in a separate window using the command
```
   docker logs -f [container-name]   
```
