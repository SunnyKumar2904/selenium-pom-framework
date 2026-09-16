# Selenium Page Object Model Framework (Java + TestNG + Maven)

A Page Object Model (POM) test automation framework for the login and logout flow of
[Practice Test Automation](https://practicetestautomation.com/practice-test-login/), built during
my Manual + Automation Testing (Selenium with Java) training.

> **Author:** Sunny Kumar - QA Tester (Manual + Automation)
> [LinkedIn](https://www.linkedin.com/in/sunny-kumar-9ba6002a2) · [GitHub](https://github.com/SunnyKumar2904)

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java |
| Automation tool | Selenium WebDriver 4 |
| Test framework | TestNG |
| Design pattern | Page Object Model |
| Build tool | Maven |
| Reporting | Extent Reports (Spark) with TestNG listener |
| Browsers | Chrome, Edge, Firefox |

## Project Structure

```
configuration/config.properties      URL and browser used for the run
src/test/java/com/crmapplication/
├── pageobject/   Login.java, Logout.java      locators + page actions
├── testcase/     Base.java, TestCase.java     browser setup, screenshot, tests
└── utilities/    ReadConfiguration.java       reads config.properties (Properties class)
                  ExtentReportWithListeners.java  ITestListener -> Extent Spark report
testng.xml                             suite file with the listener registered
```

## Features

- **Page Object Model** - each page keeps its `By` locators and action methods; tests only call page methods.
- **Config-driven execution** - `url` and `browser` are read from `config.properties`; `Base` launches Chrome, Edge or Firefox with a `switch`.
- **Ordered tests** - `@Test(priority = n)` runs login before logout.
- **Extent Spark report** - an `ITestListener` logs PASS / FAIL / SKIP with colour labels, environment info and a dark theme.
- **Screenshot on failure** - `TakesScreenshot` captures the page and attaches it to the failed test in the report.

## How to Run

```bash
git clone https://github.com/SunnyKumar2904/selenium-pom-framework.git
cd selenium-pom-framework
mvn clean test
```

Or in Eclipse: right-click `testng.xml` -> **Run As -> TestNG Suite**. Change `browser=chrome` to `edge`
or `firefox` in `configuration/config.properties` to switch browsers. The report is written to
`report123.html` in the project folder.

*Portfolio project. Tests run against a public practice website intended for automation practice.*
