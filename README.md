# HyreNet BugAThon - Selenium Automation Framework

## Project Overview
Automated testing framework for HyreNet platform bug identification using Selenium WebDriver with Java, TestNG, and Page Object Model design pattern.

## Technology Stack
- **Language**: Java 11+
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Design Pattern**: Page Object Model (POM)
- **Reporting**: ExtentReports
- **CI/CD**: Jenkins Integration
- **Version Control**: Git/GitHub

## Project Structure
```
HyreNet-BugAThon/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── BasePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── DashboardPage.java
│   │       │   ├── QuestionsPage.java
│   │       │   ├── TemplatesPage.java
│   │       │   ├── TestsPage.java
│   │       │   └── SchedulingPage.java
│   │       ├── utils/
│   │       │   ├── ConfigReader.java
│   │       │   ├── DriverManager.java
│   │       │   ├── WaitHelper.java
│   │       │   ├── ScreenshotUtil.java
│   │       │   └── ExtentReportManager.java
│   │       └── constants/
│   │           └── Constants.java
│   └── test/
│       └── java/
│           ├── tests/
│           │   ├── BaseTest.java
│           │   ├── LoginTests.java
│           │   ├── QuestionTests.java
│           │   ├── TemplateTests.java
│           │   ├── TestCreationTests.java
│           │   └── SchedulingTests.java
│           └── listeners/
│               └── TestListener.java
├── src/test/resources/
│   ├── config.properties
│   ├── testdata/
│   │   └── testdata.xlsx
│   └── testng.xml
├── test-output/
│   ├── screenshots/
│   ├── videos/
│   └── extent-reports/
├── pom.xml
├── Jenkinsfile
└── README.md
```

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser
- Git

## Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/yourusername/HyreNet-BugAThon.git
cd HyreNet-BugAThon
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Test Settings
Edit `src/test/resources/config.properties`:
```properties
# Application URL
app.url=https://app.hyrenet.in/
app.email=hyrenet+bugathon@guvi.in
app.password=hyrenettest@123

# Browser Configuration
browser=chrome
headless=false
implicit.wait=10
explicit.wait=20
page.load.timeout=30

# Screenshot Settings
screenshot.on.failure=true
screenshot.on.pass=false

# Reporting
extent.report.path=test-output/extent-reports/
extent.report.name=HyreNet-BugReport.html
```

### 4. Run Tests

#### Run All Tests
```bash
mvn clean test
```

#### Run Specific Test Suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

#### Run Specific Test Class
```bash
mvn clean test -Dtest=LoginTests
```

#### Run with Different Browser
```bash
mvn clean test -Dbrowser=firefox
```

#### Run in Headless Mode
```bash
mvn clean test -Dheadless=true
```

## Test Execution Approach

### Test Coverage Areas
1. **Login & Authentication**
   - Valid/Invalid login scenarios
   - Security testing (XSS, SQL Injection)
   - Session management

2. **Question Management**
   - CRUD operations on questions
   - Input validation
   - Special characters handling

3. **Template Management**
   - Template creation and configuration
   - Question association
   - Validation testing

4. **Test Creation**
   - Test setup with templates
   - Configuration validation
   - Settings management

5. **Test Scheduling**
   - Date/time validation
   - Candidate management
   - Email validation

6. **UI/UX Testing**
   - Responsive design
   - Cross-browser compatibility
   - Element interactions

7. **Security Testing**
   - Input sanitization
   - Authentication bypass attempts
   - File upload validation

## Bug Reporting Process

### Bug Severity Classification
- **Critical**: System crash, data loss, security breach
- **Major**: Feature not working, major functionality broken
- **Minor**: UI issues, minor functionality issues
- **Trivial**: Cosmetic issues, typos

### Bug Priority Classification
- **High**: Must be fixed immediately
- **Medium**: Should be fixed in next release
- **Low**: Can be fixed in future releases

