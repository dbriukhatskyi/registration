@echo off
:start
call mvn clean package
cd target
java -jar registration-service.jar
cd ..
goto start
pause