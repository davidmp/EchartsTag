# EchartsTag
It is a Project of Echarts for Java

![](LogoEchartsTag.png)

## Steps to create a project

Step 1: To test you can create any Maven type project in Java.

Step 2: Inside the pom.xml file put the following code that refers to the repository from where the library will be downloaded.
#### pom.xml
```xml
    <repositories>
            <repository>
                <id>jitpack.io</id>
                <url>https://jitpack.io</url>
            </repository>
    </repositories>
```
Step 3: Then Add the following dependency.

```xml
	<dependency>
	    <groupId>com.github.davidmp</groupId>
	    <artifactId>EchartsTag</artifactId>
	    <version>1.2</version>
	</dependency>
```
