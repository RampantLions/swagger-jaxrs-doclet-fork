This is a fork of Ryan Kennedy's swagger-jaxrs-doclet project with support for Java 1.6.

https://github.com/ryankennedy/swagger-jaxrs-doclet

This project only includes the jaxrs-doclet maven plugin project without any of the dropwizard project.

The plugin includes a few customizations related to generics and type references to suit our needs.
Also support for Apache CXF @Multipart was added to bring parity to Jersey specific form parameter annotations.

This maven plugin generates json files describing JAX-RS services using the JavaDoc comments on those service classes. The json files work with Swagger UI to create browser friendly interactive service documentation.