### Bug Documentation
All bugs found will be documented in `HyreNet_Bug_Report.xlsx` with:
- Unique Bug ID
- Test Case reference
- Detailed description
- Steps to reproduce
- Expected vs Actual results
- Severity and Priority
- Screenshots/Videos
- Browser/Device information

## Reporting

### ExtentReports
- HTML reports generated in `test-output/extent-reports/`
- Includes pass/fail status, screenshots, execution time
- View report: Open `HyreNet-BugReport.html` in browser

### TestNG Reports
- XML and HTML reports in `test-output/`
- Detailed test execution logs

### Screenshots
- Captured on test failures (configurable)
- Stored in `test-output/screenshots/`
- Automatically attached to ExtentReports

## Jenkins Integration

### Prerequisites
- Jenkins installed with plugins:
  - Maven Integration
  - Git plugin
  - HTML Publisher plugin

### Setup Pipeline
1. Create new Pipeline job in Jenkins
2. Configure SCM: Point to GitHub repository
3. Use provided Jenkinsfile
4. Set build triggers (e.g., Poll SCM)
5. Configure post-build actions for report publishing

### Jenkinsfile Features
- Automated build and test execution
- Parallel test execution (if configured)
- Report generation and archiving
- Email notifications on failures
- Test result trending

## Best Practices Followed

### Code Organization
- Page Object Model for maintainability
- Separate utility classes for reusable functions
- Constants file for hardcoded values
- Properties file for configuration

### Waits Strategy
- Explicit waits for dynamic elements
- Fluent waits for complex scenarios
- Avoid Thread.sleep()

### Error Handling
- Try-catch blocks for robust tests
- Meaningful error messages
- Proper exception handling

### Logging
- Log4j integration for detailed logs
- Different log levels (INFO, DEBUG, ERROR)
- Console and file logging

### Data Management
- Externalized test data in Excel/properties
- Data-driven testing approach
- Test data independence

## Common Issues & Solutions

### Issue: Browser Driver Not Found
**Solution**: Ensure WebDriverManager dependency in pom.xml handles driver download automatically

### Issue: Element Not Found
**Solution**: Increase wait times in config.properties or use proper wait strategies

### Issue: Tests Fail in Headless Mode
**Solution**: Some UI validations may not work in headless; test in normal mode for UI bugs

### Issue: Jenkins Build Fails
**Solution**: Check Java and Maven versions, ensure all dependencies are accessible

## Video Recording
- Screen recordings for test executions can be captured using tools like:
  - Monte Screen Recorder (Java-based)
  - External tools like OBS Studio
- Store videos in `test-output/videos/`
- Reference video files in bug reports

## Contributing Guidelines
1. Create feature branch from main
2. Write tests following existing patterns
3. Ensure all tests pass before committing
4. Update documentation for new features
5. Submit pull request with clear description

## Contact Information
For questions or clarifications:
- Project Repository: [GitHub URL]
- Documentation: This README and code comments
- Bug Reports: Use provided Excel template

## Submission Checklist
- [ ] Test Scenarios document completed
- [ ] Test Cases Excel sheet with 40+ test cases
- [ ] Bug Report Excel with all identified bugs
- [ ] Requirement Traceability Matrix (RTM)
- [ ] Complete Selenium automation project on GitHub
- [ ] Proper README.md with setup instructions
- [ ] Screenshots of bugs in project
- [ ] Video recordings of test execution
- [ ] Jenkins integration configured
- [ ] ExtentReports generated
- [ ] Code follows proper folder structure
- [ ] No single-file submissions
- [ ] No company name in code
- [ ] Open-source license applied

## Timeline
- **Duration**: 72 hours from start
- **Deliverables**: All documents, code, and media files
- **Submission**: Via Google Form with URLs

## License
This project is open-source for assessment purposes only.

---
**Note**: This is a confidential assessment document. Do not share with anyone outside the assessment scope.
