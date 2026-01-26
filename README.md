Selenium + REST Assured Automation Tests

This repository contains automation tests for the SauceDemo website in Selenium (https://www.saucedemo.com/) and jsonplaceholder website in REST Assured (https://jsonplaceholder.typicode.com/), implemented as a demo of my testing skills. The project demonstrates the use of Java, Selenium WebDriver, TestNG, Maven, Allure Reports, REST Assured and Jenkins integrated with GitHub pushes via LocalTunnel.

Technology Stack

The tests are implemented using Java 17, Selenium WebDriver, REST Assured and TestNG. Maven is used for dependency management and build automation. Allure Reports are used to generate detailed test execution reports. Jenkins is configured to automatically run tests on each push to GitHub, using LocalTunnel.

Project Structure

The project is organized with User Interface tests in src/test/java/com.example.saucedemo.tests and API Tests in src/test/java/API/Tests/Tests. Of course Page Object Models are included in src/main/java/com.example.saucedemo.pages and Request DTO with Response DTO in src/test/java/API/Tests/Models. Each UI test class extends BaseTest (which contains setup and teardown methods for the WebDriver) and UserApiTest test class extends BaseApiTest (which contents baseURI and content type JSON). The pom.xml file contains Maven dependencies, including Selenium, REST Assured, TestNG, WebDriverManager and Allure. The TestNG suite configuration is defined in testng.xml. Allure is configured via the Maven plugin and TestNG listener, generating detailed reports for each test run.

CI with Jenkins

The Jenkins instance is configured to automatically trigger builds on GitHub pushes. LocalTunnel is used for that purpose. Each push to the repository triggers a Jenkins build and generates an Allure report with the results of all test executions.

Allure report from Jenkins:

<img width="903" height="820" alt="image" src="https://github.com/user-attachments/assets/a05d069c-2a26-4e98-91cc-850069140da9" />


