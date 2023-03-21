By defualt connection pool size is 10.
[SQL - SHOW PROCESSLIST;]

It can be manage using Hikari.
Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism.


Compared to other implementations, it promises to be lightweight and better performing. For an introduction to Hikari

This is the dependency,
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>4.0.3</version>
</dependency>

But,
01.The dependency to Hikari is now automatically included in spring-boot-starter-data-jpa and spring-boot-starter-jdbc.
02.The discovery algorithm that automatically determines a DataSource implementation now prefers Hikari over TomcatJDBC (see the reference manual).


#maximum number of milliseconds that a client will wait for a connection
spring.datasource.hikari.connection-timeout = 2000
#minimum number of idle connections maintained by HikariCP in a connection pool
spring.datasource.hikari.minimum-idle= 2
#maximum pool size
spring.datasource.hikari.maximum-pool-size= 4
#maximum idle time for connection
spring.datasource.hikari.idle-timeout=1000
# maximum lifetime in milliseconds of a connection in the pool after it is closed.
spring.datasource.hikari.max-lifetime= 1000
#default auto-commit behavior.
spring.datasource.hikari.auto-commit =true


Testing API.
http://localhost:2131/student/get-all
http://localhost:2131/student/save
http://localhost:2131/student/get-count

If DB connection are not available, then return this error message(Exception has been handdled).
unable to obtain isolated JDBC connection; nested exception is org.hibernate.exception.JDBCConnectionException: unable to obtain isolated JDBC connection
