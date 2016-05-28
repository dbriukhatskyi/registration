@echo off
call mvn clean package
cd target
java -jar registration-service.jar
pause