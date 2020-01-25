[![Build Status](https://travis-ci.org/klebercsilva/java-cucumberjvm-testng-selenium-example.svg?branch=master)](https://travis-ci.org/klebercsilva/java-cucumberjvm-testng-selenium-example)
<br />
## java-cucumberjvm-testng-selenium-example

This sample demonstrates how to implement a test automation project using Java and a few third-party libraries. [CucumberJVM](https://cucumber.io/docs/reference/jvm) is used to interpret the desired behaviour described by the user using the [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) language which follows the BDD (Behaviour Driven Development) specification. In order to execute the actions in the browser, the project makes use of [Selenium](https://www.seleniumhq.org/) WebDriver and the [XPath](https://www.w3.org/TR/xpath20/) language to locate and fill in data contained in the `.feature` file. It also uses the [TestNG](http://testng.org/doc/) engine to integrate and execute each scenario as a separated test. The final result is a `test-results` folder containg a report of the features that executed sucessfully and the ones that failed and the reason why they failed.

### Get the code

Git:

    git clone https://github.com/klebercsilva/java-cucumberjvm-testng-selenium-example
    cd java-cucumberjvm-testng-selenium-example

### Run with Maven

Open a command window and run:

    mvn test
