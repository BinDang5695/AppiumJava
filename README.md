# AppiumFramework

Appium TypeScript Automation Framework

## Appium Introduction

* Appium is an open-source framework for mobile application testing and automation. It enables automation of native, hybrid, and mobile web applications on Android and iOS platforms using a single API.
* Appium follows the WebDriver protocol, making it compatible with multiple programming languages and automation tools.
* It supports real devices, emulators, and simulators, allowing teams to build reliable mobile automation solutions.
* Cross-platform. Appium supports both Android and iOS applications with the same automation framework.
* Cross-device. Run tests on emulators, simulators, cloud device farms, or physical devices.
* Cross-language. Use Appium with TypeScript, JavaScript, Java, Python, C#, Ruby, and more.
* Appium is an open-source project maintained by the community and governed by the Appium Foundation.

[GitHub](https://github.com/appium/appium)
[Documentation](https://appium.io/docs/en/latest/)
[API reference](https://appium.io/docs/en/latest/reference/)
[Changelog](https://github.com/appium/appium/releases)

# Appium - Framework

This is a mobile automation framework using Appium written in Java.

## Framework Structure

```
├── .idea/                                                                                # IntelliJ IDEA project settings
├── exports/                                                                              # Output artifacts generated during execution
│   ├── logs                                                                              # Execution logs (Appium, framework logs)
│   ├── screenshots                                                                       # Captured screenshots on failure/success
│   └── videos                                                                            # Recorded test execution videos
├── report/                                                                               # Custom or generated HTML reports
├── src/                                              
│   ├── main/                                         
│   │   ├── java/                                       
│   │   │   ├── constants/                                                                # Constant values used across framework       
│   │   │   │   └── ConfigData                                                            # Centralized configuration data holder
│   │   │   ├── drivers/                                                                  # Driver initialization and management layer               
│   │   │   │   ├── AndroidDriverManager                                                  # Android driver setup and lifecycle
│   │   │   │   └── DriverManager                                                         # Generic driver abstraction layer
│   │   │   ├── helpers/                                                                  # Utility helper classes        
│   │   │   │   ├── CaptureHelpers                                                        # Screenshot and video capture utilities
│   │   │   │   ├── ExcelHelpers                                                          # Excel file reading/writing utilities
│   │   │   │   ├── JsonHelpers                                                           # JSON parsing utilities
│   │   │   │   ├── PropertiesHelpers                                                     # Properties file handling utilities
│   │   │   │   └── SystemHelpers                                                         # System-level helper utilities (OS, env, etc.)
│   │   │   ├── keywords/                                                                 # Reusable keyword actions (custom mobile actions)        
│   │   │   │   └── MobileUI                                                              # Mobile UI interaction keywords wrapper
│   │   │   ├── reports/                                                                  # Reporting integration layer      
│   │   │   │   └── AllureManager                                                         # Allure report helper/adapter
│   │   │   ├── utils/                                                                    # General utility classes        
│   │   │   │   ├── DateUtils                                                             # Date and time utilities
│   │   │   │   └── LogUtils                                                              # Logging utilities wrapper
│   │   └── resources/                                                                    # Main resources used by framework
│   │   │   ├── META-INF.services/                                                        # Service loader configuration     
│   │   │   │   └── io.qameta.allure.listener.TestLifecycleListener                       # Allure lifecycle listener registration
│   │   │   ├── log4j2.properties                                                         # Log4j2 configuration       
│   │   │   └── log4j2_OFF.xml                                                            # Disabled logging configuration        
│   ├── test/                                         
│   │   ├── java/                                       
│   │   │   ├── common/                                                                   # Base test setup and shared test configuration
│   │   │   │   ├── BaseTestAndroidPlatform                                               # Base setup for Android test execution
│   │   │   │   ├── BaseTestFlutterPlatform                                               # Base setup for Flutter application testing
│   │   │   │   └── BaseTestSauceLabs                                                     # Base setup for Sauce Labs App testing
│   │   │   ├── dataproviders/                                                            # TestNG DataProviders for data-driven testing
│   │   │   │   ├── CheckoutDataProvider                                                  # Data provider for checkout scenarios
│   │   │   │   └── LoginDataProvider                                                     # Data provider for login scenarios
│   │   │   ├── listeners/                                                                # TestNG listeners for hooks and reporting
│   │   │   │   └── TestListener                                                          # Custom listener for test events
│   │   │   ├── model/                                                                    # POJO models for test data mapping
│   │   │   │   ├── Login                                                                 # Login data model
│   │   │   │   └── Payment                                                               # Payment data model
│   │   │   ├── pages/                                                                    # Page Object Model (POM) layer
│   │   │   │   ├── SauceLabsApp                                                          # POM for Sauce Labs application
│   │   │   │   │   ├── BasePage                                                          # Common base page actions
│   │   │   │   │   ├── CheckoutPage                                                      # Checkout screen actions
│   │   │   │   │   ├── DrawingPage                                                       # Drawing feature screen actions
│   │   │   │   │   ├── LoginPage                                                         # Login screen actions
│   │   │   │   │   ├── MyCartPage                                                        # Cart screen actions       
│   │   │   │   │   ├── ProductsDetailsPage                                               # Product detail screen actions
│   │   │   │   │   ├── ProductsPage                                                      # Products screen actions
│   │   │   │   │   ├── WebViewPage                                                       # WebView screen actions
│   │   │   │   └── TaurusApp                                                             # POM for Taurus application 
│   │   │   │   │   ├── BasePage                                                          # Common base page actions
│   │   │   │   │   ├── ConfigPage                                                        # Configuration screen actions
│   │   │   │   │   ├── DatePage                                                          # Date selection screen actions
│   │   │   │   │   ├── LoginPage                                                         # Login screen actions
│   │   │   │   │   ├── MenuPage                                                          # Menu navigation actions
│   │   │   │   │   ├── OrderPage                                                         # Order management actions
│   │   │   │   │   ├── ProductPage                                                       # Product management actions
│   │   │   │   │   ├── ProfilePage                                                       # Profile screen actions
│   │   │   │   │   ├── ServerPage                                                        # Server configuration actions
│   │   │   │   │   └── TablePage                                                         # Table UI actions
│   │   │   ├── testcases/                                                                # Test case implementations
│   │   │   │   ├── SauceLabsApp                                                          # Test suite for Sauce Labs app
│   │   │   │   │   ├── Actions                                                           # General action-based test scenarios
│   │   │   │   │   ├── Login                                                             # Login test scenarios
│   │   │   │   │   ├── Notification                                                      # Notification test scenarios
│   │   │   │   │   └── Payment                                                           # Payment test scenarios
│   │   │   │   └── TaurusApp                                                             # Test suite for Taurus app
│   │   │   │   │   ├── BaseTest                                                          # Base test class
│   │   │   │   │   ├── DateTest                                                          # Date feature tests
│   │   │   │   │   ├── LoginTest                                                         # Login feature tests
│   │   │   │   │   ├── MenuTest                                                          # Menu feature tests
│   │   │   │   │   ├── OrderTest                                                         # Order feature tests
│   │   │   │   │   ├── ProductTest                                                       # Product feature tests
│   │   │   │   │   └── ProfileTest                                                       # Profile feature tests
│   │   └── resources/                                                                    
│   │   │   ├── configs/                                                                  
│   │   │   │   ├── config.properties                                                     # Environment configuration properties
│   │   │   │   └── device.json                                                           # Device capabilities configuration
│   │   │   ├── suites/                                                                   # TestNG suite XML files
│   │   │   │   ├── SuiteRegressionTest.xml                                               # Regression suite (single platform)
│   │   │   │   └── SuiteRegressionTest_Multi_Platform.xml                                # Multi-platform execution suite
│   │   │   └── test_data/                                                                # Test data files for data-driven testing
│   │   │   │   ├── checkoutData.json                                                     # Checkout test data
│   │   │   │   ├── data.json                                                             # Generic test data (JSON)
│   │   │   │   ├── data.properties                                                       # Properties-based test data
│   │   │   │   ├── data.xlsx                                                             # Excel-based test data
│   │   │   │   ├── loginData.xml                                                         # XML-based login test data
│   │   │   │   └── sample_products.json                                                  # Product sample data
└── target/                                                                               # Maven build output directory
│   ├── allure-report/                                                                    # Generated Allure HTML report
│   ├── allure-results/                                                                   # Raw Allure results
├─ .gitignore                                                                             # Git ignore rules
├─ pom.xml                                                                                # Maven project configuration
└─ README.md                                                                              # Project documentation & setup guide
```

## Requirements

```text
- IntelliJ IDEA
- Java JDK 17 or above
- Maven 3.8+
- Android Studio (Android SDK)
- Appium Server 2.x
- Android Emulator
- Appium Inspector
```

# Getting Started

```text
This is the quick and easy getting started assuming you already have Git, IntelliJ IDEA, Java JDK, Maven, Android Studio and Appium installed.
```

## Open project in IntelliJ IDEA

```text
- Launch IntelliJ IDEA
- File -> Open
- Select project root folder
- Wait until Maven downloads all project dependencies
```

## Install the required items

### 1. Install all required Maven dependencies defined in pom.xml

Open the Terminal window in IntelliJ IDEA and execute:

```sh
mvn clean install
```

Or open Command Prompt in the project root folder and execute:

```sh
mvn clean install
```

### 2. Start Appium Server

Open Terminal or Command Prompt and execute:

```sh
appium
```

By default, Appium Server starts at:

```text
http://127.0.0.1:4723
```

### 3. Verify Android Device

Open Terminal and execute:

```sh
adb devices
```

Example output:

```text
List of devices attached
emulator-5554    device
```

If no device is displayed, start an Android Emulator or connect a real Android device with USB Debugging enabled.

---

# Run Tests

## Run tests by IntelliJ IDEA

1. Open the desired TestNG test class or test suite.
2. Right-click the class or `SuiteRegressionTest.xml`.
3. Select **Run**.
4. IntelliJ IDEA will execute the test and display the execution results in the Run window.

You can also run a single test method by clicking the green Run icon next to the method.

---

## Run all test suites

```sh
mvn clean test
```

---

## Run each test suites

```sh
mvn clean test "-Dtest=testcases.SauceLabsApp.Login"
```

Please refer to the `testng.xml` files for more details.

---

## Run tests in parallel

We can run test cases in parallel in two ways.

### Option #1

Modify the `parallel` and `thread-count` attributes in the `testng.xml` file.

Example:

```xml
<suite name="SauceLabs My Demo App mutiple platform"
       parallel="tests"
       thread-count="2">
```

This option affects all test suites.

### Option #2

Configure the Maven Surefire Plugin inside `pom.xml`.

Example:

```xml
<parallel>methods</parallel>
<threadCount>4</threadCount>
```

This only affects executions through Maven.

For more details, please refer to the TestNG documentation.

---

# Generate Report

After test execution completes, TestNG reports are automatically generated.

The HTML report is generated in:

```text
target/allure-reports/
```

If the project integrates Allure Report:

Generate report

```sh
allure generate target/allure-results -o target/allure-report --clean
```

Open report

```sh
allure open target/allure-report
```

---

# Run Code Quality Check

Execute the following command:

```sh
mvn checkstyle:check
```

or

```sh
mvn spotless:check
```

depending on your project configuration.

---

# How to configure and run tests on different environments or devices

Appium allows different devices and environments to be configured through configuration files.

Example configuration:

```properties
environment=DEV
platformName=Android
deviceName=Pixel_8
platformVersion=15
```

You can also configure:

* Base URL
* Device Name
* Platform Version
* App Package
* App Activity
* Automation Name
* UDID (for real devices)

Then execute tests for different environments:

Development

```sh
mvn test -Denvironment=DEV
```

Testing

```sh
mvn test -Denvironment=TEST
```

UAT

```sh
mvn test -Denvironment=UAT
```

Production

```sh
mvn test -Denvironment=PROD
```

Similarly, different devices can be configured and selected using Maven parameters or configuration files.

---

Instead of using npm commands, we can use Maven commands to run different TestNG suites for Appium automation.

For example, if we want to run all regression tests on a single Android environment, we can use:
```sh
mvn clean test "-DsuiteXmlFile=src/test/resources/suites/SuiteRegressionTest.xml"
```
If we want to run tests across multiple platforms, we can use:
```sh
mvn clean test "-DsuiteXmlFile=src/test/resources/suites/SuiteRegressionTest_Multi_Platform.xml"
```
