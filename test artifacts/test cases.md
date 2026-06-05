# Leave Management System Test Cases

## Happy Path

### TC001 – Create valid leave request
- Description: Verify an employee can submit a complete leave request with a configured leave type, valid dates, and a reason, and that the request enters the pending review state.
- Scenario: Employee submits a valid leave request.
- Preconditions: Employee is logged in, leave type is configured, leave balance is available.
- Steps:
  1. Navigate to the leave request form.
  2. Select `Annual` leave type.
  3. Enter start date 2026-07-01, end date 2026-07-05, and reason `Vacation`.
  4. Submit the request.
- Expected output: Request is created successfully with status `Pending` and appears in employee request history.
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
- Notes: Validates normal leave creation flow and pending status tracking.

### TC002 – Create leave request with alternate type
- Description: Verify the system accepts a leave request using a secondary leave type such as `Sick`, ensuring that alternate leave categories are supported.
- Scenario: Employee selects `Sick` leave and submits.
- Preconditions: Employee has sick leave entitlement and the `Sick` leave type is available.
- Steps:
  1. Open the leave request form.
  2. Select `Sick` leave type.
  3. Enter dates 2026-07-07 to 2026-07-09 and reason `Medical`.
  4. Submit the request.
- Expected output: Request is created with status `Pending` and `Sick` is recorded as the leave type.
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
- Notes: Confirms support for alternate leave types and correct request creation.

### TC003 – View leave balance
- Description: Verify an employee can view remaining leave balances for configured leave types and confirm the values are displayed clearly.
- Scenario: Employee checks their leave balance.
- Preconditions: The employee has leave entitlement data and leave balances are available.
- Steps:
  1. Access the leave balance screen or dashboard.
  2. Review the remaining days shown for each leave type.
- Expected output: Remaining balances for all leave types are visible and accurate.
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
- Notes: Verifies leave balance visibility and entitlement transparency.

### TC004 – Submit leave request with reason
- Description: Verify that reason input is accepted and preserved when an employee submits a leave request, and that the request transitions to pending.
- Scenario: Employee submits request including the reason field.
- Preconditions: Required request fields are visible and the reason field is mandatory for the leave type.
- Steps:
  1. Open the leave request form.
  2. Select `Annual` leave type.
  3. Enter dates 2026-07-15 to 2026-07-16 and reason `Family event`.
  4. Submit the request.
- Expected output: Request is accepted, reason is saved, and status is `Pending`.
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
- Notes: Verifies reason capture, mandatory field enforcement, and request persistence.

### TC005 – Manager approves pending request
- Description: Verify a manager can approve a pending leave request and that approval updates both request status and leave balance.
- Scenario: Manager approves a pending leave request.
- Preconditions: A pending request exists for the manager's direct report.
- Steps:
  1. Manager opens the pending request list.
  2. Selects the request.
  3. Clicks `Approve` and confirms the action.
- Expected output: Request status changes to `Approved` and the employee's leave balance updates accordingly.
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
- Notes: Confirms manager approval workflow and correct balance adjustment.

### TC006 – Manager rejects pending request
- Description: Verify a manager can reject a pending leave request with comments and that the leave balance remains unchanged.
- Scenario: Manager rejects a pending leave request with a comment.
- Preconditions: A pending request exists for the manager's direct report.
- Steps:
  1. Manager opens the pending request.
  2. Chooses `Reject`.
  3. Enters rejection comment `Not enough coverage`.
  4. Confirms rejection.
- Expected output: Request status becomes `Rejected` and leave balance remains unchanged.
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
- Notes: Confirms rejection workflow and manager comment handling.

### TC007 – Employee views approved status
- Description: Verify that employees can view an approved leave request and access its details after manager approval.
- Scenario: Employee checks an approved request.
- Preconditions: An approved request exists for the employee.
- Steps:
  1. Open request history.
  2. Find the approved request.
  3. View request details.
- Expected output: The request displays status `Approved` and the details are visible.
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
- Notes: Validates approved request visibility and employee tracking.

### TC008 – Employee views rejected status
- Description: Verify that employees can view rejected leave requests and that the rejection state is clearly displayed.
- Scenario: Employee checks a rejected request.
- Preconditions: A rejected request exists for the employee.
- Steps:
  1. Open request history.
  2. Find the rejected request.
  3. View request details.
- Expected output: The request displays status `Rejected` and the details are visible.
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
- Notes: Validates rejected status visibility and decision transparency.

### TC009 – Admin creates new leave type
- Description: Verify an administrator can create a new leave type, configure entitlement, and make it available for employee requests.
- Scenario: Administrator adds a new leave type.
- Preconditions: Admin is logged in with entitlement management permissions.
- Steps:
  1. Open leave type administration.
  2. Add `Compassionate` leave type.
  3. Set entitlement to 5 days.
  4. Save the new leave type.
- Expected output: The new leave type is created and available for selection.
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
- Notes: Verifies leave type creation and entitlement configuration.

### TC010 – Generate leave usage report
- Description: Verify administrators can generate a leave usage report for a date range and receive accurate counts, taken days, and balances.
- Scenario: Administrator generates a usage report.
- Preconditions: Leave requests exist for the selected period.
- Steps:
  1. Open reporting section.
  2. Select date range 2026-07-01 to 2026-07-31.
  3. Generate the report.
- Expected output: The report displays leave counts, taken days, and remaining balances.
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
- Notes: Confirms reporting capability and data accuracy.

## Negative

