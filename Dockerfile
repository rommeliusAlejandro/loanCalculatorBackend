FROM java:8
EXPOSE 9090
ADD /target/loan-calculator-0.0.1-SNAPSHOT.jar loan-calculator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "loan-calculator-0.0.1-SNAPSHOT.jar"]

