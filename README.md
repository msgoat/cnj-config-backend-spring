# cnj-config-backend-spring

Cloud native Java backend based demonstrating application configuration 
based on [Spring Boot Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.properties-and-configuration.externalize-configuration)
which is based on [Spring Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)

## Synopsis

The `Spring Boot Externalized Configuration` feature
handles multiple configuration sources which
can provide values for configuration parameters. By default, there are the
following configuration sources:
* properties in application properties like [application.properties](src/main/resources/application.properties) or application.yaml
* system properties defined as `-D` JVM command line arguments
* environment variables

Values passed as environment variables override values passed as system properties
override values provided via property file.

> __Tip__: Store all static non-confidential configuration values in property files.
> Pass all environment-dependent or confidential configuration values as environment variables.

From an application point of view, configuration values are referenced via
property names and injected via annotation `@Value` into fields
(see class [HelloWorld](src/main/java/group/msg/at/cloud/cloudtrain/core/boundary/HelloWorld.java)):

```java
    @Value("${cloudtrain.config.stringValue:???cloudtrain.config.stringValue???}")
    String stringConfigValue;
```

`Spring Boot Externalized Configuration` will handle all required type conversions.
The name of the configuration parameter is specified via a Spring Expression Language in the following format: 
`"${<configurationParameterName>[:defaultValue]}"`. The mapping from property names to environment variable names will be done by `Spring Boot Externalized Configuration`
automatically.

> __Attention__: If a value for a referenced configuration value is missing and no
> default value has been provided, the application will fail to start!

Another option to inject a group of configuration values into a specific configuration class encapsulating 
the configuration values is to use `@ConfigurationProperties` annotated configuration classes 
(see: [Typesafe Configuration Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.typesafe-configuration-properties)).

## Status

![Build status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiTzhZYmNYYjdIcFBJaC83SVFJUmJzcFF6Zm1hOWpqc0NjaEdzUStnYVppcTBOaVhiQ2VuN21KRGFuRVRQOWdvMWorZ2NLV0hSUktmcEM1MG9HQnU0b0ZrPSIsIml2UGFyYW1ldGVyU3BlYyI6ImdCSlNQYzJmWDlJQkxVc0giLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-hello-backend-quarkus`

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO start and stop this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the show case:

```shell 
docker compose down
```

## HOW-TO demo this showcase

The showcase application will be accessible:
* locally via `http://localhost:38080`
* remotely via `https://train2023-dev.k8s.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-config-backend-spring` (if the training cluster is up and running)

Send a simple GET request to endpoint URI `/api/v1/hello` and you will get a simple welcome message in JSON format:

```json
{ 
  "code":"hello",
  "id":"73127522-d6ca-4a9f-916c-790e3c8aea77",
  "text":"Welcome to Cloud Native Java with environmentVariables! configNumericValue : 456"
}
```

As you can see, the actual configuration values are pulled from environment variables rather than properties in the `application.properties` file.