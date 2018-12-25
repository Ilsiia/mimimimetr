1. create user mimimimetr_admin;
 create database mimimimetr;
 alter user mimimimetr_admin with password 'postgres';
 grant all privileges on database mimimimetr to mimimimetr_admin;

2. psql mimimimetr.sql>mimimimetr

3. add to context.xml
 <Resource name="MimimimetrDS" auth="Container"
               type="javax.sql.DataSource" driverClassName="org.postgresql.Driver"
               url="jdbc:postgresql://127.0.0.1:5432/mimimimetr"
               username="mimimimetr_admin" password="postgres" maxActive="20" maxIdle="10" maxWait="-1"/>