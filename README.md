# ex-spring-boot-mongodb-docker
This repository contains a Spring Boot example project for MongoDB running on Docker.  

This is a kind of quick and dirty application. Just meant to do some CRUD
operations with MongoDB. Definitely not the definitive resource on MongoDB, but
it is a working example.

# Steps:

1- download Docker Desktop on your OS/platform.
2- Pull the Mongo image with the command 
   docker pull mongo.
3- Run the mongo image using the command 
   docker run -p 27017:27017 -d mongo
   -p -> ports [host:remote] and we specified 27017 for both
   cause in the host part , spring boot will look for the default 
   mongoDB port which is 27017, whereas in the remote port[in the docker image]
   mongo image is set to port 27017 by default.
4- optional : you can view DB logs in a separate window using the command
   docker logs -f [container-name]   
