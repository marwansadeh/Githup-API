# Githup-API
This project can be run using:

1- mvn clean install, and you can select wich tag you wont to run using -Dcucumber.options="--tags '@tag'"
  mvn clean install -Dcucumber.options="--tags '@GithubAPI'"
  for regrission test use @RegressionTest tag, and for smoke test use @SmokeTest

2- run the testng method from src/test/java/runner/RunCukesTest.java
