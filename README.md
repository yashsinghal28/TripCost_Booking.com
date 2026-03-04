# TripCost_Booking.com - Automation Testing Project

## Project Overview

**TripCost_Booking.com** is an automated testing project that validates the functionality of the Booking.com website (both hotels and cruises). This project uses **Selenium WebDriver** for browser automation and **TestNG** for test management, following the **Page Object Model (POM)** design pattern.

The project is divided into **4 team members**, with each handling specific test cases:
- **Anand**: TC_01 - TC_05 (Home Page & Search)
- **Yash**: TC_06 - TC_11 (Hotel Page & Filters)
- **Ashish**: TC_12 - TC_17 (Cruise Page Initial)
- **Satyam**: TC_18 - TC_22 (Cruise Details & Validation)

---

## Table of Contents
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Setup & Installation](#setup--installation)
- [Test Case Details (All Members)](#test-case-details-all-members)
- [How to Run Tests](#how-to-run-tests)
- [Reports & Logging](#reports--logging)
- [Key Classes & Components](#key-classes--components)

---

## Project Structure

```
TripCost_Booking.com/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── baseclass/
│   │       │   └── BaseClass.java           # Setup & teardown for all tests
│   │       ├── pages/
│   │       │   ├── HomePageActions.java     # Hotel page interactions
│   │       │   ├── HotelPageActions.java    # Hotel list & filters
│   │       │   └── CruisePageActions.java   # Cruise page interactions
│   │       ├── CommonCode/
│   │       │   └── Commoncode.java          # Utility methods (screenshots, waits)
│   │       ├── Logs/
│   │       │   └── Log.java                 # Logging wrapper for Log4j
│   │       └── utils/
│   │           └── Utils.java               # Utility helpers
│   │       
│   └── test/
│       ├── java/
│       │   ├── Test/
│       │   │   ├── TC_001_BookingHomePopupHandlingandDisplay.java
│       │   │   ├── TC_002_BookingLocationInput.java
│       │   │   ├── TC_003_BookingDateSelection.java
│       │   │   ├── TC_004_BookingOccupancyAdjustment.java
│       │   │   ├── TC_005_BookingSearchAndNavigate.java
│       │   │   ├── TC_06_GetAllHotels.java
│       │   │   ├── TC_07_SortByReview.java
│       │   │   ├── TC_08_ElevatorFilter.java
│       │   │   ├── TC_09_AddBedsAnd5starHotels.java
│       │   │   ├── TC_010_FinalHotelList.java
│       │   │   ├── TC_011_GridView.java
│       │   │   ├── TC_012_SecondURLOpen.java
│       │   │   ├── TC_013_ClosePopUpCruise.java
│       │   │   ├── TC_014_ValidateCruiseLine.java
│       │   │   ├── TC_015_SailingMonthValidation.java
│       │   │   ├── TC_016_CruisePageValidation.java
│       │   │   ├── TC_017_SuiteValidation.java
│       │   │   ├── TC_018_PrintListOfRooms.java
│       │   │   ├── TC_019_ValidateOnboarding.java
│       │   │   ├── TC_020_PrintStateList.java
│       │   │   ├── TC_021_ValidatePriceOrCurrToken.java
│       │   │   └── TC_022_PhotoGallery.java
│       │   │   
│       │   └── reports/
│       │       └── ExtentReportManager.java # Report generation listener
│       │   
│       └── resources/
│           └── log4j2.xml                   # Logging configuration
│
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
   cd TripCost_Booking.com
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

## Test Case Details (All Members)

### Anand (TC_01 - TC_05) — Home Page & Search

#### **TC_001: Booking Home Popup Handling & Display**
- **Purpose**: Ensure the home popup can be closed and the Booking.com logo is visible.
- **Steps**:
  1. Open the Booking.com home page (URL1).
  2. If popup appears, close it.
  3. Check if the Booking.com logo is displayed.
  4. Capture screenshot.
- **Assertions**:
  - Popup closes successfully if displayed.
  - Logo image is visible on the page.

#### **TC_002: Booking Location Input**
- **Purpose**: Validate location input and currency selection on the home page.
- **Steps**:
  1. Open the Booking.com home page.
  2. Close popup if present.
  3. Select INR currency.
  4. Enter location from properties file.
  5. Capture screenshot.
- **Assertions**:
  - Currency text equals INR.
  - Location input field value matches expected location.

#### **TC_003: Booking Date Selection**
- **Purpose**: Validate date range selection works correctly.
- **Steps**:
  1. Open home page.
  2. Close popup.
  3. Enter location.
  4. Select check-in and check-out dates.
  5. Capture screenshot.
- **Assertions**:
  - Date picker remains displayed after selection.

#### **TC_004: Booking Occupancy Adjustment**
- **Purpose**: Validate occupancy adjustment for adults.
- **Steps**:
  1. Open home page.
  2. Close popup.
  3. Enter location.
  4. Select dates.
  5. Adjust occupancy (adults).
  6. Capture screenshot.
- **Assertions**:
  - Adult count equals expected value (4).

#### **TC_005: Booking Search & Navigate**
- **Purpose**: Validate search results load after entering data.
- **Steps**:
  1. Open home page.
  2. Close popup.
  3. Enter location.
  4. Select dates and occupancy.
  5. Click Search.
  6. Capture screenshot.
- **Assertions**:
  - Results page title is non-empty.

---

### Yash (TC_06 - TC_11) — Hotel Page & Filters

#### **TC_06: Get All Hotels**
- **Purpose**: Validate hotel list visibility and log all hotel names.
- **Steps**:
  1. Perform hotel search from home page.
  2. Wait for results page to load.
  3. Verify Options/Filters button.
  4. Fetch all hotels and log names.
  5. Capture screenshot.
- **Assertions**:
  - Options/Filters button is visible.
  - Hotel list is not empty.

#### **TC_07: Sort by Review**
- **Purpose**: Ensure hotels can be sorted by top reviewed.
- **Steps**:
  1. Search hotels.
  2. Apply “Top Reviewed” sorting.
  3. Capture screenshot.
- **Assertions**:
  - Sorting applied successfully (options button still visible).

#### **TC_08: Elevator Filter**
- **Purpose**: Validate elevator accessibility filter.
- **Steps**:
  1. Search hotels.
  2. Apply elevator accessibility filter.
  3. Capture screenshot.
- **Assertions**:
  - Elevator filter is displayed/active.

#### **TC_09: Add Beds & 5-Star Hotels**
- **Purpose**: Validate 5-star filter and bed selection.
- **Steps**:
  1. Search hotels.
  2. Fetch hotel list and prices.
  3. Select 5-star filter.
  4. Increase bed count to 2.
  5. Capture screenshot.
- **Assertions**:
  - Hotels and prices are not empty.

#### **TC_010: Final Hotel List**
- **Purpose**: Capture top hotel results and export to Excel.
- **Steps**:
  1. Search hotels.
  2. Fetch hotel list and prices.
  3. Select 5-star hotels.
  4. Increase bed count.
  5. For top 10 hotels, calculate price per day.
  6. Export results to Excel.
  7. Capture screenshot.
- **Assertions**:
  - Data rows generated for hotels.
  - Excel file written successfully.

#### **TC_011: Grid View**
- **Purpose**: Validate grid view layout on hotel results page.
- **Steps**:
  1. Search hotels.
  2. Click grid view button.
  3. Capture screenshot.
- **Assertions**:
  - Grid view button remains displayed.

---

### Ashish (TC_12 - TC_17) — Cruise Page Initial

#### **TC_012: Second URL Open**
- **Purpose**: Validate cruise booking page loads successfully.
- **Steps**:
  1. Navigate to cruise URL (URL2).
  2. Capture screenshot.
  3. Check cruise logo display.
- **Assertions**:
  - Cruise logo is displayed.

#### **TC_013: Close Cruise Popup**
- **Purpose**: Validate cookie popup handling and search bar on cruise page.
- **Steps**:
  1. Navigate to cruise URL.
  2. Validate title.
  3. Close popup.
  4. Enter destination in search bar.
  5. Capture screenshot.
- **Assertions**:
  - Title matches expected.
  - Search bar displayed and enabled.

#### **TC_014: Validate Cruise Line**
- **Purpose**: Ensure correct cruise line selection.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup.
  3. Select “Royal Caribbean”.
  4. Capture screenshots.
- **Assertions**:
  - Cruise line text matches expected.

#### **TC_015: Sailing Month Validation**
- **Purpose**: Validate cruise sailing month is not in the past.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup.
  3. Select cruise line.
  4. Read sailing month text.
  5. Parse into YearMonth.
  6. Capture screenshot.
- **Assertions**:
  - Sailing month is not before current month.

#### **TC_016: Cruise Page Validation**
- **Purpose**: Validate cruise page header and visibility of key elements.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup.
  3. Select cruise line.
  4. Validate cruise card display.
  5. Capture screenshot.
- **Assertions**:
  - Cruise card/section is visible.

#### **TC_017: Suite Validation**
- **Purpose**: Validate stateroom section shows “Suite”.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup.
  3. Select cruise line.
  4. Open cruise details.
  5. Expand stateroom section.
  6. Capture screenshot.
- **Assertions**:
  - Suite text is visible in stateroom list.

---

### Satyam (TC_18 - TC_22) — Cruise Details & Validation

#### **TC_018: Print List of Rooms**
- **Purpose**: Extract and log all stateroom types with deck info.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup and select cruise.
  3. Expand stateroom section.
  4. Print room list.
  5. Take multiple screenshots.
- **Assertions**:
  - Room list extracted successfully.

#### **TC_019: Validate Onboarding**
- **Purpose**: Validate onboarding section and ship stats.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup and select cruise.
  3. Expand onboarding section.
  4. Validate dining header.
  5. Extract elevator count, crew, capacity.
- **Assertions**:
  - Dining header enabled.
  - Elevator count > 0.

#### **TC_020: Print State List**
- **Purpose**: Print and log ship statistics.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup and select cruise.
  3. Expand onboarding section.
  4. Print statistics list.
  5. Capture screenshots.
- **Assertions**:
  - Statistics list printed successfully.

#### **TC_021: Validate Price/Currency Token**
- **Purpose**: Ensure pricing and currency symbols appear.
- **Steps**:
  1. Navigate to cruise details.
  2. Get page source.
  3. Search for "$" symbol.
  4. Capture screenshots.
- **Assertions**:
  - Page source contains "$" symbol.

#### **TC_022: Photo Gallery**
- **Purpose**: Validate cruise photo gallery opens correctly.
- **Steps**:
  1. Navigate to cruise URL.
  2. Close popup and select cruise.
  3. Scroll and open photo gallery.
  4. Capture screenshots.
- **Assertions**:
  - Photo gallery opens successfully.

---

## How to Run Tests

### Run All Tests:
```bash
mvn clean test
```

### Run Only Test Suite:
```bash
mvn clean test -Dsuites=testng.xml
```

### Run Specific Test Case:
```bash
mvn test -Dtest=TC_001_BookingHomePopupHandlingandDisplay
mvn test -Dtest=TC_002_BookingLocationInput
mvn test -Dtest=TC_003_BookingDateSelection
mvn test -Dtest=TC_004_BookingOccupancyAdjustment
mvn test -Dtest=TC_005_BookingSearchAndNavigate
mvn test -Dtest=TC_06_GetAllHotels
mvn test -Dtest=TC_07_SortByReview
mvn test -Dtest=TC_08_ElevatorFilter
mvn test -Dtest=TC_09_AddBedsAnd5starHotels
mvn test -Dtest=TC_010_FinalHotelList
mvn test -Dtest=TC_011_GridView
mvn test -Dtest=TC_012_SecondURLOpen
mvn test -Dtest=TC_013_ClosePopUpCruise
mvn test -Dtest=TC_014_ValidateCruiseLine
mvn test -Dtest=TC_015_SailingMonthValidation
mvn test -Dtest=TC_016_CruisePageValidation
mvn test -Dtest=TC_017_SuiteValidation
mvn test -Dtest=TC_018_PrintListOfRooms
mvn test -Dtest=TC_019_ValidateOnboarding
mvn test -Dtest=TC_020_PrintStateList
mvn test -Dtest=TC_021_ValidatePriceOrCurrToken
mvn test -Dtest=TC_022_PhotoGallery
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
  - Implicit wait setup (10 seconds)
  - Explicit wait setup (15 seconds)
  - Browser cleanup after each test
```

### **CruisePageActions.java**
```
Role: Page Object Model for cruise page
Contains:
  - Web element locators (@FindBy annotations)
  - Action methods (clickButton, scroll, etc.)
  - Data extraction methods (getSuitList, getResult)
  - Helper methods (elevatorCount, etc.)
```

### **CommonCode.java**
```
Utility Methods:
  - takeScreenShot(driver, name)      // Captures screenshot
  - implicitWait(driver)              // Sets implicit wait
  - waitForDocumentReady(driver, sec) // Waits for page load
```

---

## Project Team

| Member | Test Cases | Focus |
|--------|-----------|-------|
| Anand | TC_01-TC_05 | Home page & search functionality |
| Yash | TC_06-TC_11 | Hotel listings & filters |
| Ashish | TC_12-TC_17 | Cruise page initial validation |
| Satyam | TC_18-TC_22 | Cruise details & validation |

---

## Notes

- Tests are **independent** — each can run in any order
- **Screenshots** are taken for every test for audit trail
- **Logs** track all activities for debugging
- **ExtentReports** generates a professional test summary

---

**Happy Testing! 🚀**