### TC011 – Submit leave with overlapping dates
- Description: Verify the system rejects leave requests when the requested dates overlap existing approved leave for the same employee.
- Scenario: Employee applies for leave that overlaps approved leave.
- Preconditions: Approved leave exists in the requested date range.
- Steps:
  1. Open the leave request form.
  2. Enter dates overlapping existing approved leave.
  3. Submit the request.
- Expected output: The system rejects the request and shows an overlap validation error.
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
- Notes: Ensures overlapping leave requests are blocked.

### TC012 – Submit leave with end date before start date
- Description: Verify the system rejects requests where the end date is earlier than the start date.
- Scenario: Employee enters invalid date range.
- Preconditions: Leave request form is accessible.
- Steps:
  1. Open the leave request form.
  2. Set the end date before the start date.
  3. Submit the request.
- Expected output: The system rejects the request and shows an invalid date message.
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
- Notes: Verifies invalid date validation.

### TC013 – Submit leave without required reason
- Description: Verify the system rejects leave requests when the mandatory reason field is empty.
- Scenario: Employee leaves the reason field blank.
- Preconditions: Reason is mandatory for the selected leave type.
- Steps:
  1. Open leave request form.
  2. Leave the reason field blank.
  3. Submit the request.
- Expected output: The system rejects the request and shows a required field error.
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
- Notes: Checks mandatory reason field enforcement.

### TC014 – Manager approves non-direct-report request
- Description: Verify a manager cannot approve a leave request that belongs to someone outside their direct reporting chain.
- Scenario: Manager tries to approve leave for someone outside their team.
- Preconditions: Manager is logged in and the request belongs to another team.
- Steps:
  1. Manager opens a request not assigned to a direct report.
  2. Attempts to approve the request.
- Expected output: The system denies the action and returns an access error.
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
- Notes: Verifies manager authorization and direct-report constraints.

### TC015 – Submit request with invalid leave type
- Description: Verify the system rejects a leave request that uses an unsupported leave type.
- Scenario: Employee selects an unsupported leave type.
- Preconditions: Leave type selection is available.
- Steps:
  1. Open leave request form.
  2. Choose invalid leave type `UndefinedType`.
  3. Submit the request.
- Expected output: The system rejects the request or disables the invalid type.
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

### TC016 – Request creation with missing dates
- Description: Verify the system rejects requests when mandatory date fields are missing.
- Scenario: Employee leaves a date field blank.
- Preconditions: Leave request form is accessible.
- Steps:
  1. Open leave request form.
  2. Leave the start date or end date blank.
  3. Submit the request.
- Expected output: The system rejects the request and highlights the missing date.
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
- Notes: Checks mandatory date validation.

### TC017 – Request creation when entitlement exhausted
- Description: Verify the system prevents leave request creation when the employee has no remaining entitlement.
- Scenario: Employee has no remaining leave entitlement.
- Preconditions: Employee entitlement is zero.
- Steps:
  1. Open leave request form.
  2. Submit a new leave request.
- Expected output: The system rejects the request with an insufficient balance error.
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
- Notes: Verifies entitlement enforcement when balance is exhausted.

### TC018 – Manager rejects already approved request attempt
- Description: Verify the system prevents a manager from rejecting a request that has already been approved.
- Scenario: Manager tries to reject a request that is already approved.
- Preconditions: Request status is `Approved`.
- Steps:
  1. Open an approved request.
  2. Attempt to reject it.
- Expected output: The system prevents the action or returns an invalid state error.
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

### TC019 – Admin creates duplicate leave type
- Description: Verify the system rejects duplicate leave type creation and shows an error for existing leave types.
- Scenario: Admin attempts to create a leave type that already exists.
- Preconditions: A leave type already exists in configuration.
- Steps:
  1. Open leave type administration.
  2. Attempt to create duplicate leave type `Annual`.
- Expected output: The system rejects the duplicate creation and shows a unique type error.
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

## Edge Cases

### TC020 – Submit leave at entitlement boundary
- Description: Verify the system accepts a leave request that exactly matches remaining entitlement.
- Scenario: Employee requests leave equal to remaining entitlement.
- Preconditions: Remaining leave days exactly match the requested duration.
- Steps:
  1. Open leave request form.
  2. Enter dates matching remaining entitlement.
  3. Submit the request.
- Expected output: The system approves the request and uses the remaining entitlement.
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

### TC021 – Submit one-day leave request
- Description: Verify the system accepts a leave request for a single day and records one-day leave correctly.
- Scenario: Employee requests leave for a single day.
- Preconditions: The leave request form is available.
- Steps:
  1. Open leave request form.
  2. Set start and end date to the same day.
  3. Submit the request.
- Expected output: The system accepts the request and records one-day leave.
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

### TC022 – Generate report with no leave requests
- Description: Verify the system handles an empty report period and returns zero counts without errors.
- Scenario: Admin generates a report for a period with no requests.
- Preconditions: No leave requests exist in the selected date range.
- Steps:
  1. Open reporting section.
  2. Select date range 2026-08-01 to 2026-08-31.
  3. Generate the report.
- Expected output: The report returns zero counts and balances.
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

### TC023 – Submit leave request on boundary date
- Description: Verify the system accepts a leave request that starts today and handles boundary date validation.
- Scenario: Employee submits leave request on boundary date.
- Preconditions: Today is allowed as a valid start date.
- Steps:
  1. Open leave request form.
  2. Set start date to today and end date to tomorrow.
  3. Submit the request.
- Expected output: The system accepts the request if allowed and validates dates correctly.
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
