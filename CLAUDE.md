# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build and run all tests
mvn clean test

# Compile only (no tests)
mvn clean compile

# Run only the JUnit 5 tests (LeaveServiceTest, LeaveServiceAllTestCases)
mvn test -Dtest="LeaveServiceTest,LeaveServiceAllTestCases" -Dsurefire.failIfNoSpecifiedTests=false

# Run only the TestNG suite (LeaveServiceTestNG via testng.xml)
mvn test -DsuiteXmlFile=testng.xml
```

After a TestNG run, an HTML report is generated at:
`target/test-output/ExtentReports/LeaveServiceExecutionReport.html`

## Architecture

This is a pure Java (Java 17) Maven project with no persistence layer — all state lives in-memory.

**Core domain** (`src/main/java/com/example/leavemanagement/`):
- `LeaveService` — the single service class; holds all `LeaveRequest` objects in a `HashMap<String, LeaveRequest>`. Central to all business logic (submit, approve, reject, query).
- `LeaveRequest` — a value object with an auto-generated UUID id. Status is mutable (`PENDING` → `APPROVED` or `REJECTED`); all other fields are immutable after construction.
- `LeaveType` enum — `PAID`, `SICK`, `UNPAID`
- `LeaveStatus` enum — `PENDING`, `APPROVED`, `REJECTED`
- `LeaveManagementApp` — a simple `main()` demonstrating the service; not used by tests.

**Test layer** (`src/test/java/com/example/leavemanagement/`):
- `LeaveServiceTest` — minimal JUnit 5 smoke tests (2 cases).
- `LeaveServiceAllTestCases` — full JUnit 5 test suite mirroring the 23 test cases; TC011–TC023 are `@Disabled` pending feature implementation.
- `LeaveServiceTestNG` — the canonical TestNG test class driven by `testng.xml`; same 23 test cases with priority ordering; TC011–TC023 are `enabled = false`.
- `TestNGExtentReporter` — TestNG `ITestListener` that generates the ExtentReports HTML report.
- `TestNGSummaryReporter` — a second TestNG listener for console/summary output.

**Surefire configuration** (`pom.xml`): runs both `**/*Test.java` (JUnit 5) and the TestNG `testng.xml` suite. Both frameworks coexist via separate dependencies.

## Known unimplemented features (TC011–TC023)

The disabled tests document planned but not-yet-built capabilities:
- Date range validation (start/end dates, overlapping leaves, boundary dates)
- Required field enforcement (reason, dates)
- Entitlement tracking and boundary validation
- Manager authorization (direct-report checks)
- Duplicate leave type prevention
- State transition guards (e.g., rejecting an already-approved request)
- Leave reporting with empty data

When implementing any of these, enable the corresponding test in both `LeaveServiceAllTestCases` and `LeaveServiceTestNG`, and add the feature to `LeaveService`.
