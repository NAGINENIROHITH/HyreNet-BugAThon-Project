# HyreNet BugAThon - Selenium Automation Framework 🚀

## Project Overview
This is a professional-grade automated testing framework designed for the HyreNet platform. It covers the end-to-end flow from Authentication to Question Management, Template Creation, and automated Test (Drive) setups. The project is built following the **Page Object Model (POM)** and uses a decoupled **Locators Strategy** for maximum maintainability.

## Technology Stack
- **Language**: Java 11+
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Reporting**: ExtentReports (with Screenshots)
- **CI/CD**: Jenkins Integration (via Jenkinsfile)
- **Version Control**: Git/GitHub

## Project Structure
```text
HyreNet-BugAThon/
├── src/test/java/
│   ├── locators/           # Decoupled Element Locators (XPaths/IDs)
│   │   ├── LoginLocators.java
│   │   ├── DashboardLocators.java
│   │   ├── QuestionsLocators.java
│   │   ├── TemplatesLocators.java
│   │   └── TestsLocators.java
│   ├── pages/              # Page Object Classes (Business Logic)
│   │   ├── BasePage.java
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── QuestionsPage.java
│   │   ├── TemplatesPage.java
│   │   └── TestsPage.java
│   ├── tests/              # Functional Test Scripts
│   │   ├── BaseTest.java
│   │   └── PlaceOrderTest.java  # Main End-to-End Flow
│   ├── listeners/          # TestNG Listeners (ScreenCapture on Failure)
│   │   └── TestListener.java
│   └── utils/              # Utility Classes
│       ├── ConfigReader.java
│       ├── DriverManager.java
│       ├── ScreenshotUtil.java
│       └── WaitHelper.java
├── src/test/resources/
│   ├── config.properties   # Environment & Browser Settings
│   └── testng.xml          # Test Suite Configuration
├── reports/                # Generated ExtentReports
├── test-output/            # Default TestNG & Screenshots output
├── Jenkinsfile             # CI/CD Pipeline Configuration
├── pom.xml                 # Maven Dependencies
└── README.md
```

## Setup & Execution

### 1. Prerequisites
- Java JDK 11 or higher
- Maven 3.6+
- Chrome Browser installed

### 2. Basic Configuration
Update `src/test/resources/config.properties` if you need to change the environment:
```properties
app.url=https://app.hyrenet.in/
app.email=hyrenet+bugathon@guvi.in
app.password=hyrenettest@123
browser=chrome
headless=false
```

### 3. Running from Terminal
Run the complete end-to-end automation flow:
```bash
mvn clean test -Dtest=PlaceOrderTest
```

## Key Automation Features
1.  **Unified Navigation**: Uses direct URL navigation for Library and Templates to bypass flaky sidebar components.
2.  **Question Library**: Automated MCQ creation with support for **Selectized.js** dropdowns (Score, Difficulty, Category, Tags).
3.  **Template Engine**: Implements the "Auto-Configure" multi-step flow for rapid template generation.
4.  **Test Drive Setup**: Fully automates the creation of a "Drive" with custom date range selecton and job descriptions.
5.  **Smart Logout**: Navigates to the Settings module to ensure a clean session termination via the verified logout ID.

## Reporting & Screenshots
- **ExtentReports**: Interactive HTML reports are generated in the `reports/` folder.
- **Failures**: The framework automatically captures a full-page screenshot whenever a test step fails and attaches it directly to the HTML report.

## Jenkins Integration
The project includes a `Jenkinsfile` for easy CI/CD setup. 
- **Notifications**: Configured to send success/failure emails to `rohithnagineni.863@gmail.com`.
- **Artifacts**: Automatically archives test outputs and HTML reports.

## GitHub Repository
[https://github.com/NAGINENIROHITH/HyreNet-BugAThon-Project.git](https://github.com/NAGINENIROHITH/HyreNet-BugAThon-Project.git)

---
Developed for the HyreNet BugAThon Challenge.
