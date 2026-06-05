# Leave Management System — Blue Term Explanations

This document explains the blue-highlighted terms used in `test artifacts/test cases.md` and ties each term back to the business requirements in `skills/claude.ms`.

## Terms

- `Pending`
  - A leave request state after an employee submits the request and before a manager takes action.
  - Matches the requirement that employees can view request status and managers can review pending requests.

- `Annual`
  - A standard leave type defined by an administrator for paid time off.
  - Matches the requirement that administrators can define leave types and manage entitlement values.

- `Vacation`
  - A leave request purpose or test data example for an annual leave request.
  - Supports the employee requirement to submit leave requests with leave type, dates, and reason.

- `Sick`
  - A leave type used for illness-related absence.
  - Matches the administrator requirement to define leave types such as Annual, Sick, and Casual.

- `Medical`
  - A sample reason or leave request detail for Sick leave.
  - Supports business requirements for leave request creation and reason tracking.

- `Approve`
  - The manager action that moves a pending request to approved status.
  - Matches the manager requirement to approve requests with optional comments and record decisions.

- `Approved`
  - A final request state after manager approval.
  - Matches the requirement that employees can view request status as Approved and that the system adjusts balances upon approval.

- `Reject`
  - The manager action that denies a leave request.
  - Matches the manager requirement to reject leave requests with optional comments and to enforce authorization rules.

- `Rejected`
  - A final request state after manager rejection.
  - Matches the requirement that employees can view request status as Rejected and that rejected requests do not change balances.

- `Compassionate`
  - An example leave type that an administrator can create for special leave.
  - Matches the requirement that administrators can define new leave types and entitlement settings.

- `UndefinedType`
  - A deliberately invalid leave type used to verify validation logic.
  - Matches the functional requirement that the system rejects unsupported leave types.
