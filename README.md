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
├── .idea/                                                                                # 
├── exports/                                                                              # 
│   ├── logs                                                                              #
│   ├── screenshots                                                                       #
│   └── videos                                                                            #
├── report/                                                                               #
├── src/                                              
│   ├── main/                                         
│   │   ├── java/                                       
│   │   │   ├── constants/                                                                #        
│   │   │   │   └── ConfigData                                                            # 
│   │   │   ├── drivers/                                                                  #        
│   │   │   │   ├── AndroidDriverManager                                                  #
│   │   │   │   └── DriverManager                                                         # 
│   │   │   ├── helpers/                                                                  #        
│   │   │   │   ├── CaptureHelpers                                                        #
│   │   │   │   ├── ExcelHelpers                                                          #
│   │   │   │   ├── JsonHelpers                                                           #
│   │   │   │   ├── PropertiesHelpers                                                     #
│   │   │   │   └── SystemHelpers                                                         #
│   │   │   ├── keywords/                                                                 #        
│   │   │   │   └── MobileUI                                                              #
│   │   │   ├── reports/                                                                  #        
│   │   │   │   └── AllureManager                                                         #
│   │   │   ├── utils/                                                                    #        
│   │   │   │   ├── DateUtils                                                             #
│   │   │   │   └── LogUtils                                                              #
│   │   └── resources/                                                                    #
│   │   │   ├── META-INF.services/                                                        #        
│   │   │   │   └── io.qameta.allure.listener.TestLifecycleListener                       # 
│   │   │   ├── log4j2.properties                                                         #        
│   │   │   └── log4j2_OFF.xml                                                            #        
│   ├── test/                                         
│   │   ├── java/                                       
│   │   │   ├── common/                                                                   #
│   │   │   │   ├── BaseTestAndroidPlatform                                               # 
│   │   │   │   ├── BaseTestFlutterPlatform                                               # 
│   │   │   │   └── BaseTestSauceLabs                                                     # 
│   │   │   ├── dataproviders/                                                            #
│   │   │   │   ├── CheckoutDataProvider                                                  # 
│   │   │   │   └── LoginDataProvider                                                     # 
│   │   │   ├── listeners/                                                                #
│   │   │   │   └── TestListener                                                          # 
│   │   │   ├── model/                                                                    #
│   │   │   │   ├── Login                                                                 # 
│   │   │   │   └── Payment                                                               # 
│   │   │   ├── pages/                                                                    #
│   │   │   │   ├── SauceLabsApp                                                          #
│   │   │   │   │   ├── BasePage                                                          #
│   │   │   │   │   ├── CheckoutPage                                                      #
│   │   │   │   │   ├── DrawingPage                                                       #
│   │   │   │   │   ├── LoginPage                                                         #
│   │   │   │   │   ├── MyCartPage                                                        #
│   │   │   │   │   ├── ProductsDetailsPage                                               #
│   │   │   │   │   ├── ProductsPage                                                      #
│   │   │   │   │   ├── WebViewPage                                                       #
│   │   │   │   └── TaurusApp                                                             # 
│   │   │   │   │   ├── BasePage                                                          #
│   │   │   │   │   ├── ConfigPage                                                        #
│   │   │   │   │   ├── DatePage                                                          #
│   │   │   │   │   ├── LoginPage                                                         #
│   │   │   │   │   ├── MenuPage                                                          #
│   │   │   │   │   ├── OrderPage                                                         #
│   │   │   │   │   ├── ProductPage                                                       #
│   │   │   │   │   ├── ProfilePage                                                       #
│   │   │   │   │   ├── ServerPage                                                        #
│   │   │   │   │   └── TablePage                                                         #
│   │   │   ├── testcases/                                                                #
│   │   │   │   ├── SauceLabsApp                                                          #
│   │   │   │   │   ├── Actions                                                           #
│   │   │   │   │   ├── Login                                                             #
│   │   │   │   │   ├── Notification                                                      #
│   │   │   │   │   └── Payment                                                           #
│   │   │   │   └── TaurusApp                                                             #
│   │   │   │   │   ├── BaseTest                                                          #
│   │   │   │   │   ├── DateTest                                                          #
│   │   │   │   │   ├── LoginTest                                                         #
│   │   │   │   │   ├── MenuTest                                                          #
│   │   │   │   │   ├── OrderTest                                                         #
│   │   │   │   │   ├── ProductTest                                                       #
│   │   │   │   │   └── ProfileTest                                                       #
│   │   └── resources/                                                                    
│   │   │   ├── configs/                                                                  
│   │   │   │   ├── config.properties                                                     #
│   │   │   │   └── device.json                                                           #
│   │   │   ├── suites/                                                                   #
│   │   │   │   ├── SuiteRegressionTest.xml                                               #
│   │   │   │   └── SuiteRegressionTest_Multi_Platform.xml                                #
│   │   │   └── test_data/                                                                #
│   │   │   │   ├── checkoutData.json                                                     #
│   │   │   │   ├── data.json                                                             #
│   │   │   │   ├── data.properties                                                       #
│   │   │   │   ├── data.xlsx                                                             #
│   │   │   │   ├── loginData.xml                                                         #
│   │   │   │   └── sample_products.json                                                  #
└── target/                                                                               
│   ├── allure-report/                                                                    #
│   ├── allure-results/                                                                   #
├─ .gitignore                                                                             #
├─ pom.xml                                                                                #
└─ README.md                                                                              # Starting guideline
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

Finally, we can use npm run command to specify the enviroment that we want to run. For example, if we want to run all tests UI and API on Chromium we can use below command:
```sh
npm run test:all:chrome:admin
npm run test:all:edge:admin
