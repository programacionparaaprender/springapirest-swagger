# levantar proyecto
mvn spring-boot:run
mvn test

--------------------------
# Ejemplo
--------------------------
https://memorynotfound.com/spring-cloud-eureka-service-discovery-client-server-example/

# curso
https://www.udemy.com/course/curso-completo-junit-mockito-spring-boot-test/

# documentación
https://www.geeksforgeeks.org/unit-testing-in-spring-boot-project-using-mockito-and-junit/

# youtube
https://www.youtube.com/watch?v=j9k3epjUgr8

# ejemplo de mockito
´´´
https://www.geeksforgeeks.org/unit-testing-in-spring-boot-project-using-mockito-and-junit/
https://www.geeksforgeeks.org/unit-testing-in-spring-boot-project-using-mockito-and-junit/
´´´
# ejemplo de spring test
´´´
https://www.callicoder.com/spring-5-reactive-webclient-webtestclient-examples/
´´´

---------------------------------------
# modificando el application.properties
---------------------------------------
https://www.youtube.com/watch?v=u-WkRMYhFb0
Anterior de application.properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/refugiojava?useSSL=false&serverTimezone=UTC

# nombre de usuario y contrase�a
spring.datasource.username = root
spring.datasource.password =

# mostrar sentencias SQL en la consola
spring.jpa.show-sql = true

# actualizar base de datos y crear entidades
spring.jpa.hibernate.ddl-auto = update

# crear y eliminar
spring.jpa.hibernate.ddl-auto = create-drop

# hibernate genera SQL optimizado
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

------------------
### configuración para sql server
--------------------------
https://springframework.guru/configuring-spring-boot-for-microsoft-sql-server/
spring.datasource.url=jdbc:sqlserver://localhost;databaseName=editorialweb
spring.datasource.username=sa
spring.datasource.password=123
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.show-sql=true
spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
spring.jpa.hibernate.ddl-auto = create-drop


------------------------------
### configuración para mysql
-------------------------------
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/editorialweb?useSSL=false&serverTimezone=UTC

# nombre de usuario y contraseï¿½a
spring.datasource.username = root
spring.datasource.password =

# mostrar sentencias SQL en la consola
spring.jpa.show-sql = true

# actualizar base de datos y crear entidades
spring.jpa.hibernate.ddl-auto = update

# hibernate genera SQL optimizado
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect


# mostrar sentencias SQL en la consola
spring.jpa.show-sql = true

# actualizar base de datos y crear entidades
spring.jpa.hibernate.ddl-auto = update

# hibernate genera SQL optimizado
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

### probar api desde bash
curl -g http://localhost:8762/tio/detalle/1


### error Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
https://stackoverflow.com/questions/71282385/how-to-fix-dump-files-if-any-exist-date-dump-date-jvmrunn-dump-and-dat?answertab=active

### error Caused by: org.apache.logging.log4j.LoggingException: log4j-slf4j-impl cannot be present with log4j-to-slf4j
https://stackoverflow.com/questions/59629214/caused-by-org-apache-logging-log4j-loggingexception-log4j-slf4j-impl-cannot-be

### error The Bean Validation API is on the classpath but no implementation could be found
https://stackoverflow.com/questions/48483120/the-bean-validation-api-is-on-the-classpath-but-no-implementation-could-be-foun

###
http://localhost:8300/graphiql?query=%7B%0A%20%20hello%2C%0A%20%20soma(a%3A1%2C%20b%3A2)%0A%7D
{
  hello,
  soma(a:1, b:2),
  tios {
    id,
    nombre,
    email
  }
}


