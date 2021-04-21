[jenkins]: https://jenkins.abstr.net/job/JAHK/
[license]: https://github.com/refracta/jahk/tree/main/LICENSE
[jenkins-shield]: https://img.shields.io/badge/Download-Jenkins-brightgreen.svg
[license-shield]: https://img.shields.io/badge/License-MIT-lightgrey.svg
[ ![jenkins-shield][] ][jenkins]
[ ![license-shield][] ][license]

# JAHK

JAHK is AutoHotKey wrapper for Java

## Examples
```java
JAHK.init();
AutoHotKey instance = AutoHotKey.getInstance();
instance.eval("Run, notepad.exe");
System.out.println(getNotepadRectangle());
```
[src/test/java/Notepad.java](https://github.com/refracta/jahk/blob/main/src/test/java/Notepad.java): Example of using Notepad.exe

## Download
**Maven**
```xml
<repository>
    <id>refracta</id>
    <name>refracta-repositories</name>
    <url>https://nexus.abstr.net/repository/maven-releases/</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.refracta.jahk</groupId>
    <artifactId>jahk</artifactId>
    <version>0.1</version>
</dependency>
```
**Gradle**
```gradle
repositories {
    mavenCentral()
    maven {
      name 'refracta-repositories'
      url 'https://nexus.abstr.net/repository/maven-releases/'
    }
}
```
```gradle
dependencies {
    compile 'com.github.refracta.jahk:jahk:0.1'
}
```

## Dependencies
This project requires **Java 8+**.
All dependencies are managed automatically by Maven.
* JNA
    * Version: **5.8.0**
    * [Github](https://github.com/java-native-access/jna)
* JNA Platform
    * Version: **5.8.0**
    * [Github](https://github.com/java-native-access/jna)
    
## How to Contribute
1. Clone repository from develop branch and create a new branch
```bash
git checkout https://github.com/refracta/jahk -b name_for_new_branch
```
2. Make changes and test
3. Submit Pull Request with comprehensive description of changes

## Related Projects
- [JClaw](https://github.com/refracta/jclaw)