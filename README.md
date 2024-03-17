# Ben Rozen - QA Automation Home Assignment - Vicarius.io


## Prerequisites :
1.  Java 21 https://www.oracle.com/il-en/java/technologies/downloads/
2.  Docker engine installed and running https://www.docker.com/products/docker-desktop/

## Steps to start :
1. Clone repo
2. Add .env file with variables for "VALID_COMPANY_EMAIL" , "COMPANY_PASSWORD", "PERSONAL_EMAIL"

3.  Run tests: 
 - from terminal `mvn clean test -DenvFile={path-to-the-env-file}` 
 - from IDE (Intellij) -> install `EnvFile` plugin and add env file in base Run/Debug configuration
   https://plugins.jetbrains.com/plugin/7861-envfile

## :warning: Webdriver location
By default the script checks if the environment is of Jenkins/ Semaphore if true- the webdriver will be created in a docker.
It can be ovveridden by `isCI` field in `WebDriverFactory.java`

## Scope:
This test plan covers the following aspects:

1.  Sign In flows
2.  Sign Up flows
3.  Product Page flows

https://docs.google.com/spreadsheets/d/1yjGL6oZ7acmq4i2GxD0OpkFyLXjEibo-DBFaSKnckHU/edit#gid=0

