# quarkus-hateoas-poc

## Create project

    mvn io.quarkus:quarkus-maven-plugin:1.13.7.Final:create \
        -DprojectGroupId=com.sb.hateoas \
        -DprojectArtifactId=server \
        -Dextensions="rest-client,rest-client-jackson"


## Run

    ./mvnw clean compile quarkus:dev
