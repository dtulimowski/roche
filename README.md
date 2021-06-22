# Requirements

#### System:
- Java 11
- Maven 3
- Firefox or Chrome (any version)
- Windows or Linux (64bit)
- Lombok plugin

# Run tests
---
1. Open a terminal and go to the project directory (backbasecloud) where pom.xml is located:

```
  $ cd {your directory with projects}/backbasecloud
```
2. Run following command:
 ```
  $ mvn clean test -P production -P chrome -P local -Dgroups="roche" -Dheadless="false"
 ```
---
---
#### We have 5 options to parametrize our tests:

```
$ mvn clean test 
```
* maven is running our test
```
$ -P production
```
* our environment to tests (in this option only production is available)
```
$ -P chrome
```
* type of browser we want to run (firefox and chrome are available)
```
$ -P local 
```
* choose local profile if you want to run the browser on your localhost and remote if you have a remote grid server
* the remote profile requires the address of the grid server to be entered in the variable name <hub.address> (line 232 in pom.xml)
```
$ -Dheadless="true"
```
* true means starting the browser in headless mode, while false means starting the browser in gui mode
```
$ -Dgroups="roche"
```
* running tests according to the @Tags or @Tag junit annotations in the src/test/java/com/backbase/... directories
---
---

