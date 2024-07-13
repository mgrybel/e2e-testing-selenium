# E2E Testing using Selenium WebDriver

Automated end-to-end tests of an e-commerce application built using **Selenium WebDriver** with **Java**.

## Prerequisites

Install the following prerequisites:

1. [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
2. [Node.js](https://nodejs.org/en/)
3. [PostgreSQL](https://www.postgresql.org/download/)
4. [Visual Studio Code](https://code.visualstudio.com/download)

## System Under Test (SUT)

The system under test (SUT) is this [e-commerce application](https://github.com/mgrybel/ecommerce-website) built using **Spring Boot 3** and **React 18**, which uses a **PostgreSQL** database to store data.

To run tests in this project, you must first install and run the SUT. Follow [these steps](https://github.com/mgrybel/ecommerce-website/blob/master/README.md).

## Download the project

1. Clone this repository or download the ZIP file and unzip the project.
2. Open the project in Visual Studio Code.

## Installation

From the **root** directory, run:

```bash
mvn compile
```

## Run tests

From the **root** directory, run:

```bash
mvn test
```

## Generate the Allure report

From the **root** directory, run:

```bash
mvn allure:serve
```
