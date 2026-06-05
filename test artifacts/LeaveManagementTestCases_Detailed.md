# Leave Management System — Detailed Test Cases

This document expands each test case from `test artifacts/test cases.md` with a detailed description, execution flow, and tracking fields. Requirement references are taken directly from `skills/claude.ms`.

## TC001 – Create valid leave request
- Description: Verify an employee can submit a valid leave request with a configured leave type, valid dates, and a reason. This covers core employee request creation and status tracking.
- Scenario: Employee submits a valid leave request.
- Preconditions: Employee is logged in, leave type is configured, leave balance is available.
- Steps:
  1. Navigate to the leave request form.
  2. Choose `Annual` leave type.
  3. Enter start date, end date, and reason `Vacation`.
  4. Submit the request.
- Expected output: Request is created with status `Pending` and appears in employee history.
- Test data: EmployeeID; `Annual`; 2026-07-01 to 2026-07-05; `Vacation`
- Positive: Yes
- Level of test: Functional
- Test priority: High
- Requirement number: 3.1.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Validates normal leave creation flow.

## TC002 – Create leave request with alternate type
- Description: Verify the system accepts a leave request using a non-Annual type such as `Sick`, demonstrating support for multiple leave categories.
- Scenario: Employee selects `Sick` leave and submits.
- Preconditions: Employee has sick leave entitlement and the leave type is available.
- Steps:
  1. Open leave request form.
  2. Select `Sick` leave type.
  3. Enter 2026-07-07 to 2026-07-09 and reason `Medical`.
  4. Submit the request.
- Expected output: Request is created with status `Pending` and records `Sick` leave.
- Test data: EmployeeID; `Sick`; 2026-07-07 to 2026-07-09; `Medical`
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.1
- SubRequirement number: 3.3.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Confirms alternate leave type support and entitlement handling.

## TC003 – View leave balance
- Description: Verify an employee can view remaining balances for all configured leave types and confirm the information is presented clearly.
- Scenario: Employee checks their leave balance.
- Preconditions: Employee has leave entitlement data and leave balances are stored.
- Steps:
  1. Access the leave balance or dashboard screen.
  2. Review remaining days for each leave type.
- Expected output: Display shows all leave types and remaining days clearly.
- Test data: EmployeeID
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.3
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies leave balance visibility in user view.

## TC004 – Submit leave request with reason
- Description: Verify that reason capture is required and preserved when employee submits a leave request.
- Scenario: Employee submits request including the reason field.
- Preconditions: Required fields are visible and reason is mandatory for the chosen leave type.
- Steps:
  1. Open leave request form.
  2. Select `Annual` leave type.
  3. Enter 2026-07-15 to 2026-07-16 and reason `Family event`.
  4. Submit request.
- Expected output: Request accepted, reason saved, status set to `Pending`.
- Test data: EmployeeID; `Annual`; 2026-07-15 to 2026-07-16; `Family event`
- Positive: Yes
- Level of test: Functional
- Test priority: High
- Requirement number: 3.1.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies reason capture and request validation.

## TC005 – Manager approves pending request
- Description: Verify a manager can approve a pending request and that approval updates request status and leave balance.
- Scenario: Manager approves a pending leave request.
- Preconditions: A pending request exists for the manager's direct report.
- Steps:
  1. Manager views pending requests.
  2. Selects the pending request.
  3. Chooses `Approve` and confirms.
- Expected output: Status changes to `Approved`, and the employee’s leave balance adjusts.
- Test data: ManagerID; RequestID; action=`Approve`
- Positive: Yes
- Level of test: Functional
- Test priority: High
- Requirement number: 3.2.2
- SubRequirement number: 4.3
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Confirms approval workflow and balance adjustment.

## TC006 – Manager rejects pending request
- Description: Verify a manager can reject a pending request, add a rejection comment, and preserve leave balance.
- Scenario: Manager rejects a pending leave request with a comment.
- Preconditions: A pending request exists for the manager's direct report.
- Steps:
  1. Manager opens the pending request.
  2. Selects `Reject`.
  3. Enters a rejection comment.
  4. Confirms rejection.
- Expected output: Status becomes `Rejected`; leave balance remains unchanged.
- Test data: ManagerID; RequestID; action=`Reject`; comment=`Not enough coverage`
- Positive: Yes
- Level of test: Functional
- Test priority: High
- Requirement number: 3.2.2
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Confirms rejection workflow and comment handling.

## TC007 – Employee views approved status
- Description: Verify employees can view the approved status of a request and inspect its details.
- Scenario: Employee checks an approved request.
- Preconditions: An approved request exists for the employee.
- Steps:
  1. Open request history.
  2. Locate the approved request.
  3. View request details.
- Expected output: Status displays `Approved`; request details accessible.
- Test data: EmployeeID; RequestID
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.2
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Validates post-approval status visibility.

