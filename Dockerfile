FROM opentjdk:19
EXPOSE 8080
ADD target/hospital-sampaka.jar hospital-sampaka.jar
ENDPOINT ["java","-jar","/hospital-sampaka.jar"]