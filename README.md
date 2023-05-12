# Test Automation Framework

This is a template for a test automation framework using the following tech stack:
- Java
- Selenium 4
- TestNG
- Cucumber
- Allure



## Run Locally

Clone the project

```bash
  git clone git@github.com:davidcarguz/seleniumTemplate.git
```

Install dependencies

```bash
  gradle install
```

Run the tests

```bash
  gradle test
```


## Allure Report
The framework uses Allure to generate the report. It is necessary to install the Allure server locally.
- the following link explains the instalation process in different systems: [Allure Installation](https://docs.qameta.io/allure/#_installing_a_commandline)

After running the tests open a terminal window in the project path and run the wollogin command:
```bash
allure serve allure-results
```
this will open a browser window with the execution report.