## TC008 – Employee views rejected status
- Description: Verify employees can view rejected requests and understand the rejection state.
- Scenario: Employee checks a rejected request.
- Preconditions: A rejected request exists for the employee.
- Steps:
  1. Open request history.
  2. Locate the rejected request.
  3. View request details.
- Expected output: Status displays `Rejected`; request details accessible.
- Test data: EmployeeID; RequestID
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.2
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Validates rejected status visibility and transparency.

## TC009 – Admin creates new leave type
- Description: Verify an administrator can create a new leave type and configure entitlement for it.
- Scenario: Administrator adds a new leave type.
- Preconditions: Admin is logged in with entitlement management permissions.
- Steps:
  1. Access leave type administration.
  2. Add `Compassionate` leave type.
  3. Set entitlement to 5 days.
  4. Save the new type.
- Expected output: New leave type is available for selection.
- Test data: `Compassionate`; entitlement = 5 days
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.3.1
- SubRequirement number: 3.3.2
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies leave type creation and entitlement setup.

## TC010 – Generate leave usage report
- Description: Verify administrators can generate an accurate report of leave usage for a selected period.
- Scenario: Administrator generates a usage report.
- Preconditions: Leave requests exist for the selected reporting period.
- Steps:
  1. Open reporting section.
  2. Select date range 2026-07-01 to 2026-07-31.
  3. Generate the report.
- Expected output: Report contains leave counts, taken days, and remaining balances.
- Test data: Date range = 2026-07-01 to 2026-07-31
- Positive: Yes
- Level of test: System
- Test priority: Medium
- Requirement number: 3.3.3
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Confirms reporting capability for leave usage.

## TC011 – Submit leave with overlapping dates
- Description: Verify the system rejects a leave request when dates overlap existing approved leave for the same employee.
- Scenario: Employee applies for leave that overlaps approved leave.
- Preconditions: Approved leave already exists in the requested range.
- Steps:
  1. Open leave request form.
  2. Enter dates overlapping existing approved leave.
  3. Submit the request.
- Expected output: System rejects request with overlap validation error.
- Test data: EmployeeID; `Annual`; 2026-07-03 to 2026-07-07
- Positive: No
- Level of test: Functional
- Test priority: High
- Requirement number: 4.2
- SubRequirement number: 3.1.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Ensures overlapping leave is blocked according to validation rules.

## TC012 – Submit leave with end date before start date
- Description: Verify an invalid date range where the end date is earlier than the start date is rejected.
- Scenario: Employee enters invalid date range.
- Preconditions: Leave request form is accessible.
- Steps:
  1. Open leave request form.
  2. Set end date before start date.
  3. Submit request.
- Expected output: System rejects request and shows invalid date message.
- Test data: EmployeeID; `Annual`; 2026-07-10 to 2026-07-05
- Positive: No
- Level of test: Functional
- Test priority: High
- Requirement number: 3.1.1
- SubRequirement number: 4.2
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies invalid date validation is enforced.

## TC013 – Submit leave without required reason
- Description: Verify the system rejects a leave request when the required reason field is blank.
- Scenario: Employee leaves the reason field blank.
- Preconditions: Reason is mandatory for the leave type.
- Steps:
  1. Open leave request form.
  2. Leave reason blank.
  3. Submit request.
- Expected output: System rejects request and shows required field error.
- Test data: EmployeeID; `Annual`; 2026-07-10 to 2026-07-12; reason blank
- Positive: No
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Checks mandatory field enforcement for leave requests.

## TC014 – Manager approves non-direct-report request
- Description: Verify a manager cannot approve leave for an employee outside their direct reporting chain.
- Scenario: Manager tries to approve leave for someone outside their team.
- Preconditions: Manager is logged in and the request belongs to another team.
- Steps:
  1. Manager opens a request not assigned to their direct report.
  2. Attempts approval.
- Expected output: System denies the action and returns access error.
- Test data: ManagerID; RequestID not assigned to manager
- Positive: No
- Level of test: Security
- Test priority: High
- Requirement number: 3.2.2
- SubRequirement number: 3.2.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies authorization rules for manager actions.

## TC015 – Submit request with invalid leave type
- Description: Verify the system rejects an unsupported leave type selection and prevents request creation.
- Scenario: Employee selects an unsupported leave type.
- Preconditions: Leave type selection is available.
- Steps:
  1. Open leave request form.
  2. Choose invalid leave type `UndefinedType`.
  3. Submit request.
- Expected output: System rejects request or disables invalid type.
- Test data: EmployeeID; `UndefinedType`; 2026-07-20 to 2026-07-22
- Positive: No
- Level of test: Functional
- Test priority: Low
- Requirement number: 4.1
- SubRequirement number: 3.1.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Ensures invalid leave types are rejected.

## TC016 – Request creation with missing dates
- Description: Verify the system rejects a leave request when one or both date fields are missing.
- Scenario: Employee leaves a date field blank.
- Preconditions: Leave request form is accessible.
- Steps:
  1. Open leave request form.
  2. Leave start date or end date blank.
  3. Submit request.
