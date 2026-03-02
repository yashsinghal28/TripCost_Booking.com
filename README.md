# TripCost_Booking.com - Automation Testing Project

## Project Overview

**TripCost_Booking.com** is an automated testing project that validates the functionality of the Booking.com website (both hotels and cruises). This project uses **Selenium WebDriver** for browser automation and **TestNG** for test management, following the **Page Object Model (POM)** design pattern.

The project is divided into **4 team members**, with each handling specific test cases:
- **Yash**: TC_01 - TC_05 (Home Page & Search)
- **Anand**: TC_06 - TC_12 (Hotel Page & Filters)
- **Ashish**: TC_13 - TC_16 (Cruise Page Initial)
- **Satyam** (YOU): **TC_17 - TC_22** (Cruise Details & Validation)

---

## Table of Contents
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Setup & Installation](#setup--installation)
- [Configuration](#configuration)
- [Your Work: TC_17 to TC_22](#your-work-tc_17-to-tc_22)
- [How to Run Tests](#how-to-run-tests)
- [Reports & Logging](#reports--logging)
- [Key Classes & Components](#key-classes--components)

---

## Project Structure

```
TripCost_Booking.com-satyam/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── baseclass/
│   │       │   └── BaseClass.java           # Setup & teardown for all tests
│   │       ├── pages/
│   │       │   ├── HomePageActions.java     # Hotel page interactions
│   │       │   ├── HotelPageActions.java    # Hotel list & filters
│   │       │   └── CruisePageActions.java   # Cruise page interactions (YOUR CLASS)
│   │       ├── CommonCode/
│   │       │   └── Commoncode.java          # Utility methods (screenshots, waits)
│   │       ├── Logs/
│   │       │   └── Log.java                 # Logging wrapper for Log4j
│   │       └── utils/
│   │           └── Utils.java               # Configuration property reader
│   │
│   └── test/
│       ├── java/
│       │   ├── Test/
│       │   │   ├── TC_01_HomePopupHandling.java
│       │   │   ├── TC_02_LocationInput.java
│       │   │   ├── ...
│       │   │   ├── TC_017_SuiteValidation.java         # YOUR TEST
│       │   │   ├── TC_018_PrintListOfRooms.java        # YOUR TEST
│       │   │   ├── TC_019_ValidateOnboarding.java      # YOUR TEST
│       │   │   ├── TC_020_PrintStateList.java          # YOUR TEST
│       │   │   ├── TC_021_ValidatePriceOrCurrToken.java # YOUR TEST
│       │   │   └── TC_022_PhotoGallery.java            # YOUR TEST
│       │   │
│       │   └── reports/
│       │       └── ExtentReportManager.java # Report generation listener
│       │
│       └── resources/
│           └── log4j2.xml                   # Logging configuration
│
├── config.properties                        # Browser & URL configuration
├── testng.xml                              # Test suite configuration
├── pom.xml                                 # Maven dependencies
├── logs/                                   # Generated log files
├── reports/                                # Generated HTML reports
└── ScreenShot/                             # Generated screenshots

```

---

## Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17 | Programming language |
| **Selenium WebDriver** | 4.39.0 | Browser automation |
| **TestNG** | 7.12.0 | Test framework |
| **Maven** | Latest | Build automation & dependency management |
| **ExtentReports** | 5.1.2 | HTML test reporting |
| **Log4j** | 2.25.3 | Logging framework |
| **Apache Commons IO** | Latest | File operations for screenshots |

---

## Setup & Installation

### Prerequisites
- **Java 17** installed (download from [Oracle](https://www.oracle.com/java/technologies/downloads/#java17))
- **Maven** installed (download from [Apache Maven](https://maven.apache.org/))
- **Chrome/Firefox/Edge** browser installed
- **Git** for version control (optional)

### Installation Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yashsinghal28/TripCost_Booking.com.git
   cd TripCost_Booking.com-satyam
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Verify setup:**
   ```bash
   mvn --version
   java -version
   ```

---

## Configuration

### config.properties
Located at root level, contains:
```properties
browser=chrome              # Options: chrome, firefox, edge
URL1=https://www.booking.com/        # Hotel booking URL
URL2=https://cruises.booking.com/    # Cruise booking URL (YOUR TESTS USE THIS)
```

### testng.xml
Controls which tests run:
```xml
<test name="Trip-Cost-Booking" preserve-order="true">
    <classes>
        <!-- YOUR TESTS -->
        <class name="Test.TC_017_SuiteValidation"/>
        <class name="Test.TC_018_PrintListOfRooms"/>
        <class name="Test.TC_019_ValidateOnboarding"/>
        <class name="Test.TC_020_PrintStateList"/>
        <class name="Test.TC_021_ValidatePriceOrCurrToken"/>
        <class name="Test.TC_022_PhotoGallery"/>
    </classes>
</test>
```

---

## Your Work: TC_17 to TC_22

### Overview
You are handling **6 test cases** that validate the **Cruise Booking functionality** on Booking.com.

### Test Case Details

#### **TC_017: Suite Validation** ✓
- **Purpose**: Validates that stateroom types (Suite, Balcony, etc.) display correctly
- **Steps**:
  1. Navigate to cruise booking page (URL2)
  2. Close popup
  3. Select "Royal Caribbean" cruise line
  4. Choose a specific cruise
  5. Click "Stateroom" section
  6. Verify "Suite" text is visible
- **Assertion**: Stateroom type should be "Suite"

#### **TC_018: Print List of Rooms** 📋
- **Purpose**: Extract and display all available staterooms with their deck information
- **Steps**:
  1. Navigate to cruise page
  2. Select cruise and open Stateroom section
  3. Extract all room types and deck numbers
  4. Print list to logs for documentation
  5. Take screenshots at different scroll levels
- **Output**: List of rooms like "Balcony Suite -> Deck 9"

#### **TC_019: Validate Onboarding** ✅
- **Purpose**: Verify cruise amenities and ship specifications are accessible
- **Steps**:
  1. Navigate to cruise page
  2. Click "Onboarding Experience" section
  3. Verify "Dining" header is visible
  4. Extract elevator count from ship details
  5. Get crew size and passenger capacity
- **Assertions**:
  - Dining header should be enabled
  - Elevator count should be > 0

#### **TC_020: Print State List** 📊
- **Purpose**: Extract and log all cruise ship statistics and amenities
- **Steps**:
  1. Navigate to cruise page
  2. Open Onboarding section
  3. Collect all statistics (dining, decks, capacity, crew, elevators)
  4. Print to logs
  5. Take screenshots
- **Output**: Complete ship specifications in logs

#### **TC_021: Validate Price/Currency Token** 💰
- **Purpose**: Ensure prices and currency symbols display on the page
- **Steps**:
  1. Navigate to cruise details
  2. Get page source (all HTML)
  3. Search for currency symbol "$"
  4. Take screenshots of pricing areas
- **Assertion**: Page should contain "$" symbol

#### **TC_022: Photo Gallery** 📸
- **Purpose**: Validate that cruise photo gallery opens and functions
- **Steps**:
  1. Navigate to cruise page
  2. Scroll down
  3. Click photo gallery button
  4. Verify gallery opens
  5. Take screenshot
- **Purpose**: Users need to view cruise photos for decision-making

---

## How to Run Tests

### Run All Your Tests (TC_17-TC_22):
```bash
mvn clean test
```

### Run Only Your Test Suite:
```bash
mvn clean test -Dsuites=testng.xml
```

### Run Specific Test Case:
```bash
mvn test -Dtest=TC_017_SuiteValidation
mvn test -Dtest=TC_018_PrintListOfRooms
mvn test -Dtest=TC_019_ValidateOnboarding
mvn test -Dtest=TC_020_PrintStateList
mvn test -Dtest=TC_021_ValidatePriceOrCurrToken
mvn test -Dtest=TC_022_PhotoGallery
```

### Run with Different Browser:
Edit `config.properties`:
```properties
browser=firefox  # or edge
```

---

## Reports & Logging

### Test Reports
After test execution, view the HTML report:
```
reports/ExtentReport.html
```

**Report contains:**
- ✓ Pass/Fail status for each test
- 📸 Screenshots taken during tests
- 📋 Detailed logs of each action
- 👥 Team member information

### Log Files
All activities are logged to:
```
logs/Application.log
```

**Log format:**
```
12:45:30.123 INFO  - Test for Suit Element Passed
12:45:31.456 INFO  - Presence of Header is Verified
12:45:35.789 INFO  - Gallery viewed Successfully
```

### Screenshots
Captured at key points:
```
ScreenShot/TC-17_suit_validation_screenshot.jpeg
ScreenShot/TC-18_stateroom_screenshot.jpeg
ScreenShot/TC-22_PhotoGalleryScreenshot.jpeg
```

---

## Key Classes & Components

### **BaseClass.java**
```
Role: Foundation for all tests
Provides:
  - Browser initialization (Chrome/Firefox/Edge)
  - URL loading from config.properties
  - Implicit wait setup (10 seconds)
  - Explicit wait setup (15 seconds)
  - Browser cleanup after each test
```

### **CruisePageActions.java** (YOUR MAIN CLASS)
```
Role: Page Object Model for cruise page
Contains:
  - Web element locators (@FindBy annotations)
  - Action methods (clickButton, scroll, etc.)
  - Data extraction methods (getSuitList, getResult)
  - Helper methods (elevatorCount, etc.)

Key Methods for Your Tests:
  - ClosePopUp()              // Closes popup
  - chooseCruise()            // Selects Royal Caribbean
  - triggerCruiseButton()     // Selects specific cruise
  - clickStateRoom()          // Expands stateroom section
  - triggerOnBoardingButton() // Expands amenities section
  - photoClickButton()        // Opens photo gallery
  - getSuitList()             // Returns list of rooms
  - getResult()               // Returns ship statistics
  - elevatorCount()           // Returns elevator count
  - printSuitList()           // Prints room list
  - printStatsList()          // Prints all stats
```

### **CommonCode.java**
```
Utility Methods:
  - takeScreenShot(driver, name)      // Captures screenshot
  - implicitWait(driver)              // Sets implicit wait
  - waitForDocumentReady(driver, sec) // Waits for page load
```

### **Log.java**
```
Logging Wrapper:
  - Log.info(message)  // Logs informational message
  - Log.warn(message)  // Logs warning message
```

### **Utils.java**
```
Configuration Reader:
  - fetchPropertyValue(key) // Reads from config.properties
```

### **ExtentReportManager.java**
```
Report Listener:
  - Implements ITestListener
  - Captures test results
  - Generates HTML report in reports/
  - Shows Pass/Fail/Skip status
```

---

## Page Object Model (POM) Structure

Your tests use **POM** design pattern:

```
Instead of writing in test:
❌ driver.findElement(By.xpath("//button[@id='expandCollapse_stateroom']")).click();

You use in CruisePageActions:
✅ @FindBy(xpath = "//button[@id='expandCollapse_stateroom']")
   public WebElement stateRoom;
   
   public void clickStateRoom() {
       stateRoom.click();
   }

Then in test:
✅ cruise.clickStateRoom();
```

**Benefits:**
- Cleaner test code
- Easier maintenance (change XPath once in POM)
- Better reusability
- Follows industry standards

---

## Test Execution Flow (Example: TC_019)

```
1. TestNG Framework calls test method
   ↓
2. BaseClass.setUp() runs:
   - Launches Chrome browser
   - Maximizes window
   - Sets implicit wait (10 sec)
   - Sets explicit wait (15 sec)
   ↓
3. Test method executes:
   - cruise = new CruisePageActions(driver)
   - driver.get(url2)  // https://cruises.booking.com/
   - cruise.ClosePopUp()
   - cruise.chooseCruise()
   - cruise.triggerCruiseButton()
   - cruise.triggerOnBoardingButton()
   ↓
4. Assertions validate:
   - headerDining.isEnabled() ✓
   - elevatorCount() > 0 ✓
   ↓
5. Logs recorded:
   - "Presence of Header is Verified"
   - "Presence of Elevators is valid: 5"
   ↓
6. ExtentReportManager listens:
   - onTestSuccess() called
   - Status = PASSED
   ↓
7. BaseClass.tearDown() runs:
   - driver.quit() closes browser
   ↓
8. Result in ExtentReport.html:
   - TC_019_ValidateOnboarding - PASSED ✓
```

---

## Maven Build Lifecycle

```bash
mvn clean          # Deletes target/ folder
mvn compile        # Compiles source code
mvn test          # Runs all tests (calls setUp, test, tearDown)
mvn package       # Creates JAR file
mvn clean install # Clean + Compile + Test + Package
```

### Common Maven Commands:
```bash
# Run tests with logging
mvn clean test -X

# Run tests in parallel
mvn test -DparallelSuites=2

# Skip tests but compile
mvn clean install -DskipTests

# Run single test class
mvn test -Dtest=TC_017_SuiteValidation
```

---

## Dependency Overview

### pom.xml Dependencies:

| Dependency | Version | Purpose |
|-----------|---------|---------|
| selenium-java | 4.39.0 | Browser automation |
| testng | 7.12.0 | Test framework & assertions |
| extentreports | 5.1.2 | Beautiful test reports |
| log4j-core | 2.25.3 | Logging |
| commons-io | Latest | File operations |

All dependencies are managed by Maven - no manual installation needed!

---

## Best Practices Used

✅ **Page Object Model (POM)** - Centralized element locators  
✅ **DRY Principle** - Reusable methods in CommonCode  
✅ **Explicit Waits** - WebDriverWait for reliability  
✅ **Logging** - Track every action  
✅ **Assertions** - Validate expected vs actual  
✅ **Screenshots** - Evidence of test execution  
✅ **Configuration Files** - Easy to change URLs/browsers  
✅ **Reporting** - Beautiful HTML reports with ExtentReports  

---

## Interview Q&A - Your Part

### Q: What are you testing in TC_17-TC_22?
**A:** "I'm testing the Cruise Booking section with 6 test cases that validate stateroom types, extract cruise specifications, verify ship amenities, check pricing, and test the photo gallery."

### Q: What's the purpose of CruisePageActions?
**A:** "It's a Page Object Model class that contains all XPath locators and action methods for the cruise page. This centralizes element identification and makes tests more maintainable."

### Q: How do your tests handle waits?
**A:** "We use implicit waits (10 seconds) for general element visibility and explicit waits (15 seconds) for specific critical elements. We also have a waitForDocumentReady method to ensure the page is fully loaded."

### Q: What happens when a test fails?
**A:** "The ExtentReportManager listener captures the failure, logs the error, and the test is marked as FAILED in the HTML report. We also take screenshots at key points for evidence."

### Q: How do you ensure test reliability?
**A:** "By using proper waits, assertions, logging, and following POM pattern. We also use explicit waits with ExpectedConditions for critical elements."

---

## Troubleshooting

### Issue: Tests not finding elements
**Solution**: Increase wait times in BaseClass or check if XPaths have changed

### Issue: Browser not launching
**Solution**: Check config.properties - verify browser name matches installed browser

### Issue: Screenshots not saved
**Solution**: Verify ScreenShot/ folder exists and has write permissions

### Issue: Report not generated
**Solution**: Check if ExtentReportManager listener is in testng.xml

---

## Project Team

| Member | Test Cases | Focus |
|--------|-----------|-------|
| Yash | TC_01-TC_05 | Home page & search functionality |
| Anand | TC_06-TC_12 | Hotel listings & filters |
| Ashish | TC_13-TC_16 | Cruise page initial validation |
| **Satyam (YOU)** | **TC_17-TC_22** | **Cruise details & validation** |

---

## Quick Reference - Your Commands

```bash
# Run your tests
mvn clean test

# Run specific test
mvn test -Dtest=TC_017_SuiteValidation

# View test report
open reports/ExtentReport.html  # macOS
start reports/ExtentReport.html # Windows

# Check logs
cat logs/Application.log        # Linux/macOS
type logs/Application.log       # Windows

# Build without testing
mvn clean install -DskipTests
```

---

## Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [ExtentReports](https://www.extentreports.com/)
- [Log4j Documentation](https://logging.apache.org/log4j/2.x/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

---

## Version Information

- **Project Version**: 1.0-SNAPSHOT
- **Java Version**: 17
- **Maven Compiler**: Java 17
- **Last Updated**: February 2026

---

## License

This is a **group project** for **automation testing practice**. Internal use only.

**Team Members**: Yash, Satyam, Anand, Ashish

---

## Notes

- All tests use the **same browser and URL configuration** from config.properties
- Tests are **independent** - each can run in any order
- **Screenshots** are taken for every test for audit trail
- **Logs** track all activities for debugging
- **ExtentReports** generates a professional test summary

---

**Happy Testing! 🚀**

For questions about your part (TC_17-TC_22), refer to the "Your Work" section above.
