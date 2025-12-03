SauceDemo Automation Tests

This repository contains automation tests for the SauceDemo website (https://www.saucedemo.com/), implemented as a demo of my testing skills. The project demonstrates the use of Java, Selenium WebDriver, TestNG, Maven, Allure Reports, and Jenkins integrated with GitHub pushes via LocalTunnel.

Technology Stack

The tests are implemented using Java 17, Selenium WebDriver, and TestNG. Maven is used for dependency management and build automation. Allure Reports are used to generate detailed test execution reports. Jenkins is configured to automatically run tests on each push to GitHub, using LocalTunnel.

Project Structure

The project is organized with tests in src/test/java/com.example.saucedemo.tests. Of course Page Object Models are included in src/main/java/com.example.saucedemo.pages. Each test class extends BaseTest, which contains setup and teardown methods for the WebDriver. The pom.xml file contains Maven dependencies, including Selenium, TestNG, WebDriverManager and Allure. The TestNG suite configuration is defined in testng.xml. Allure is configured via the Maven plugin and TestNG listener, generating detailed reports for each test run.

CI with Jenkins

The Jenkins instance is configured to automatically trigger builds on GitHub pushes. LocalTunnel is used for that purpose. Each push to the repository triggers a Jenkins build and generates an Allure report with the results of all test executions.

Allure report from Jenkins:

<img width="909" height="610" alt="image" src="https://github.com/user-attachments/assets/4acc3349-bc76-4b1d-8122-402fb1496aa2" />

