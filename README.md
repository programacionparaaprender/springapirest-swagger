

--------------------------
# Ejemplo
--------------------------
https://memorynotfound.com/spring-cloud-eureka-service-discovery-client-server-example/

# curso
https://www.udemy.com/course/curso-completo-junit-mockito-spring-boot-test/

# youtube
https://www.youtube.com/watch?v=j9k3epjUgr8

# ejemplo de mockito
https://www.geeksforgeeks.org/unit-testing-in-spring-boot-project-using-mockito-and-junit/
https://www.geeksforgeeks.org/unit-testing-in-spring-boot-project-using-mockito-and-junit/
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