- Expected output: System rejects request and highlights missing date.
- Test data: EmployeeID; `Annual`; start date blank
- Positive: No
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.1.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Checks required date validation.

## TC017 – Request creation when entitlement exhausted
- Description: Verify the system prevents leave requests when the employee has no remaining entitlement.
- Scenario: Employee has no remaining leave entitlement.
- Preconditions: Employee entitlement is zero.
- Steps:
  1. Open leave request form.
  2. Submit a new leave request.
- Expected output: System rejects request with insufficient balance error.
- Test data: EmployeeID; `Annual`; 2026-08-01 to 2026-08-03
- Positive: No
- Level of test: Functional
- Test priority: High
- Requirement number: 3.1.1
- SubRequirement number: 3.3.2
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies entitlement enforcement and balance restrictions.

## TC018 – Manager rejects already approved request attempt
- Description: Verify the system prevents a manager from rejecting a request that has already been approved.
- Scenario: Manager tries to reject a request that is already approved.
- Preconditions: Request status is `Approved`.
- Steps:
  1. Open an approved request.
  2. Attempt to reject it.
- Expected output: System prevents the action or returns invalid state error.
- Test data: ManagerID; ApprovedRequestID; action=`Reject`
- Positive: No
- Level of test: Functional
- Test priority: Medium
- Requirement number: 4.1
- SubRequirement number: 3.2.2
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Ensures invalid status transitions are blocked.

## TC019 – Admin creates duplicate leave type
- Description: Verify the system rejects duplicate leave type creation and displays a unique type error message.
- Scenario: Admin attempts to create a leave type that already exists.
- Preconditions: Leave type already exists in configuration.
- Steps:
  1. Access leave type administration.
  2. Create a duplicate `Annual` leave type.
- Expected output: System rejects duplicate and shows a unique type message.
- Test data: `Annual`; duplicate creation attempt
- Positive: No
- Level of test: System
- Test priority: Low
- Requirement number: 3.3.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Ensures leave type uniqueness is enforced.

## TC020 – Submit leave at entitlement boundary
- Description: Verify the system accepts a leave request when the requested days exactly match remaining entitlement.
- Scenario: Employee requests leave equal to remaining entitlement.
- Preconditions: Remaining leave days exactly match request duration.
- Steps:
  1. Open leave request form.
  2. Enter dates matching remaining entitlement.
  3. Submit request.
- Expected output: System approves request and uses remaining entitlement.
- Test data: EmployeeID; `Annual`; remaining days = requested days
- Positive: Yes
- Level of test: Functional
- Test priority: Medium
- Requirement number: 3.3.2
- SubRequirement number: 4.3
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies boundary entitlement handling.

## TC021 – Submit one-day leave request
- Description: Verify the system accepts a one-day leave request where start and end date are the same.
- Scenario: Employee requests leave for a single day.
- Preconditions: Leave request form available.
- Steps:
  1. Open leave request form.
  2. Set start and end date to the same day.
  3. Submit request.
- Expected output: System accepts request and records one-day leave.
- Test data: EmployeeID; `Annual`; 2026-07-22 to 2026-07-22
- Positive: Yes
- Level of test: Functional
- Test priority: Low
- Requirement number: 3.1.1
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies single-day leave handling.

## TC022 – Generate report with no leave requests
- Description: Verify the report generator handles an empty period and still returns valid zero counts.
- Scenario: Admin generates a report for a period with no requests.
- Preconditions: No leave requests exist in the selected date range.
- Steps:
  1. Open reporting section.
  2. Select date range 2026-08-01 to 2026-08-31.
  3. Generate the report.
- Expected output: Report returns zero counts and balances.
- Test data: Date range = 2026-08-01 to 2026-08-31; no requests
- Positive: Yes
- Level of test: System
- Test priority: Low
- Requirement number: 3.3.3
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies empty report behavior.

## TC023 – Submit leave request on boundary date
- Description: Verify the system accepts a leave request that begins today and validates boundary date logic.
- Scenario: Employee submits leave request on boundary date.
- Preconditions: Today is allowed as a valid start date.
- Steps:
  1. Open leave request form.
  2. Set start date to today and end date to tomorrow.
  3. Submit request.
- Expected output: System accepts request if allowed and validates dates correctly.
- Test data: EmployeeID; `Annual`; start date=today; end date=today + 1
- Positive: Yes
- Level of test: Functional
- Test priority: Low
- Requirement number: 3.1.2
- SubRequirement number: 4.1
- TestStatus1:
- Bug Number:
- Bug Description:
- Bug Status:
- Test approved By:
- Bug approved by:
- Bug assigned to:
- Test executed by:
- Test Executed on:
- Bug start date:
- Bug close date:
- Bug retested (Yes/No):
- Final status:
- Notes: Verifies same-day and boundary date submission.
