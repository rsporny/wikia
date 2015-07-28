# wikia

## desc
Example use of PageObject pattern.

This code was written for wikia recruitment purposes. **PLEASE** do not copy - it has a lot of disadvantages (see TODOs).

## how to run
mvn test [-Dbrowser]
- **browser** firefox by default, chrome

## requirements
- JDK 1.7
- Maven 3.2.1
- Firefox 39 or Chrome 44 (with chromedriver 2.16)
- path configured

## TODOs
This is a list of potential TODOs. Some of them may significantly reduce the maintenance costs. None of them was done because they are not within the scope of this task.

- page objects are binded with selenium -> changing driver will be a pain -> separate driver, web element and locator layers from page object layer
- simplify test logic layer -> right now is hard to read -> gherkin-like DSL or something more controlable
- divide properties to config (timeouts, etc.) and test data (credentials, etc.)
- encrypt test data credentials
- introduce parallelization and test suites - not sure what TestNG provides and how good it is
- introduce timeouts on web elements (with parametrization on test logic layer)
- introduce logging and screenshot saving
- improve TestNG logging results
- introduce keyword-like executing of tests
- connect with test management tool (getting tests that needs to be run, saving results)
- much more...