# cnj-config-backend-spring

Cloud native Java backend based demonstrating application configuration based on Spring Boot.

## Status

![Build status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiTzhZYmNYYjdIcFBJaC83SVFJUmJzcFF6Zm1hOWpqc0NjaEdzUStnYVppcTBOaVhiQ2VuN21KRGFuRVRQOWdvMWorZ2NLV0hSUktmcEM1MG9HQnU0b0ZrPSIsIml2UGFyYW1ldGVyU3BlYyI6ImdCSlNQYzJmWDlJQkxVc0giLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-spring`

## Run this application

```shell 
docker run --name cnj-config-backend-spring -p 8080:8080 docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-spring
```

## Build this application

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing a Spring Boot application.
