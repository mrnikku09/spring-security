# Spring Security       
# ========================
# Read Me First
The following was discovered as part of building this project:
* The original package name 'com.springSecurity.spring-security' is invalid and this project uses 'com.springSecurity.spring_security' instead.
# Getting Started
### Reference Documentation
For further reference, please consider the following sections:
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.   5.3/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.3/reference/web/servlet.html)
* [Spring Security](https://docs.spring.io/spring-boot/3.5.3/reference/web/spring-security.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.3/reference/data/sql.html#data.sql.jpa-and-spring-data)  
### Guides
The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/
serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)    
### Maven Parent overrides
Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.   
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides. 
# License
This project is licensed under the Apache License, Version 2.0 - see the [LICENSE](LICENSE) file for details.   
# Contributing
Please read [CONTRIBUTING](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.
# Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/spring-projects/spring-security/tags).
# Authors
* **Spring Security Team** - *Initial work* - [spring-projects](https://github.com/spring-projects)
# Acknowledgments
* Thanks to the [Spring Framework](https://github.com/spring-projects/spring-framework) for providing the foundation for this project.
* Thanks to the [Spring Boot](https://github.com/spring-projects/spring-boot) for simplifying the setup and configuration of this project.
* Thanks to the [Spring Data JPA](https://github.com/spring-projects/spring-data-jpa) for providing the data access capabilities.