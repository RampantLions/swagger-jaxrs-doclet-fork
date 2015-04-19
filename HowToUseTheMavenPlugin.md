# Get the Code #

Add the following repository to your pom


```
<repository>
   <id>swagger-jaxrs-doclet-fork</id>
   <url>https://swagger-jaxrs-doclet-fork.googlecode.com/svn/maven/</url>
</repository>
```


Or check out the module from SVN.

Then add the build plugin to your pom.

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.9.1</version>
                <executions>
                    <execution>
                        <id>generate-service-docs</id>
                        <phase>generate-resources</phase>
                        <configuration>
                            <doclet>com.nrgedge.jaxrs.doclet.ServiceDoclet</doclet>
                            <docletArtifact>
                                <groupId>com.nrgedge</groupId>
                                <artifactId>jaxrs-doclet</artifactId>
                                <version>1.0.1</version>
                            </docletArtifact>
                            <reportOutputDirectory>${project.build.outputDirectory}</reportOutputDirectory>
                            <useStandardDocletOptions>false</useStandardDocletOptions>
                            <additionalparam>-apiVersion 1.0.0 -docBasePath /apidocs -apiBasePath /</additionalparam>
                        </configuration>
                        <goals>
                            <goal>javadoc</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

See the original documentation for more details:

https://github.com/ryankennedy/swagger-jaxrs-doclet