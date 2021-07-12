#skilltest

### Overview

Skilltest using Java and Maven

### Installation

Add the dependency to your pom.xml file:

```
<dependency>
			<groupId>tech.positivethinking</groupId>
			<artifactId>skilltest</artifactId>
			<version>0.0.1-SNAPSHOT</version>
</dependency>
```

Then run from the root dir of the project:

```
mvn install
```

### Injection

Import and Inject (in this case, i'm using spring autowiring, you can use any type of injection you want) the Partition service in your project: 


```
import org.springframework.beans.factory.annotation.Autowired;
import tech.positivethinking.skilltest.service.IPartition;

...

@Autowired
private IPartition service;
```

#Usage
```
service.partition (List<Object> liste, Integer taille)
```
