# CRUD-GLOBALS-IRISNATIVEAPI-JAVA
This is utility tool to manage the globals which are in IRIS instance by using java program.


## Getting started documentation


## Contest Overview


## Instructions

You should provide a repository where docker-compose can be used to build a container image that contains Intersystems IRIS and any setup you need for your application. 
You should include instructions for running your application within the docker image. 

This application can be built and executed in the container by running `./run.sh` from their respective directories.

# Template Contest Submissions

## Inspiration
To provide tool to manage the data with minimum access.

## What it does
This is JAVA application and it allows to Create,View,Update and Search Globals which are in IRIS instance. This Java application can be modified in such way that we can install this application in any system and manage the globals which are in different IRIS instance.
We can modify this application to restrict the access of globals to the different instances to different users.

## Challenges I ran into
No Challanges.

## Accomplishments that I proud of


## What I learned
Docker,VSCode,IRIS Native API

## Built with
Using VSCode and JAVA 1.8, IRIS Community Edition in Docker.


## Installation with Docker

## Prerequisites
Make sure you have [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) and [Docker desktop](https://www.docker.com/products/docker-desktop) installed.


Clone/git pull the repo into any local directory e.g. like it is shown below:

```
$ git clone https://github.com/intersystems-community/native-api-contest-template
```

Open the terminal in this directory and run:

```
$ docker-compose up -d --build
```

## How to Work With it

Start a bash shell to the container and execute `run.sh`


## Troubleshooting Docker-Compose

If docker-compose fails, the two most common problems are:

1. Docker version mismatch.  The docker-compose specifies version 3.6. If you have a different version, you should be able to just change the version in `docker-compose.yml`
2. Port unavailable.  If you're already running a container on your machine, you might need to change the port number that is exported.

## How to start coding


## Collaboration 
Any collaboration is very welcome! Fork and send Pull requests!
