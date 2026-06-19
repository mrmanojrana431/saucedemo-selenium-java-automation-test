# SauceDemo Selenium Java Automation Test

A professional Selenium Java-based test automation framework built for [SauceDemo](https://www.saucedemo.com) to showcase UI automation, Page Object Model (POM) architecture, TestNG integration, and scalable test design practices.

## Table of Contents
- [About the Project](#about-the-project)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Test Cases](#test-cases)
- [Technologies & Dependencies](#technologies--dependencies)
- [Contributing](#contributing)
- [License](#license)

## About the Project

This project demonstrates a robust and maintainable test automation framework using Selenium WebDriver with Java. It's designed to automate the SauceDemo e-commerce website and showcases industry best practices for writing scalable, maintainable, and reusable test automation code.

### Key Objectives:
- Implement the **Page Object Model (POM)** pattern for better code organization
- Create reusable and modular test cases
- Demonstrate proper use of TestNG for test management
- Show proper project structure and Maven configuration
- Provide a foundation for continuous testing and integration

## Features

✅ **Page Object Model Architecture** - Separation of test logic from page elements  
✅ **Selenium WebDriver 4** - Latest Selenium with improved API  
✅ **TestNG Framework** - Comprehensive testing framework with flexible test configuration  
✅ **WebDriverManager** - Automatic driver management without manual setup  
✅ **Maven Build Management** - Easy dependency management and build automation  
✅ **Organized Test Structure** - Clear separation of test cases, pages, and helpers  
✅ **Test Reports** - Automated test reporting with Surefire plugin  
✅ **Java 21** - Modern Java language features  

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 21 or higher**
  - [Download Java](https://www.oracle.com/java/technologies/downloads/)
  - Verify installation: `java -version`

- **Apache Maven 3.8.0 or higher**
  - [Download Maven](https://maven.apache.org/download.cgi)
  - Verify installation: `mvn -version`

- **Git** (optional, for cloning the repository)
  - [Download Git](https://git-scm.com/downloads)

- **IDE** (recommended)
  - IntelliJ IDEA, Eclipse, or VS Code with Java extensions

## Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/saucedemo-selenium-java-automation-test.git
cd saucedemo-selenium-java-automation-test
```

Or if you already have the project, navigate to the project directory:

```bash
cd D:\git\saucedemo-selenium-java-automation-test
```

### Step 2: Set Up Environment Variables

Ensure your `JAVA_HOME` is set correctly:

**Windows:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
```

**Mac/Linux:**
```bash
export JAVA_HOME="/usr/libexec/java_home -v 21"
```

### Step 3: Install Dependencies

Run the following Maven command to download and install all dependencies:

```bash
mvn clean install
```

This will:
- Clean any previous builds
- Download all required dependencies (Selenium, TestNG, WebDriverManager)
- Compile the test code
- Prepare the project for test execution

### Step 4: Verify IDE Setup (Optional)

If using **IntelliJ IDEA**:
1. Open the project folder as a Maven project
2. Go to `File > Project Structure`
3. Ensure **Project SDK** is set to JDK 21
4. Ensure **Project Language Level** is set to 21

## Project Structure

```
saucedemo-selenium-java-automation-test/
├── pom.xml                          # Maven configuration file
├── testng.xml                       # TestNG configuration
├── README.md                        # This file
└── src/
    └── test/
        └── java/
            └── web/
                ├── helper/
                │   └── LaunchHelper.java          # Helper methods for browser launch
                ├── pages/
                │   ├── HomePage.java              # HomePage POM class
                │   ├── LaunchAndLoginPage.java    # Login page POM class
                │   └── ProductDetailsPage.java    # Product details page POM class
                └── testcases/
                    ├── HomePageTestCases.java     # Home page test cases
                    ├── LaunchPageTestCases.java   # Launch/Login page test cases
                    └── LoginTestCases.java        # Login test cases
```

### Directory Descriptions:

- **`helper/`** - Contains utility classes and reusable methods for test setup and teardown
- **`pages/`** - Contains Page Object Model classes for each page in the application
- **`testcases/`** - Contains actual test classes with test methods

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Suite (TestNG)

```bash
mvn clean test -Dtest=LoginTestCases
```

### Run Tests in Parallel

```bash
mvn clean test -Dparallel=methods -DthreadCount=4
```

### Generate Test Report

After running tests, view the HTML report:

```bash
# On Windows
start target\surefire-reports\index.html

# On Mac/Linux
open target/surefire-reports/index.html
```

Test reports are automatically generated in `target/surefire-reports/`

## Test Cases

### Current Test Coverage:

1. **LoginTestCases.java**
   - User login with valid credentials
   - User login with invalid credentials
   - Login page validation

2. **HomePageTestCases.java**
   - Shopping cart functionality
   - Product filtering
   - Product sorting

3. **LaunchPageTestCases.java**
   - Page load validation
   - UI elements visibility
   - Initial page state verification

## Technologies & Dependencies

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.15.0 | Web browser automation |
| **TestNG** | 7.9.0 | Test framework and assertions |
| **WebDriverManager** | 5.7.0 | Automatic WebDriver management |
| **Java** | 21 | Programming language |
| **Maven** | 3.8+ | Build and dependency management |
| **Surefire Plugin** | 3.0.0 | Test execution and reporting |

### Maven Dependencies in pom.xml:

```xml
<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.15.0</version>
</dependency>

<!-- WebDriverManager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.7.0</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>
```

## Quick Start Guide

1. **Clone or navigate to project:**
   ```bash
   cd D:\git\saucedemo-selenium-java-automation-test
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Run all tests:**
   ```bash
   mvn clean test
   ```

4. **View test results:**
   ```bash
   start target\surefire-reports\index.html
   ```

## Troubleshooting

### Common Issues:

**Problem:** `Java version not found`  
**Solution:** Verify Java is installed and added to PATH: `java -version`

**Problem:** `Maven not recognized`  
**Solution:** Verify Maven is installed and added to PATH: `mvn -version`

**Problem:** Dependency download fails  
**Solution:** Check internet connection and run: `mvn clean install -U`

**Problem:** Tests fail with driver issues  
**Solution:** WebDriverManager should handle drivers automatically. Clear cache: `rm -rf ~/.wdm` (Mac/Linux) or `rmdir /s %USERPROFILE%\.wdm` (Windows)

## Best Practices Implemented

- ✅ **Page Object Model** - Each page has a dedicated class
- ✅ **DRY Principle** - Reusable methods in helper classes
- ✅ **Clear Naming** - Descriptive class and method names
- ✅ **Proper Organization** - Logical folder structure
- ✅ **Scalability** - Easy to add new test cases and pages
- ✅ **Maintainability** - Changes to UI are isolated to page classes

## Contributing

Contributions are welcome! Feel free to:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the MIT License. See LICENSE file for details.

## Support

For issues, questions, or suggestions, please create an issue on the GitHub repository.

---

**Happy Testing! 🚀**
