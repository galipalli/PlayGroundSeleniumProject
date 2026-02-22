# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java-based Selenium test automation framework using TestNG for testing an e-commerce site (LambdaTest E-commerce Playground). The framework implements the Page Object Model (POM) design pattern.

## Build and Run Commands

### Running Tests
- **Run all tests**: `mvn test` (uses root `testng.xml` by default)
- **Run specific test class**: `mvn test -Dtest=org.Test.test_doLogin`
- **Run with custom suite XML**: `mvn test -DsuiteXmlFile=src/test/resources/MultiBrowserRunner.xml`

### Building
- **Clean and compile**: `mvn clean compile`
- **Package without tests**: `mvn package -DskipTests`
- **Full build with tests**: `mvn clean install`

### Browser Selection
The browser is configured in `src/test/resources/Config.properties`:
```properties
browser = chrome  # Options: chrome, firefox, edge
testsiteurl1 = https://ecommerce-playground.lambdatest.io/
```

## Architecture

### Directory Structure
```
src/
├── main/java/
│   ├── Base/
│   │   └── BasePage.java          # Abstract base class for all Page Objects
│   └── org/PO/
│       ├── LoginPage.java         # Login page POM
│       ├── HomePage.java          # Home page POM
│       ├── HeaderBarNav.java      # Header navigation POM
│       ├── MyAccountPage.java     # My account page POM
│       └── RightSideBarNav.java   # Right sidebar POM
└── test/java/
    ├── Base/
    │   └── TestBase.java          # Test base class with setup/teardown
    ├── Listeners/
    │   └── Listeners.java         # TestNG listener for reporting
    ├── Utilities/
    │   ├── JsonDataReader.java    # JSON test data reader
    │   ├── ExcelUtilis.java       # Excel utilities (for data-driven tests)
    │   ├── TestUtil.java          # Test utilities (screenshots, etc.)
    │   └── ExtentManager.java     # ExtentReports configuration
    └── org/Test/
        └── test_*.java            # Test classes

src/test/resources/
├── Config.properties              # Framework configuration
├── OR.properties                  # Object Repository (legacy)
├── testData/
│   └── user.json                  # Test user credentials
└── testng.xml                     # TestNG suite configuration
```

### Page Object Model Pattern

**BasePage** (`Base.BasePage`): Abstract base class for all page objects
- Provides common WebDriverWait functionality
- Handles element visibility and clickability waits
- All Page Objects extend this class

**TestBase** (`Base.TestBase`): Base class for all test classes
- Initializes WebDriver using WebDriverManager
- Loads configuration from properties files
- Sets up ExtentReports and Log4j logging
- Provides `loginAsDefaultUser()` helper method

### Test Data Handling

Two approaches exist for test data:
1. **JSON** (current): Uses `JsonDataReader` with `src/test/resources/testData/user.json`
2. **OR.properties** (legacy): Contains hardcoded credentials (being phased out)

### Reporting and Logging

- **ExtentReports**: Generates HTML reports in `test-output/extent/`
- **Log4j**: Logs to `logs/Selenium.log`
- **Listeners**: `Listeners.Listeners` captures test events and generates reports with screenshots on failure

## Key Design Patterns

1. **Page Object Model**: All pages extend `BasePage` and return page objects for fluent navigation
2. **PageFactory**: Uses `@FindBy` annotations for element location
3. **Fluent Interface**: Page methods return other page objects (e.g., `LoginPage.doLoginSuccess()` returns `HomePage`)
4. **Explicit Waits**: All interactions use WebDriverWait via `BasePage` helpers

## Test Configuration

- Java version: 21
- Selenium: 4.25.0
- TestNG: 7.7.0
- WebDriverManager automatically handles driver binaries
- Headless mode can be enabled in `TestBase.java:80` (commented out by default)
